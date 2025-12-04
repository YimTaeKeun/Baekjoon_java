package b_2042;

import java.util.*;
import java.io.*;
// 세그먼트 트리 풀이
public class Main {
    public static long[] segmentArr;
    public static int k;
    public static int N;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int changeCnt = Integer.parseInt(st.nextToken());
        int printCnt = Integer.parseInt(st.nextToken());
        setK(N); // 리프노드 갯수 이상을 만족하는 2^k에서 k를 찾음
        setSegmentArray(); // 세그먼트 초기화
        for(int i = 0; i < changeCnt + printCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if(cmd == 1) changeNumber(a, b);
            else if(cmd == 2){
                bw.write(getSumSegment(a, (int) b) + "\n");
            }
        }
        bw.flush();
    }

    public static void setK(int n){
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }

    public static void setSegmentArray() throws IOException {
        int s = (int) Math.pow(2, k);
        segmentArr = new long[s * 2];
        for(int i = s; i < s + N; i++) segmentArr[i] = Long.parseLong(br.readLine()); // 초기 집합 저장
        for(int i = s + N - 1; i > 1; i--){
            segmentArr[i / 2] += segmentArr[i];
        }
    }

    public static void changeNumber(int index, long number){ // 숫자 변환
        // 부모까지 다 바꿔야함
        index = convertToSegmentIndex(index);
        long prev = segmentArr[index];
        long diff = number - prev;
        for(int i = index; i > 0; i /= 2){
            segmentArr[i] += diff;
        }
        segmentArr[index] = number;
    }

    public static int convertToSegmentIndex(int queryIndex){
        return queryIndex + (int) Math.pow(2, k) - 1;
    }

    public static long getSumSegment(int startIndex, int endIndex){
        startIndex = convertToSegmentIndex(startIndex);
        endIndex = convertToSegmentIndex(endIndex);
        long result = 0;
        while(startIndex <= endIndex){
            if(startIndex % 2 == 1) result += segmentArr[startIndex];
            if(endIndex % 2 == 0) result += segmentArr[endIndex];
            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }
        return result;
    }
}
