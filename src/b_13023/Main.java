package b_13023;

import java.util.*;
import java.io.*;

public class Main {
    public static int TARGET_DEPTH = 5, nodeCnt = 0;
    public static List<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        nodeCnt = Integer.parseInt(temp[0]);
        int edgeCnt = Integer.parseInt(temp[1]);

        for(int i = 0; i < nodeCnt; i++) list.add(new ArrayList<>());
        for(int i = 0; i < edgeCnt; i++) {
            temp = br.readLine().split(" ");
            int one = Integer.parseInt(temp[0]), two = Integer.parseInt(temp[1]);
            list.get(one).add(two);
            list.get(two).add(one);
        }
        for(int i = 0; i < nodeCnt; i++) {
            boolean[] visited = new boolean[nodeCnt];
            dfs(list.get(i), 1, visited, i);
            if(result) break;
        }
        bw.write(String.valueOf(result?1:0));
        bw.flush();
    }
    public static void dfs(ArrayList<Integer> nodeList, int depth, boolean[] visited, int nowNode) {
        if(depth == TARGET_DEPTH) {
            result = true;
            return;
        }
        visited[nowNode] = true;
        for(int i = 0; i < nodeList.size(); i++) {
            int nextNode = nodeList.get(i);
            if(!visited[nextNode]) {
                dfs(list.get(nextNode), depth + 1, visited, nextNode);
            }
        }
        visited[nowNode] = false;
    }
}
