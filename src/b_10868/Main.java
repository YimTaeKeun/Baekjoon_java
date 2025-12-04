package b_10868;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] segmentArr;
    public static int k;
    public static int numberCnt;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberCnt = Integer.parseInt(st.nextToken());
        int qCnt = Integer.parseInt(st.nextToken());
        setK(numberCnt);
        initSegmentArr();
        for(int i = 0; i < qCnt; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            bw.write(findMinValue(from, to) + "\n");
        }
        bw.flush();

    }

    public static void initSegmentArr() throws IOException {
        int initStartIdx = (int) Math.pow(2, k);
        segmentArr = new int[initStartIdx * 2];
        Arrays.fill(segmentArr, Integer.MAX_VALUE);
        for(int i = initStartIdx; i < initStartIdx + numberCnt; i++) segmentArr[i] = Integer.parseInt(br.readLine());
        for(int i = initStartIdx + numberCnt - 1; i > 1; i--){
            segmentArr[i / 2] = Math.min(segmentArr[i / 2], segmentArr[i]);
        }
    }

    public static int changeToSegmentIndex(int queryIndex){
        // 요청 인덱스를 실제 세그먼트 상의 리프 노드 인덱스로 바꿉니다.
        return queryIndex + (int) Math.pow(2, k) - 1;
    }

    public static int findMinValue(int startIndex, int endIndex){
        // 세그먼트 트리에서 실제 최솟값을 찾습니다.
        int result = Integer.MAX_VALUE;
        startIndex = changeToSegmentIndex(startIndex);
        endIndex = changeToSegmentIndex(endIndex);
        while(startIndex <= endIndex){
            if(startIndex % 2 == 1) result = Math.min(result, segmentArr[startIndex]);
            if(endIndex % 2 == 0) result = Math.min(result, segmentArr[endIndex]);
            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }
        return result;
    }

    public static void setK(int n){
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }
}
