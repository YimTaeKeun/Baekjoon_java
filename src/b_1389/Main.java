package b_1389;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), edgeCnt = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) adjList.add(new ArrayList<>()); // 리스트 초기화
        for(int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            adjList.get(start).add(end);
            adjList.get(end).add(start); // 양방향 그래프
        }
        int minNode = 0;
        int minBacon = -1;
        for(int start = 1; start <= n; start++) {
            Queue<Integer[]> q = new ArrayDeque<>();
            q.add(new Integer[]{start, 0}); // 스타트를 넣어줍니다. 1번쨰는 연결 관계 정도입니다.
            int tempBacon = 0; // 출발 노드로부터의 최종 베이컨 수
            boolean[] visited = new boolean[n + 1]; // 방문 정도
            visited[start] = true;
            while(!q.isEmpty()) {
                Integer[] temp = q.poll();
                int nowNode = temp[0];
                int weight = temp[1];
                tempBacon += weight;
                ArrayList<Integer> nextNodes = adjList.get(nowNode);
                for(Integer nextNode : nextNodes) {
                    if(!visited[nextNode]) {
                        visited[nextNode] = true; // BFS에서는 방문 처리를 먼저합니다.
                        q.add(new Integer[]{nextNode, weight + 1}); // 큐에 추가
                    }
                }
            }
            if(tempBacon < minBacon || minBacon == -1) {
                minNode = start;
                minBacon = tempBacon;
            }
            else if(tempBacon == minBacon) minNode = Math.min(minNode, start); // 수가 같다면 노드 번호가 작은게 우선
        }
        bw.write(minNode + "\n");
        bw.flush();
    }
}
