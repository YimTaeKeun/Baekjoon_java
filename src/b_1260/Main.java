package b_1260;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken()), startNode = Integer.parseInt(st.nextToken());
        arr = new boolean[n + 1][n + 1];
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = true;
            arr[y][x] = true;
        }
        boolean[] v = new boolean[n + 1];
        v[startNode] = true;
        DFS(startNode, v);
        bw.newLine();

        v = new boolean[n + 1];
        v[startNode] = true;
        BFS(startNode, v);
        bw.newLine();
        bw.flush();
    }
    public static void DFS(int startNode, boolean[] visited) throws IOException{
        bw.write(startNode + " ");
        boolean[] nowNode = arr[startNode];
        for(int i = 1; i <= n; i++){
            if(nowNode[i] && !visited[i]){
                visited[i] = true;
                DFS(i, visited);
//                visited[startNode] = false;
            }
        }

    }

    public static void BFS(int startNode, boolean[] visited) throws IOException{
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        while(!q.isEmpty()){
            int cur = q.poll();
            bw.write(cur + " ");
            boolean[] nowNode = arr[cur];
            for(int i = 1; i <= n; i++){
                if(nowNode[i] && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
