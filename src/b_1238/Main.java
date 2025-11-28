package b_1238;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        int toCity = Integer.parseInt(st.nextToken());
        // 다익스트라로 풀이
        ArrayList<ArrayList<Integer[]>> adjList = new ArrayList<>();
        for(int i = 0; i <= cityCnt; i++) adjList.add(new ArrayList<>());
        for(int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList.get(from).add(new Integer[]{to, weight});
        }
        int[] dist = new int[cityCnt + 1];
        int resultMax = -1;
        for(int s = 1; s <= cityCnt; s++) {
            Arrays.fill(dist, Integer.MAX_VALUE); // 리스트 초기화
            dist[s] = 0;
            PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                    new Comparator<Integer[]>() {
                        public int compare(Integer[] o1, Integer[] o2) {
                            return o1[1] - o2[1];
                        }
                    }
            );
            pq.offer(new Integer[]{s, 0});
            boolean[] visited = new boolean[cityCnt + 1];
            while(!pq.isEmpty()) {
                Integer[] now = pq.poll();
                int nowNodeNumber = now[0];
                int nowShortestDist = now[1];
                if(!visited[nowNodeNumber] || nowNodeNumber == s) {
                    visited[nowNodeNumber] = true;
                    for(Integer[] neighbor : adjList.get(nowNodeNumber)) {
                        int neighborNodeNumber = neighbor[0];
                        int weight = neighbor[1];
                        if((!visited[neighbor[0]] && dist[neighborNodeNumber] > nowShortestDist + weight)
                        || (nowNodeNumber == s)) {
                            dist[neighborNodeNumber] = nowShortestDist + weight;
                            pq.offer(new Integer[]{neighborNodeNumber, nowShortestDist + weight});
                        }
                    }
                }
            }
            if(dist[toCity] > resultMax) resultMax = dist[toCity];
        }
        bw.write(resultMax + "\n");
        bw.flush();
    }
}
