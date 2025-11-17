package b_1929;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int start = Integer.parseInt(temp[0]);
        int end = Integer.parseInt(temp[1]);
        for(int i = start; i <= end; i++){
            if(isPrime(i)) bw.write(i + "\n");
        }
        bw.flush();
    }
    public static boolean isPrime(int target){
        if(target == 1) return false;
        for(int i = 2; i <= Math.sqrt(target); i++){
            if(target % i == 0) return false;
        }
        return true;
    }
}
