package b_1162;

import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());// 포장 도로 횟수
        long[][] dist = new long[cityCnt + 1][k + 1];
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for(int i = 0; i <= cityCnt; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Node(b, w, 0));
            adj.get(b).add(new Node(a, w, 0));
        }
        for(int i = 0; i <= cityCnt; i++) Arrays.fill(dist[i], Long.MAX_VALUE);
        dist[1][0] = 0; // 0번 포장한 0번 도로의 값
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.weight > dist[node.id][node.pojangCnt]) continue;

            for(Node neighbor : adj.get(node.id)) {
                if(node.pojangCnt < k && dist[neighbor.id][node.pojangCnt + 1] > dist[node.id][node.pojangCnt]) {
                    dist[neighbor.id][node.pojangCnt + 1] = dist[node.id][node.pojangCnt];
                    pq.offer(new Node(neighbor.id, dist[neighbor.id][node.pojangCnt + 1], node.pojangCnt + 1));
                }
                // 포장 안함
                if(dist[neighbor.id][node.pojangCnt] > dist[node.id][node.pojangCnt] + neighbor.weight){
                    dist[neighbor.id][node.pojangCnt] = dist[node.id][node.pojangCnt] + neighbor.weight;
                    pq.offer(new Node(neighbor.id, dist[neighbor.id][node.pojangCnt], node.pojangCnt));
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for(int i = 0; i <= k; i++) ans = Math.min(ans, dist[cityCnt][i]);
        bw.write(ans+"\n");
        bw.flush();

    }
}

class Node implements Comparable<Node>{
    int id;
    long weight;
    int pojangCnt; // 해당 노드까지의 포장 횟수
    public Node(int id, long weight, int pojangCnt) {
        this.id = id;
        this.weight = weight;
        this.pojangCnt = pojangCnt;
    }

    @Override
    public int compareTo(Node o) {
        return (int)(this.weight - o.weight);
    }
}
