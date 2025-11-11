package b_16139;

import java.util.*;
import java.io.*;

public class Main {
    public static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine();
        int qn = Integer.parseInt(br.readLine());
        // 처리
        List<Integer[]> sumList = new ArrayList<>();
        for(int i = 0; i <= s.length(); i++) {
            Integer[] temp = new Integer[26];
            for(int j = 0; j < 26; j++) temp[j] = 0;
            sumList.add(temp);
        }
        calculateSumList(sumList);
        for(int i = 0; i < qn; i++){
            String[] temp = br.readLine().split(" ");
            int targetCharAt = temp[0].charAt(0) - 'a';
            int start = Integer.parseInt(temp[1]) + 1;
            int end = Integer.parseInt(temp[2]) + 1;
            bw.write(String.valueOf(sumList.get(end)[targetCharAt] - sumList.get(start - 1)[targetCharAt]) + "\n");
        }
        bw.flush();
    }
    public static void calculateSumList(List<Integer[]> sumList){
        for(int i = 1; i <= s.length(); i++){
            // i는 string 위치 + 1
            Integer[] prevInfo = sumList.get(i - 1);
            Integer[] currInfo = sumList.get(i);
            for(int j = 0; j < 26; j++) currInfo[j] = prevInfo[j]; // 이전까지의 합 복사
            currInfo[s.charAt(i - 1) - 'a']++;
        }
    }
}
