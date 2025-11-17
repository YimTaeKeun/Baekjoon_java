package b_1456;

import java.io.*;
import java.util.*;
// root 이용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        Map<Integer, Boolean> map = new HashMap<>();
        long s = Long.parseLong(temp[0]);
        long e = Long.parseLong(temp[1]);
        boolean[] primeList = new boolean[10000001];
        Arrays.fill(primeList, true);
        int count = 0;
        // e의 제곱근 이하까지 소수를 모두 구함
        for(int i = 2; i <= Math.sqrt(e); i++){
            if(primeList[i]){
                for(int j = 2; j * i <= Math.sqrt(e); j++) {
                    primeList[j * i] = false;
                }
            }
        }
        for(int i = 2; i <= Math.sqrt(e); i++){
            if(primeList[i]){
                for(long j = i * (long)i; j <= e; j *= i) {
                    if(j >= s) count++;
                    if(j > e/i) break;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }
}
