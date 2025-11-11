package b_1038;

import java.util.*;
import java.io.*;

public class Main {
    public static int nowResult = -1;
    public static int n;
    public static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        if(n >= 1023){
            bw.write("-1\n");
        }
        else{
            for(int jaritsu = 1; ; jaritsu++){
                List<Integer> list = new ArrayList<>();
                backTracking(0, jaritsu, list);
                if(nowResult == n) break;
            }
            bw.write(result+"\n");
        }
        bw.flush();
    }
    public static void backTracking(int nowJaritsu, int targetJaritsu, List<Integer> arr){
        if(nowResult == n) return;
        if(nowJaritsu == targetJaritsu){
            result = "";
            for(int i = 0; i < arr.size(); i++) result += String.valueOf(arr.get(i));
            nowResult++;
            return;
        }
        for(int i = 0; i < 10; i++){
            if(arr.isEmpty() || arr.get(arr.size() - 1) > i){
                arr.add(i);
                backTracking(nowJaritsu + 1, targetJaritsu, arr);
                if(nowResult == n) break;
                arr.remove(arr.size() - 1);
            }
        }
    }

}