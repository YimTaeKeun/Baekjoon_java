package b_11689;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        boolean[] primeList = getPrimeList((int) Math.sqrt(N));
        Map<Long, Integer> map = new HashMap<>();
        long result = 1;
        for(int i = 2; i < primeList.length; i++){
            if(primeList[i] && N % i == 0){
                if(!map.containsKey((long) i)) map.put((long) i, 1);
                N /= i;
                while(N % i == 0){
                    map.put((long) i, map.get((long) i) + 1);
                    N /= i;
                }
            }
        }
        if(N > 1) map.put(N, 1);
        for(Map.Entry<Long, Integer> entry : map.entrySet()){
            result *= primePhi(entry.getKey(), entry.getValue());
        }
        bw.write(result+"\n");
        bw.flush();
    }
    public static long primePhi(long p, int powNum){
        // 소수 p에 대한 피를 구합니다.
        if(powNum == 1) return p - 1;
        return (long) (Math.pow(p, powNum) - Math.pow(p, powNum - 1));
    }
    public static boolean[] getPrimeList(int max){
        boolean[] primeList = new boolean[max+1];
        Arrays.fill(primeList, true);
        primeList[1] = false;
        for(int i = 2; i <= max; i++){
            if(primeList[i]){ // 소수 발견
                for(int j = 2; j * i <= max; j++) primeList[i * j] = false;
            }
        }
        return primeList;
    }
}
