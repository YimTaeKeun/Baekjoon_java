package b_16114;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int x = Integer.parseInt(temp[0]), n = Integer.parseInt(temp[1]);
        if (n == 1) bw.write((x >= 0) ? "0\n" : "INFINITE\n");
        else if(n % 2 == 1) bw.write("ERROR\n");
        else if(x <= 0) bw.write("0\n");
        else if(n == 0) bw.write("INFINITE\n");
        else{
            int count = 0;
            x -= n / 2;
            for(int i = x; x > 0; x -= n / 2) count++;
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
