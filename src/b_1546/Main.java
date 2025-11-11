package b_1546;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scores = new int[N];
        int max = -1;
        for(int i = 0; i < N; i++) {
            int score = sc.nextInt();
            if(score > max) max = score;
            scores[i] = score;
        }
        double ans = .0;
        for(int i = 0; i < N; i++) ans += ((double) scores[i]) / max * 100;
        System.out.println(ans / N);
    }
}
