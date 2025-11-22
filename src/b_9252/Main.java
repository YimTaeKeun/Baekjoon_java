package b_9252;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String one = br.readLine(), two = br.readLine();
        int[][] lcs = new int[one.length() + 1][two.length() + 1];
        for(int i = 1; i <= one.length(); i++){
            for(int j = 1; j <= two.length(); j++){
                if(one.charAt(i-1) == two.charAt(j-1)) lcs[i][j] = lcs[i-1][j-1] + 1;
                else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
        bw.write(lcs[one.length()][two.length()] + "\n");
        // 탐색 시작
        Stack<Character> stack = new Stack<>();
        int startRow = one.length(), startCol = two.length();
        while(lcs[startRow][startCol] != 0){
            // 위 탐색
            if(lcs[startRow - 1][startCol] == lcs[startRow][startCol]){
                startRow--;
                continue;
            }
            // 왼쪽 탐색
            if(lcs[startRow][startCol - 1] == lcs[startRow][startCol]){
                startCol--;
                continue;
            }
            stack.push(one.charAt(startRow - 1));
            startRow--;
            startCol--;
        }
        while(!stack.isEmpty()){
            bw.write(stack.pop() + "");
        }
        bw.flush();
    }
}
