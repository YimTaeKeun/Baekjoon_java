package b_10989;

import java.io.*;
import java.util.Arrays;
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int[] cal = new int[Integer.parseInt(br.readLine())];
//        for(int i = 0; i < cal.length; i++) cal[i] = Integer.parseInt(br.readLine());
//        Arrays.sort(cal);
//        for(int each: cal) bw.write(each + "\n");
//        bw.flush();
//        bw.close();
//    }
//}

/**
 * 20251101 계수 정렬을 이용한 풀이
 * */

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i = 0; i < N; i++) arr[Integer.parseInt(br.readLine())]++;
        for(int i = 1; i <= 10000; i++) {
            if(arr[i] == 0) continue;
            for(int j = 1; j <= arr[i]; j++) bw.write(i + "\n");
        }
        bw.flush();
    }
}