package b_11725;

import java.util.*;
import java.io.*;

public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static int[] parentArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nodeCnt = Integer.parseInt(br.readLine());
        adjList = new ArrayList[nodeCnt + 1]; // 인접리스트
        parentArr = new int[nodeCnt + 1]; // 부모 노드 정보 저장
        for(int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();
        String[] temp;
        for(int i = 0; i < nodeCnt - 1; i++){
            temp = br.readLine().split(" ");
            int one = Integer.parseInt(temp[0]), two = Integer.parseInt(temp[1]);
            adjList[one].add(two);
            adjList[two].add(one);
        }
        visited = new boolean[nodeCnt + 1]; // 방문 표시
        BFS(1);
        for(int i = 2; i <= nodeCnt; i++) bw.write(parentArr[i] + "\n");
        bw.flush();
    }
    public static void BFS(int startNode){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited[startNode] = true;
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            ArrayList<Integer> neighbors = adjList[nowNode];
            for(int i = 0; i < neighbors.size(); i++){
                int nextNode = neighbors.get(i);
                if(visited[nextNode]) continue;
                // 방문하지 않았을 경우
                visited[nextNode] = true;
                parentArr[nextNode] = nowNode;
                queue.add(nextNode);
            }
        }
    }
}
