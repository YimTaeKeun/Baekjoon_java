package b_13711;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] oneArr = new int[n], twoArr = new int[n]; // 숫자 저장 배열
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < n; i++) oneArr[i] = Integer.parseInt(temp[i]);
        temp = br.readLine().split(" ");
        for(int i = 0; i < n; i++) twoArr[i] = Integer.parseInt(temp[i]);
        // lcs 시작
        int[][] lcs = new int[2][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(oneArr[i - 1] == twoArr[j - 1]) lcs[1][j] = lcs[0][j-1] + 1;
                else lcs[1][j] = Math.max(lcs[0][j], lcs[1][j-1]);
                for(int k = 0; k <= n; k++) lcs[0][k] = lcs[1][k];
            }
        }
        bw.write(lcs[1][n] + "\n");
        bw.flush();
    }
}
