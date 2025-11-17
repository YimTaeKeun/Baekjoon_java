package b_1672;

import java.io.*;
import java.util.*;

public class Main{
    // AGCT 각각 0123
    public static int[][] info = new int[][]{
            {0, 2, 0, 1},
            {2, 1, 3, 0},
            {0, 3, 2, 1},
            {1, 0, 1, 3}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] target = br.readLine().toCharArray();
        for(int cursor = n - 1; cursor > 0; cursor--){
            int nowInt = convertCharToInt(target[cursor]);
            int prevInt = convertCharToInt(target[cursor - 1]);
            target[cursor - 1] = convertIntToChar(info[prevInt][nowInt]);
        }
        bw.write(target[0] + "\n");
        bw.flush();
    }
    public static int convertCharToInt(char ch){
        if(ch == 'A') return 0;
        else if(ch == 'G') return 1;
        else if(ch == 'C') return 2;
        return 3;
    }
    public static char convertIntToChar(int i){
        if(i == 0) return 'A';
        else if(i == 1) return 'G';
        else if(i == 2) return 'C';
        else return 'T';
    }
}