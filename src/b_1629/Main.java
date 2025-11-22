package b_1629;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        long A = Integer.parseInt(temp[0]), B = Integer.parseInt(temp[1]), C = Integer.parseInt(temp[2]);
        System.out.println(mul(A, B, C));
    }
    public static long mul(long x, long y, long z){
        if(x == z || z == 1 || x == 0) return 0;
        if(x == 1) return 1;
        if(y == 1) return x % z;
        long div = x;
        int count = 1;
        while(div < z) {
            div *= x;
            count++;
        }
        if(count > y) return ((long) Math.pow(x, y)) % z;
        return mul(div % z, y / count, z) * (long) Math.pow(x, y % count) % z;
    }
}
