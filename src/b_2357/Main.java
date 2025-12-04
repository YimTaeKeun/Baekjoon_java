package b_2357;

import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] maxSegmentArr, minSegmentArr;
    public static int n; // 원소 갯수
    public static int k; // 최소 2^k
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int qCnt = Integer.parseInt(st.nextToken());
        setK();
        initSegmentArr();
        for(int i = 0; i < qCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            printMinMaxInSegment(start, end);
        }
        bw.flush();

    }

    public static int changeToSegmentIndex(int queryIdx){
        return queryIdx + (int) Math.pow(2, k) - 1;
    }

    public static void printMinMaxInSegment(int from, int to) throws IOException{
        int resultMax = 0, resultMin = Integer.MAX_VALUE;
        from = changeToSegmentIndex(from);
        to = changeToSegmentIndex(to);
        while(from <= to){
            if(from % 2 == 1){
                resultMax = Math.max(resultMax, maxSegmentArr[from]);
                resultMin = Math.min(resultMin, minSegmentArr[from]);
            }
            if(to % 2 == 0){
                resultMax = Math.max(resultMax, maxSegmentArr[to]);
                resultMin = Math.min(resultMin, minSegmentArr[to]);
            }
            from = (from + 1) / 2;
            to = (to - 1) / 2;
        }
        bw.write(resultMin + " " + resultMax + "\n");
    }

    public static void setK(){
        // n보다 크거나 같은 2^k에서 k를 세팅합니다.
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }

    public static void initSegmentArr() throws IOException {
        int s = (int) Math.pow(2, k);
        maxSegmentArr = new int[s * 2];
        minSegmentArr = new int[s * 2];
        Arrays.fill(minSegmentArr, Integer.MAX_VALUE);
        Arrays.fill(maxSegmentArr, Integer.MIN_VALUE);
        for(int i = s; i < s + n; i++){
            int a = Integer.parseInt(br.readLine());
            maxSegmentArr[i] = a;
            minSegmentArr[i] = a;
        }
        for(int i = s + n - 1; i > 1; i--){
            maxSegmentArr[i / 2] = Math.max(maxSegmentArr[i / 2], maxSegmentArr[i]);
            minSegmentArr[i / 2] = Math.min(minSegmentArr[i / 2], minSegmentArr[i]);
        }
    }
}
