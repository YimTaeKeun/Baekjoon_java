package b_18438;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String one = br.readLine();
        String two = br.readLine();
        String result = hirschberg(one, two);
        bw.write(result.length() + "\n");
        bw.write(result + "\n");
        bw.flush();
    }

    public static String hirschberg(String a, String b) {
        if(a.isEmpty() || b.isEmpty()) return "";
        if(a.length() == 1) {
            if(b.contains(a)) return a;
            else return "";
        }
        if(b.length() == 1) {
            if(a.contains(b)) return b;
            else return "";
        }

        int mid = a.length()/2;
        String aLeft = a.substring(0, mid);
        String aRight = a.substring(mid);

        // backward: aLeft와 b를 이용
        int[] forward = getLcsLastRow(aLeft, b);
        String aRightReverse = reverseString(aRight);
        String bReverse = reverseString(b);
        int[] backward = getLcsLastRow(aRightReverse, bReverse);
        int[] backwardReverse = reverseArray(backward);

        int maxLen = -1;
        int k = 0;
        for(int i = 0; i <= b.length(); i++){
            if(forward[i] + backwardReverse[i] > maxLen){
                maxLen = forward[i] + backwardReverse[i];
                k = i;
            }
        }
        String bLeft = b.substring(0, k);
        String bRight = b.substring(k);

        String lcsLeft = hirschberg(aLeft, bLeft);
        String lcsRight = hirschberg(aRight, bRight);

        return lcsLeft + lcsRight;




    }

    public static int[] getLcsLastRow(String a, String b){
        // lcs 계산의 가장 마지막 행을 가져옵니다.
        int[] prev = new int[b.length() + 1];
        int[] curr = new int[b.length() + 1];
        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1)) curr[j] = prev[j-1] + 1;
                else curr[j] = Math.max(curr[j-1], prev[j]);
            }
            prev = copyArray(curr);
            curr = new int[b.length() + 1];
        }
        return prev;
    }

    public static int[] copyArray(int[] arr){
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) temp[i] = arr[i];
        return temp;
    }

    public static int[] reverseArray(int[] arr){
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) temp[i] = arr[arr.length - 1 - i];
        return temp;
    }

    public static String reverseString(String s){
        String temp = "";
        for(int i = s.length() - 1; i >= 0; i--) temp += s.charAt(i);
        return temp;
    }
}
