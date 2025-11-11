package b_2343;

import java.io.*;
import java.util.*;

// 이분 탐색 대상은 주어진 array가 아닌 그 array로 부터 도출된 값들로 부터 나오는 것일 수 있다.
// 그러니 그 array를 대상으로 이분탐색을 해야겠다는 고정 관념은 가지지 말 것
public class Main {
    public static int blueRayCnt;
    public static int totalSum;
    public static List<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lessonCnt = Integer.parseInt(st.nextToken()); // 레슨 수
        blueRayCnt = Integer.parseInt(st.nextToken()); // 블루레이 수
        st = new StringTokenizer(br.readLine());
        // max 와 total sum만 있으면 됨
        long max = 0;
        totalSum = 0; // 최종 합
        for(int i = 0; i < lessonCnt; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr.add(now);
            max = Math.max(max, now); // max에 max 저장
            totalSum += now;
        }
        // max와 totalSum 사이 이분 탐색 만약 max > totalSum이라면 while문 종료
        long result = binarySearch(max, totalSum);
        bw.write(result + "\n");
        bw.flush();
    }

    public static long binarySearch(long left, long right){
        while(left <= right){
            long mid = (left + right)/2;
            // 최솟값으로 mid로 설정했을 때 블루레이 갯수 판별하기
            int sum = 0, count = 0;
            for(int i = 0; i < arr.size(); i++){
                if(sum + arr.get(i) > mid){
                    count++;
                    sum = 0;
                }
                sum += arr.get(i);
            }
            if(sum != 0) count++;
            if(count > blueRayCnt) left = mid+1;
            else right = mid - 1; // 지정된 블루에이의 갯수와 같이 사용하거나 더 많은 블루레이가 필요하다면
        }
        return left;

    }
}
