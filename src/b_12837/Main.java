package b_12837;

import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int k;
    public static long[] segTree;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int qCnt = Integer.parseInt(st.nextToken());
        initSegTree();
        for(int i = 0; i < qCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 1) addDate(a, b);
            else if(cmd == 2) bw.write(getSum(a, b) + "\n");
        }
        bw.flush();
    }

    public static void setK(){
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }

    public static void initSegTree(){
        setK();
        int s = (int) Math.pow(2, k);
        segTree = new long[s * 2];
    }

    public static int changeToSegIdx(int queryIdx){
        return queryIdx + (int) Math.pow(2, k) - 1;
    }

    public static void addDate(int at, long value){
        at = changeToSegIdx(at);
        segTree[at] += value;
        for(int i = at; i > 1; i /= 2){
            segTree[i / 2] += value;
        }
    }

    public static long getSum(int startIdx, int endIdx){
        startIdx = changeToSegIdx(startIdx);
        endIdx = changeToSegIdx(endIdx);
        long result = 0;
        while(startIdx <= endIdx){
            if(startIdx % 2 == 1) result += segTree[startIdx];
            if(endIdx % 2 == 0) result += segTree[endIdx];
            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        return result;
    }
}
