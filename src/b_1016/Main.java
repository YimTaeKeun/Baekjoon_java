package b_1016;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        long min = Long.parseLong(temp[0]);
        long max = Long.parseLong(temp[1]);

        ArrayList<Integer> pL = new ArrayList<>(); // 소수들 리스트 입니다.
        boolean[] p = getPrimeList((int) Math.sqrt(max));
        for(int i = 1; i < p.length; i++) if(p[i]) pL.add(i);
        boolean[] NoNoPowList = new boolean[(int)(max-min+1)];
        Arrays.fill(NoNoPowList, true);
        for(int i = 0; i < pL.size(); i++) {
            long primePow = (long)pL.get(i) * pL.get(i);
            for(long j = min / primePow; j * primePow <= max ; j++){
                if(j * primePow < min) continue;
                NoNoPowList[(int)(primePow * j - min)] = false;
                if((j + 1) * primePow < j * primePow) break;
            }
        }

        int count = 0;
        for(int i = 0; i < NoNoPowList.length; i++) if(NoNoPowList[i]) count++;
        bw.write(count + "\n");
        bw.flush();

    }

    public static boolean[] getPrimeList(int max){
        boolean[] primeList = new boolean[max+1];
        Arrays.fill(primeList, true);
        primeList[1] = false;
        for(int i = 2; i <= max; i++){
            for(int j = 2; j * i <= max; j++){
                primeList[j * i] = false;
            }
        }
        return primeList;
    }
}
