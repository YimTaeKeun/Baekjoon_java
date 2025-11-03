package b_2018;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int result = 0;
        for (int i = 0; i < N + 1; i++) arr[i] = i;
        for(int i = 1; i < N + 1; i++){
            if(arr[i] == N){
                result++;
                continue;
            }
            long sum = arr[i];
            for(int j = i + 1; j < N + 1; j++){
                if(sum + arr[j] == N){
                    result++;
                    break;
                }
                else if(sum + arr[j] > N) break;
                sum += arr[j];
            }
        }
        bw.write(result+"\n");
        bw.flush();

    }
}
