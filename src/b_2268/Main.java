package b_2268;

import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int k;
    public static long[] segmentArr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int qCnt = Integer.parseInt(st.nextToken());
        initSegmentArr();
        for(int i = 0; i < qCnt; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 0) bw.write(sum(a, b) + "\n");
            else if(cmd == 1) modify(a, b);
        }
        bw.flush();
    }

    public static void setK(){
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }

    public static void initSegmentArr(){
        setK();
        int s = (int) Math.pow(2, k);
        segmentArr = new long[s * 2];
    }

    public static int changeToSegmentIdx(int queryIdx){
        return queryIdx + (int) Math.pow(2, k) - 1;
    }

    public static void modify(int queryIdx, long value){
        queryIdx = changeToSegmentIdx(queryIdx);
        long diff = value - segmentArr[queryIdx];
        segmentArr[queryIdx] = value;
        for(int i = queryIdx; i > 1; i /= 2){
            segmentArr[i / 2] += diff;
        }
    }

    public static long sum(int startIdx, int endIdx){
        if(startIdx > endIdx){
            int temp = startIdx;
            startIdx = endIdx;
            endIdx = temp;
        }
        startIdx = changeToSegmentIdx(startIdx);
        endIdx = changeToSegmentIdx(endIdx);
        long result = 0;
        while(startIdx <= endIdx){
            if(startIdx % 2 == 1) result += segmentArr[startIdx];
            if(endIdx % 2 == 0) result += segmentArr[endIdx];
            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        return result;
    }
}
