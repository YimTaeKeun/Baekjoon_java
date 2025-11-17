package b_1747;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (!isPalindrome(String.valueOf(N)) || !isPrime(N)) {
            N++;
        }
        bw.write(N + "\n");
        bw.flush();
    }
    public static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }
    public static boolean isPrime(int target){
        if(target == 1) return false;
        for(int i = 2; i <= Math.sqrt(target); i++) {
            if(target % i == 0) return false;
        }
        return true;
    }
}
