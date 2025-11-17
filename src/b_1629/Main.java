package b_1629;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int A = Integer.parseInt(temp[0]), B = Integer.parseInt(temp[1]), C = Integer.parseInt(temp[2]);
        long t = A % C;
        long prev = t;
        for(int i = 1; i < B; i++){
            t *= A;
            t %= C;
            if(prev == t) break;
            prev = t;
        }
        bw.write(prev+"\n");
        bw.flush();
    }
}
