package b_1197;


import java.util.*;
import java.io.*;

public class Main {
    public static int[] union_arr;
    public static void main(String[] args) throws IOException {
        // 최소 스패닝 트리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        union_arr = new int[nodeCnt + 1];
        for(int i = 0; i <= nodeCnt; i++) union_arr[i] = i; // 유니온 파인드 배열 초기화
        ArrayList<Edge> edgeList = new ArrayList<>();
        for(int i = 0; i < edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(from, to, weight));
        }
        edgeList.sort(null);
        int completeEdgeCnt = 0;
        int resultWeight = 0;
        while(completeEdgeCnt < nodeCnt - 1){
            for(Edge edge : edgeList){
                int from = find_(edge.from);
                int to = find_(edge.to);
                if(from != to){
                    union_(from, to);
                    resultWeight += edge.weight;
                    completeEdgeCnt++;
                }
            }
        }
        bw.write(resultWeight+"\n");
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
    int from;
    int to;
    int weight;
    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight; // 오름 차순 정렬
    }
}
