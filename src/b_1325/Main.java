package b_1325;

import java.util.*;
import java.io.*;

public class Main {
    public static int nodeCnt, edgeCnt;
    public static ArrayList<Integer>[] nodeInfo; // 연결 정보
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());
        nodeInfo = new ArrayList[nodeCnt + 1];
        for(int i = 1; i <= nodeCnt; i++) nodeInfo[i] = new ArrayList<>();
        for(int i = 0; i < edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken());
            nodeInfo[start].add(end);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= nodeCnt; i++){
            map.put(i, BFS(i));
        }
        int max = -1;
        List<Integer> resultNodes = new ArrayList<>();
        for(int i = 1; i <= nodeCnt; i++){
            if(map.get(i) > max){
                max = map.get(i);
                resultNodes.clear();
                resultNodes.add(i);
            }
            else if(map.get(i) == max) resultNodes.add(i);
        }
        for(Integer each: resultNodes) bw.write(each + " ");
        bw.flush();

    }
    public static int BFS(int startNode){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startNode);
        int cnt = 0;
        boolean[] visited = new boolean[nodeCnt + 1];
        visited[startNode] = true;
        while(!q.isEmpty()){
            Integer nowNode = q.poll();
            cnt++;
            ArrayList<Integer> nextNodes = nodeInfo[nowNode];
            for(int i = 0; i < nextNodes.size(); i++){
                int nextNode = nextNodes.get(i);
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
        return cnt;
    }
}
