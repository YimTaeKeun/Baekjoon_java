package b_30089;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        String temp;
        for(int i = 0; i < tc; i++) {
            temp = br.readLine();
            for(int j = 0; j < temp.length(); j++) {
                if(!isPalindrome(temp.substring(j))) stack.push(temp.charAt(j));
                else break;
            }
            bw.write(temp);
            while(!stack.isEmpty()) {
                bw.write(stack.pop());
            }
            bw.newLine();
        }
        bw.flush();
    }
    public static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }
        return true;
    }
}
