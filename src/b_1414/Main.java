package b_1414;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] union_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int computerCnt = Integer.parseInt(br.readLine());
        int totalLanLength = 0;
        union_arr = new int[computerCnt + 1];
        for(int i = 0; i <= computerCnt; i++) union_arr[i] = i;
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 1; i <= computerCnt; i++){
            String s = br.readLine();
            for(int j = 1; j <= s.length(); j++){
                int value = lanLengthConvert(s.charAt(j - 1));
                totalLanLength += value;
                if(i != j && value != 0){
                    edges.add(new Edge(i, j, value));
                }
            }
        }
        edges.sort(null);
        boolean change = false;
        int completeCnt = 0;
        int connectWeight = 0;
        while(completeCnt < computerCnt - 1){
            change = false;
            for(Edge edge : edges){
                int x = find_(edge.from);
                int y = find_(edge.to);
                if(x == y) continue;
                union_(x, y);
                change = true;
                connectWeight += edge.weight;
                completeCnt++;
            }
            if(!change) break;
        }
        if(computerCnt == 1) bw.write(totalLanLength + "\n");
        else{
            if(!change) bw.write("-1\n");
            else bw.write(totalLanLength - connectWeight + "\n");
        }
        bw.flush();
    }

    public static int lanLengthConvert(char target){
        if(target == '0') return 0;
        if(target >= 'a') return target-'a' + 1;
        else return target-'A' + 27;
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
    int from, to, weight;
    public Edge(int from, int to,  int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
