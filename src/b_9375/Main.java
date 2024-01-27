package b_9375;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = Integer.parseInt(br.readLine()); tc > 0; tc--){
            Map<String, Integer> map = new HashMap<>();
            int wearableCnt = Integer.parseInt(br.readLine());
            String[] temp;
            long result = 1;
            for(int i = 0; i < wearableCnt; i++){
                temp = br.readLine().split(" ");
                if(map.get(temp[1]) == null) map.put(temp[1], 2);
                else map.put(temp[1], map.get(temp[1]) + 1);
            }
            for(Integer each: map.values()) result *= each;
            System.out.println(result - 1);
        }
    }
}
