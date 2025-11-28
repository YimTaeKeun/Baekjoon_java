package b_1854;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCnt = Integer.parseInt(st.nextToken()), edgeCnt = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>();
        for(int i = 0; i <= cityCnt; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(from).add(new Integer[]{to, weight});
        }
        PriorityQueue<Integer>[] timeList = new PriorityQueue[cityCnt + 1]; // 우선 순위 큐
        for(int i = 0; i <= cityCnt; i++) timeList[i] = new PriorityQueue<>(Collections.reverseOrder());
        timeList[1].add(0);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        return o2[1] - o1[1];
                    }
                }
        );
        pq.offer(new Integer[]{1, 0}); // 노드번호, 가중치
        while(!pq.isEmpty()) {
            Integer[] cur = pq.poll();
            int nowNodeNum = cur[0];
            int nowShort = cur[1];
            ArrayList<Integer[]> neighbors = adj.get(nowNodeNum);
            for(Integer[] neighbor : neighbors) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                if(timeList[nextNode].size() == k){
                    if(timeList[nextNode].peek() > nowShort + weight){
                        timeList[nextNode].poll();
                        timeList[nextNode].add(nowShort + weight);
                        pq.offer(new Integer[]{nextNode, nowShort + weight});
                    }
                }
                else{
                    timeList[nextNode].add(nowShort + weight);
                    pq.offer(new Integer[]{nextNode, nowShort + weight});
                }
            }
        }
        for(int i = 1; i <= cityCnt; i++){
            bw.write((timeList[i].size() != k) ? "-1\n" : timeList[i].poll() + "\n");
        }
        bw.flush();

    }
}
