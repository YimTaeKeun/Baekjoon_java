package b_11404;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cityCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());
        long[][] dp = new long[cityCnt + 1][cityCnt + 1];
        for(int i = 0; i <= cityCnt; i++) Arrays.fill(dp[i], Long.MAX_VALUE);
        for(int i = 0; i < edgeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dp[from][to] = Math.min(dp[from][to], weight);
        }
        for(int i = 0; i <= cityCnt; i++) dp[i][i] = 0;
        for(int k = 1; k <= cityCnt; k++) {
            for(int s = 1; s <= cityCnt; s++) {
                for(int e = 1; e <= cityCnt; e++){
                    if(dp[s][k] == Long.MAX_VALUE || dp[k][e] == Long.MAX_VALUE) continue;
                    dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k][e]); // 경유지 거쳐 갔을 때 최솟값
                }
            }
        }
        for(int i = 1; i <= cityCnt; i++) {
            for(int j = 1; j <= cityCnt; j++) bw.write((dp[i][j] == Long.MAX_VALUE) ? "0 " : dp[i][j] + " ");
            bw.newLine();
        }
        bw.flush();
    }
}
