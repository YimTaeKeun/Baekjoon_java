package b_10570;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            int[] numbers = new int[1001];
            int n = sc.nextInt();
            for(int i = 0; i < n; i++) numbers[sc.nextInt()]++;
            int max = 0;
            int maxCnt = 0;
            for(int i = 1; i < 1001; i++){
                if(maxCnt < numbers[i]){
                    maxCnt = numbers[i];
                    max = i;
                }
            }
            System.out.println(max);
        }
    }
}
