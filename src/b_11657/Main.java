package b_11657;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        ArrayList<Integer[]> edges = new ArrayList<>();
        for(int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Integer[]{start, end, weight});
        }
        boolean change = false;
        long[] distance = new long[cityCnt + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;
        int count = 1;

        while(count <= cityCnt){
            for(Integer[] edge: edges){
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];
                if(distance[start] == Long.MAX_VALUE) continue;
                if(distance[end] > distance[start] + weight) {
                    distance[end] = distance[start] + weight;
                    if(count == cityCnt) change = true;
                }
            }
            count++;
        }
        if(change) System.out.println("-1");
        else{
            for(int i = 2; i <= cityCnt; i++) System.out.println((distance[i] != Long.MAX_VALUE) ? distance[i]: "-1");
        }
    }
}
