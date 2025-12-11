package b_1647;

import java.util.*;
import java.io.*;

public class Main {
    public static int[] unionArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        unionArr = new int[n + 1];
        for(int i = 0; i <= n; i++) unionArr[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i < edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(from, to, weight));
        }
        int completeCnt = 0;
        int max = 0;
        long result = 0;
        while(completeCnt < n - 1){
            Edge e = pq.poll();
            if(find_(e.from) == find_(e.to)) continue;
            union_(e.from, e.to);
            result += e.weight;
            max = Math.max(max, e.weight);
            completeCnt++;
        }
        bw.write((result - max) + "\n");
        bw.flush();

    }

    public static int find_(int x){
        if(unionArr[x] == x) return x;
        return unionArr[x] = find_(unionArr[x]);
    }

    public static void union_(int a, int b){
        a = find_(a);
        b = find_(b);
        if(a == b) return;
        unionArr[b] = a;
    }
}
class Edge implements Comparable<Edge>{
    int from, to, weight;
    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
