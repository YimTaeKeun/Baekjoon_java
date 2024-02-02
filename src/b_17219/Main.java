package b_17219;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        Map<String, String> map = new HashMap<>();
        int cnt = Integer.parseInt(temp[0]), findCnt = Integer.parseInt(temp[1]);
        for(int i = 0; i < cnt; i++){
            temp = br.readLine().split(" ");
            map.put(temp[0], temp[1]);
        }
        for(int i = 0; i < findCnt; i++) sb.append(map.get(br.readLine()) + "\n");
        System.out.println(sb);
    }
}
