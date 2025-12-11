package b_4386;

import java.util.*;
import java.io.*;

public class Main {
    public static int[] unionArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Double[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Double[]{Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())});
        }
        double result = .0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n ; j++){
                pq.add(new Edge(i, j, getDistance(list.get(i), list.get(j))));
            }
        }
        unionArr = new int[n];
        for(int i = 0; i < n; i++) unionArr[i] = i;
        int completeCnt = 0;
        while(completeCnt < n - 1){
            Edge e = pq.poll();
            if(find_(e.from) == find_(e.to)) continue;
            union_(e.from, e.to);
            result += e.weight;
            completeCnt++;
        }
        bw.write(result + "\n");
        bw.flush();
    }

    public static int find_(int x){
        if(unionArr[x] == x) return x;
        return unionArr[x] = find_(unionArr[x]);
    }

    public static void union_(int a, int b){
        a =  find_(a);
        b = find_(b);
        if(a == b) return;
        unionArr[b] = a;
    }

    public static double getDistance(Double[] a, Double[] b){
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}

class Edge implements Comparable<Edge>{
    int from, to;
    double weight;
    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}
