package b_1306;

import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int k; // 2 ^ k에 해당하는 최소값 k
    public static long[] segmentArr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int scope = Integer.parseInt(st.nextToken());
        initSegmentTree(); // 세그먼트 트리 초기화
        for(int i = scope - 1; i < n - scope + 1; i++){
            bw.write(getMax(i - (scope - 1) + 1, i + scope) + " ");
        }
        bw.flush();
    }

    public static void setK(){
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }

    public static void initSegmentTree() throws IOException {
        setK();
        int s = (int)Math.pow(2, k);
        segmentArr = new long[s * 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = s; i < s + n; i++) segmentArr[i] = Long.parseLong(st.nextToken());
        for(int i = s + n - 1; i > 1; i--) segmentArr[i / 2] = Math.max(segmentArr[i / 2], segmentArr[i]);
    }

    public static int changeToSegmentIdx(int queryIdx){
        return queryIdx + (int) Math.pow(2, k) - 1;
    }

    public static long getMax(int startIdx, int endIdx){
        startIdx = changeToSegmentIdx(startIdx);
        endIdx = changeToSegmentIdx(endIdx);
        long result = 0;
        while(startIdx <= endIdx){
            if(startIdx % 2 == 1) result = Math.max(result, segmentArr[startIdx]);
            if(endIdx % 2 == 0) result = Math.max(result, segmentArr[endIdx]);
            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        return result;
    }
}
