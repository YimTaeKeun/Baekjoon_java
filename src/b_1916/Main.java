package b_1916;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cityCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>(); // 각 요소마다 가중치 저장
        for(int i = 0; i <= cityCnt; i++) adj.add(new ArrayList<>()); // 리스트 초기화
        StringTokenizer st;
        for(int i = 0; i < edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(from).add(new Integer[]{to, weight});
        }
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken()); // 최소 경로 노드에 endNode 번호로 접근
        int[] shortPath = new int[cityCnt + 1];
        Arrays.fill(shortPath, Integer.MAX_VALUE); // 각 요소를 최댓값으로 설정, int 범위 안넘음
        shortPath[startNode] = 0; // 출발 노드 넣음
        // 다익스트라 시작
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        return o1[1] - o2[1];
                    }
                }
        );
        pq.offer(new Integer[]{startNode, 0});
        boolean[] visited = new boolean[cityCnt + 1]; // 방문 체크
        while(!pq.isEmpty()){
            Integer[] temp = pq.poll();
            int nowNode = temp[0], distanceFromStart = temp[1];
            if(visited[nowNode]) continue;
            visited[nowNode] = true; // 방문 체크
            ArrayList<Integer[]> neighbors = adj.get(nowNode);
            for(Integer[] each: neighbors){
                int nextNode = each[0]; // 다음 노드 번호
                int nextWeight = each[1]; // 다음 노드까지의 가중치
                shortPath[nextNode] = Math.min(shortPath[nextNode], distanceFromStart + nextWeight); // 가장 작은 거리를 넣어줌
                pq.offer(new Integer[]{nextNode, shortPath[nextNode]}); // 다음 노드를 방문했던 안했던 다음 큐에 넣어줌
            }
        }
        bw.write(shortPath[endNode] + "\n");
        bw.flush();
    }
}
