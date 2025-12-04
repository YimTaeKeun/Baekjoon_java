package b_16398;

import java.util.*;
import java.io.*;

public class Main {
    public static int[] union_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        union_arr = new int[n + 1];
        for(int i = 0; i <= n; i++) union_arr[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int now = Integer.parseInt(st.nextToken());
                if(j <= i) continue;
                pq.add(new Edge(i + 1, j + 1, now));
            }
        }
        int completeCnt = 0;
        long result = 0;
        while(completeCnt < n - 1){
            Edge e = pq.poll();
            if(find_(e.from) != find_(e.to)){
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

class Edge implements Comparable<Edge> {
    int from, to, weight;
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
