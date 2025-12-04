package b_1275;

import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int k; // 2^k의 최소 k
    public static long[] segmentArr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int qCnt = Integer.parseInt(st.nextToken());
        initSegmentArr(); // 세그먼트 트리 초기화
        for(int i = 0; i < qCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s > e){
                int temp = e;
                e = s;
                s = temp;
            }
            int targetIdx = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            bw.write(getSegSum(s, e) + "\n");
            changeNode(targetIdx, value);
        }
        bw.flush();
    }

    public static void setK(){
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }

    public static void initSegmentArr() throws IOException {
        setK(); // k값 설정
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = (int)Math.pow(2, k);
        segmentArr = new long[s * 2];
        for(int i = s; i < s + n; i++) segmentArr[i] = Long.parseLong(st.nextToken());
        for(int i = s + n - 1; i > 1; i--) segmentArr[i / 2] += segmentArr[i]; // 부모 노드에 더해줌
    }

    public static void changeNode(int idx, long value){
        idx = changeToSegmentIdx(idx);
        long diff = value - segmentArr[idx];
        segmentArr[idx] += diff;
        for(int i = idx; i > 1; i /= 2) segmentArr[i / 2] += diff;
    }

    public static long getSegSum(int startIdx, int endIdx){
        startIdx = changeToSegmentIdx(startIdx);
        endIdx = changeToSegmentIdx(endIdx);
        long sum = 0;
        while(startIdx <= endIdx){
            if(startIdx % 2 == 1) sum += segmentArr[startIdx];
            if(endIdx % 2 == 0) sum += segmentArr[endIdx];
            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        return sum;
    }

    public static int changeToSegmentIdx(int queryIdx){
        return queryIdx + (int) Math.pow(2, k) - 1;
    }
}
