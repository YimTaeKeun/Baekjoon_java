package b_14938;

import java.util.*;
import java.io.*;
// 플로이드 워셜 알고리즘
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int areaCnt = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        int[] items = new int[areaCnt + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= areaCnt; i++) items[i] = Integer.parseInt(st.nextToken()); // 아이템 갯수 저장
        int[][] pathDp = new int[areaCnt + 1][areaCnt + 1]; // 최단 경로 디피
        boolean[][] visited = new boolean[areaCnt + 1][areaCnt + 1];
        for(int i = 0; i <= areaCnt; i++) Arrays.fill(pathDp[i], Integer.MAX_VALUE);
        for(int i = 1; i <= areaCnt; i++) {
            pathDp[i][i] = 0;
            visited[i][i] = true;
        }
        for(int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(weight <= m){
                pathDp[from][to] = weight;
                pathDp[to][from] = weight;
                visited[from][to] = true;
                visited[to][from] = true;
            }
        }
        for(int k = 1; k <= areaCnt; k++) {
            for(int s = 1; s <= areaCnt; s++) {
                for(int e = 1; e <= areaCnt; e++) {
                    if(pathDp[s][k] == Integer.MAX_VALUE || pathDp[k][e] == Integer.MAX_VALUE) continue;
                    int sum = pathDp[s][k] + pathDp[k][e];
                    if(pathDp[s][e] > sum || sum <= m) { // 수색범위 안에 있을 때
                        pathDp[s][e] = sum;
                        visited[s][k] = true;
                    }
                }
            }
        }
        int result = 0;
        for(int i = 1; i <= areaCnt; i++) {
            int temp = 0;
            for(int j = 1; j <= areaCnt; j++) if(visited[i][j]) temp += items[j];
            result = Math.max(result, temp);
        }
        bw.write(result + "\n");
        bw.flush();

    }
}
