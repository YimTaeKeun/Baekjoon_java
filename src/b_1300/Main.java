package b_1300;

import java.util.*;
import java.io.*;

public class Main {
    public static Long N;
    public static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine()); // k 번째 자리를 찾습니다.
        long result = binarySearch(1, N * N);
        bw.write(result + "\n");
        bw.flush();
    }
    public static long binarySearch(long start, long end){
        while(start <= end){ // start가 더 커질 때 종료
            long mid = (start + end) / 2; // 여기서 중앙값은 인덱스 (k번째)를 의미하는게 아닌 값을 말하는거
            // k 번째 수는 k보다 작거나 같다.
            long cnt = howManySmallThanParameter(mid);
            // k 보다 많은 수를 포함할 수 있거나 딱 k번쨰까지 포함가능하다면
            if(cnt >= k) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
    public static long howManySmallThanParameter(long target){
        // 각 행에서 target보다 작거나 같은 수를 계산
        long sum = 0;
        for(int i = 1; i <= N; i++){
            sum += Math.min(N, target / i);
        }
        return sum;
    }
}
