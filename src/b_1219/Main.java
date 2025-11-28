package b_1219;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCnt = Integer.parseInt(st.nextToken()); // 0번부터 시작
        int fromCity = Integer.parseInt(st.nextToken());
        int toCity = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        int[] money = new int[cityCnt]; // n번째 도시에서 벌어들일 수 있는 돈
        ArrayList<Integer[]> edgeList = new ArrayList<>();
        ArrayList<Integer>[] adjList = new ArrayList[cityCnt];
        for (int i = 0; i < cityCnt; i++) adjList[i] = new ArrayList<>();
        for(int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = -Integer.parseInt(st.nextToken()); // 음수 가중치로 둠
            edgeList.add(new Integer[]{from, to, weight});
            adjList[from].add(to);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cityCnt; i++) money[i] = Integer.parseInt(st.nextToken());

        long[] dist = new long[cityCnt]; // 벨만 포드 배열
        Arrays.fill(dist, Long.MIN_VALUE); // 최솟값으로 설정
        dist[fromCity] = money[fromCity]; // 출발도시 배열 값을 기본 money로 설정
        // 탐색 시작 (최대 횟수: n - 1)
        for(int r = 0; r < cityCnt - 1; r++) {
            for(Integer[] edge: edgeList) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                if(dist[from] == Long.MIN_VALUE) continue; // MINVALUE 이면 건너뛰기
                dist[to] = Math.max(dist[to], dist[from] + weight + money[to]); // 해당 도시에서 벌 수 있는 돈까지 합산하여 최댓값
            }
        }
        if(dist[toCity] == Long.MIN_VALUE) { // 도착 도시 도달 불가일 때
            bw.write("gg\n");
        }
        else{
            // 도착 도시에 도달은 할 수 있음
            // 탐색 체크
            Queue<Integer> cycleNodes = new LinkedList<>(); // 사이클 후보 정점들
            boolean change = false;

            for(Integer[] edge: edgeList) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                if(dist[from] == Long.MIN_VALUE) continue;
                if(dist[to] < dist[from] + weight + money[to]) {
                    cycleNodes.offer(to); // 후보 노드 넣기
                }
            }

            while(!cycleNodes.isEmpty()) {
                int nowCycleNode = cycleNodes.poll();
                // 해당 정점에서 BFS 실행
                // 돈을 무한히 벌던 말던 사이클에서 도착지로 갈 수만 있으면 GEE
                boolean[] visited = new boolean[cityCnt];
                visited[nowCycleNode] = true;
                Queue<Integer> q = new LinkedList<>();
                q.offer(nowCycleNode);
                while(!q.isEmpty()) {
                    int now = q.poll();
                    for(Integer adjNode: adjList[now]) {
                        if(!visited[adjNode]) {
                            visited[adjNode] = true;
                            q.offer(adjNode);
                        }
                    }
                    if(visited[toCity]){
                        change = true;
                        break;
                    }
                }
                if(change) break;
            }


            if(change) bw.write("Gee\n");
            else bw.write(dist[toCity] + "\n");
        }
        bw.flush();
    }
}
