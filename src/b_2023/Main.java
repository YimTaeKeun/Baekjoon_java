package b_2023;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetJaritsu = Integer.parseInt(br.readLine());
        printPrime(1, 0, targetJaritsu);
        bw.flush();

    }
    public static void printPrime(int nowJaritsu, int nowValue, int targetJaritsu) throws IOException {
        for(int i = 1; i < 10; i++){
            if(isPrime(10 * nowValue + i)){
                if(nowJaritsu == targetJaritsu) bw.write(String.valueOf(10 * nowValue + i) + "\n");
                else printPrime(nowJaritsu + 1, 10 * nowValue + i, targetJaritsu);
            }
        }
    }
    public static boolean isPrime(int value){
        if(value == 1) return false;
        for(int i = 2; i <= Math.sqrt(value); i++){
            if(value % i == 0) return false;
        }
        return true;
    }
}
