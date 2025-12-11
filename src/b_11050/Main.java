package b_11050;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // DP 풀이
        // 예시: 5개에서 3개 뽑는 경우는 4개에서 2개 뽑는 경우의 수와 4개에서 3개 뽑는 경우의 수를 더한 것
        // DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1]
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] DP = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            DP[i][0] = 1;
            DP[i][i] = 1;
            DP[i][1] = i;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++) DP[i][j] = DP[i-1][j-1] + DP[i-1][j];
        }
        System.out.println(DP[n][k]);
    }
}
