package b_1753;

// 다익스트라 알고리즘 구현
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken()), edgeCnt = Integer.parseInt(st.nextToken());
        int[] shortPath = new int[nodeCnt + 1];
        Arrays.fill(shortPath, Integer.MAX_VALUE);
        int startNode = Integer.parseInt(br.readLine());
        shortPath[startNode] = 0;
        int shortestNode = startNode; // 시작 노드를 최단 경로로 시작
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>(); // 인접 리스트
        for(int i = 0; i <= nodeCnt; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(from).add(new Integer[]{to, weight});
        }
        // 다익스트라 알고리즘 시작
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                new Comparator<Integer[]>() {
                    public int compare(Integer[] o1, Integer[] o2) {
                        return o1[1] - o2[1];
                    }
                }
        );
        pq.offer(new Integer[]{startNode, 0});
        boolean[] visited = new boolean[nodeCnt + 1];
        while(!pq.isEmpty()){
            Integer[] temp = pq.poll();
            int nowNode = temp[0], distance = temp[1];
            if(visited[nowNode]) continue;
            visited[nowNode] = true;
            ArrayList<Integer[]> neighbors = adj.get(nowNode);
            for(Integer[] each: neighbors){
                shortPath[each[0]] = Math.min(shortPath[each[0]], distance + each[1]);
                pq.offer(new Integer[]{each[0], shortPath[each[0]]});
            }
        }
        for(int i = 1; i <= nodeCnt; i++){
            bw.write((shortPath[i] == Integer.MAX_VALUE) ? "INF\n" : shortPath[i] + "\n");
        }
        bw.flush();
    }
}
