package b_11505;

import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n; // 원소 개수
    public static int k; // 최소 2^k
    public static long[] segmentArr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int changeCnt = Integer.parseInt(st.nextToken());
        int printCnt = Integer.parseInt(st.nextToken());
        setK();
        initSegmentArr();
        for(int i = 0; i < changeCnt + printCnt; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 1) changeLeafNode(a, b);
            else if(cmd == 2){
                bw.write(findResult(a, b) + "\n");
            }
        }
        bw.flush();

    }
    public static void setK(){
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }

    public static int changeToSegmentIdx(int queryIdx){
        return queryIdx + (int) Math.pow(2, k) - 1;
    }

    public static void changeLeafNode(int idx, int value){
        idx = changeToSegmentIdx(idx);
        segmentArr[idx] = value;
        for(int i = idx; i > 1; i /= 2){
            long target;
            if(i % 2 == 1) target = segmentArr[i - 1];
            else target = segmentArr[i + 1];
            segmentArr[i / 2] = segmentArr[i] * target % 1000000007;
        }
    }

    public static long findResult(int startIndex, int endIndex){
        long result = 1;
        startIndex = changeToSegmentIdx(startIndex);
        endIndex = changeToSegmentIdx(endIndex);
        while(startIndex <= endIndex){
            if(startIndex % 2 == 1) result = (result % 1000000007 * segmentArr[startIndex] % 1000000007) % 1000000007;
            if(endIndex % 2 == 0) result = (result % 1000000007 * segmentArr[endIndex] % 1000000007) % 1000000007;
            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }
        return result % 1000000007;
    }

    public static void initSegmentArr() throws IOException {
        int s = (int) Math.pow(2, k);
        segmentArr = new long[s * 2];
        Arrays.fill(segmentArr, 1);
        for(int i = s; i < s + n; i++){
            segmentArr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = s + n - 1; i > 1; i--){
            segmentArr[i / 2] = (segmentArr[i / 2] * segmentArr[i]) % 1000000007;
        }
    }
}
