package b_1865;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cityCnt = Integer.parseInt(st.nextToken());
            int edgeCnt = Integer.parseInt(st.nextToken());
            int wormHoleCnt = Integer.parseInt(st.nextToken());
            ArrayList<Integer[]> edgeList = new ArrayList<>();
            for(int i = 0; i < edgeCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList.add(new Integer[]{from, to, weight});
                edgeList.add(new Integer[]{to, from, weight});
            }
            for(int i = 0; i < wormHoleCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList.add(new Integer[]{from, to, -weight}); // 음수로 저장
            }
            int[] time = new int[cityCnt + 1];
//            Arrays.fill(time, Integer.MAX_VALUE); // 최댓값으로 채우기
            time[1] = 0;
            for(int i = 0; i < cityCnt - 1; i++){ // 노드 갯수 -1 만큼 업데이트 시행
                for(int j = 0; j < edgeList.size(); j++){
                    Integer[] edge = edgeList.get(j);
                    int from = edge[0], to = edge[1], weight = edge[2];
                    if(time[from] + weight < time[to] || time[to] == 0) {
                        time[to] = time[from] + weight;
                    }
                }
            }
            // 시행 이후 변경 사항이 생기는지 확인
            boolean change = false;
            for(int i = 0; i < edgeList.size(); i++){
                Integer[] edge = edgeList.get(i);
                int from = edge[0], to = edge[1], weight = edge[2];
                if(time[from] + weight < time[to]) {
                    change = true;
                    break;
                }
            }
            if(change) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
    }
}
