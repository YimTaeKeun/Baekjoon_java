package b_1541;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String targetString = br.readLine();
        boolean flag = false;
        String temp = ""; // 여기에 변환 전 스트링 저장
        long result = 0;
        for(int i = 0; i < targetString.length(); i++){
            // String을 검사합니다.
            char now = targetString.charAt(i);
            if(now == '+' || now == '-'){
                int value = Integer.parseInt(temp);
                temp = "";
                if(flag) result -= value;
                else result += value;
                if(now == '-') flag = true;
            }
            else temp += now;

        }
        if(!temp.isBlank()){
            int value = Integer.parseInt(temp);
            if(flag) result -= value;
            else result += value;
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
