package b_1074;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]), r = Integer.parseInt(temp[1]), c = Integer.parseInt(temp[2]);
        long cnt = 0;
        int startRow = 0, startCol = 0;
        while(N > 0) {
            int a = (int) Math.pow(2, N); // 한 행의 열 갯수
            if(r >= startRow + a / 2){
                startRow += a / 2;
                cnt += (long) a * (a / 2);
            }
            if(c >= startCol + a / 2){
                startCol += a / 2;
                cnt += (long) a * a / 4;
            }
            N--;
        }
        bw.write(cnt + "\n");
        bw.flush();

    }
}
