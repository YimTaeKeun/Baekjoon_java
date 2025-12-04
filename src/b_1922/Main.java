package b_1922;

import java.util.*;
import java.io.*;

public class Main {
    public static int[] union_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int computerCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(from, to, weight));
        }
        int completeCnt = 0;
        int result = 0;
        union_arr = new int[computerCnt + 1];
        for(int i = 0; i <= computerCnt; i++) union_arr[i] = i;
        while (completeCnt < computerCnt - 1) {
            Edge e = pq.poll();
            if(find_(e.from) != find_(e.to)) {
                union_(e.from, e.to);
                result += e.weight;
                completeCnt++;
            }
        }
        bw.write(result + "\n");
        bw.flush();

    }

    public static int find_(int x){
        if(union_arr[x] == x) return x;
        return union_arr[x] = find_(union_arr[x]);
    }

    public static void union_(int a, int b){
        a = find_(a);
        b = find_(b);
        if(a == b) return;
        union_arr[b] = a;
    }
}

class Edge implements Comparable<Edge>{
    int from, to,  weight;
    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}