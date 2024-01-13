package b_1654;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int prevLanCnt = Integer.parseInt(temp[0]);
        long toMakeCnt = Long.parseLong(temp[1]);
        List<Long> lans = new ArrayList<>(), results = new ArrayList<>();
        for(int i = 0; i < prevLanCnt; i++) lans.add(Long.parseLong(br.readLine()));
        lans.sort(null);
        long[] minMax = new long[] {1, lans.get(lans.size() - 1) + 1};
        while(minMax[0] != minMax[1]){
            long middle = binarySearch(minMax);
            long tempCnt = 0;
            for(Long each: lans) tempCnt += each / middle;
            if(tempCnt >= toMakeCnt && minMax[0] + 1 != minMax[1]){
                minMax[0] = middle;
                results.add(middle);
            }
            else minMax[1] = middle;
        }
        if(results.size() == 0) System.out.println(1);
        else System.out.println(Collections.max(results));
    }
    static long binarySearch(long[] minMax){
        return (minMax[0] + minMax[1]) / 2;
    }
}
