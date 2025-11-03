package b_2018;

import java.util.*;
import java.io.*;
// 생각보다 무식하게 풀어보기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        if(N == 1 || N == 2) bw.write("1");
        else{
            List<Long> list = new ArrayList<>();
            list.add(0L);
            long result = 1;
            long max = sumOneToN(N);
            for(long i = 1; i <= N/2 + 1; i++) list.add(sumOneToN(i));
            for(int i = 0; i < list.size(); i++){
                long value = list.get(i);
                long searchTargetValue = value + N;
                if(searchTargetValue > max) continue;

                if(isThereInArr(list, searchTargetValue)) result++;
            }
            bw.write(String.valueOf(result));
        }
        bw.flush();
    }
    public static long sumOneToN(long N) {
        return N * (N + 1) / 2;
    }
    public static boolean isThereInArr(List<Long> arr, long value){
        // binary search
        int sIdx = 0;
        int eIdx = arr.size() - 1;
        while(true){
            if(sIdx > eIdx) return false;

            int mid = (sIdx + eIdx)/2;
            if(arr.get(mid) == value) return true;
            if(arr.get(mid) > value) eIdx = mid-1;
            else if(arr.get(mid) < value) sIdx = mid+1;
        }
    }
}
