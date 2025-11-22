package b_1958;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();
        bw.write(lcs(lcs(one, two), three).length() + "\n");
        bw.flush();
    }
    public static String lcs(String a, String b) {
        int[][] lcsArr = new int[a.length() + 1][b.length() + 1];
        for(int i = 1; i <= a.length(); i++) {
            for(int j = 1; j <= b.length(); j++) {
                if(b.charAt(j - 1) == a.charAt(i - 1)) lcsArr[i][j] = lcsArr[i - 1][j - 1] + 1;
                else lcsArr[i][j] = Math.max(lcsArr[i - 1][j], lcsArr[i][j - 1]);
            }
        }
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int row = a.length(), col = b.length();
        while(lcsArr[row][col] != 0){
            if(lcsArr[row][col] == lcsArr[row - 1][col]){
                row--;
                continue;
            }
            if(lcsArr[row][col] == lcsArr[row][col - 1]){
                col--;
                continue;
            }
            stack.push(a.charAt(row - 1));
            row--;
            col--;
        }
        while(!stack.isEmpty()) result.append(stack.pop());
        return result.toString();
    }
}
