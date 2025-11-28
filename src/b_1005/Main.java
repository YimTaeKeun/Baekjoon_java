package b_1005;

import java.util.*;
import java.io.*;
// 위상 정렬 알고리즘
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cityCnt = Integer.parseInt(st.nextToken()), edgeCnt = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] adjList = new ArrayList[cityCnt + 1];
            int[] time = new int[cityCnt + 1]; // 각 건물이 걸리는 시간
            int[] timeMax = new int[cityCnt + 1]; // 건물이 지어지기까지 걸리는 시간
            int[] arr = new int[cityCnt + 1]; // 위상 정렬 배열

            for(int i = 0; i <= cityCnt; i++) adjList[i] = new ArrayList<>(); // 리스트 초기화
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= cityCnt; i++) {
                String temp = st.nextToken();
                time[i] = Integer.parseInt(temp); // 각 건물 시간 저장
                timeMax[i] = Integer.parseInt(temp);
            }
            for(int i = 0; i < edgeCnt; i++) {
                // 경로 저장
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
                arr[to]++; // 위상 정렬 값 저장
            }
            int targetNode = Integer.parseInt(br.readLine());
            // 위상 정렬 스타트
            int complete = 0;
            boolean[] visited = new boolean[cityCnt + 1];
            while(complete != cityCnt){
                for(int i = 1; i <= cityCnt; i++){
                    if(arr[i] == 0 && !visited[i]){ // 위상 정렬 실행 조건
                        visited[i] = true;
                        complete++;
                        ArrayList<Integer> neighbors = adjList[i]; // 다음 노드 탐색
                        for(Integer neighbor : neighbors){
                            arr[neighbor]--; // 간선제거
                            timeMax[neighbor] = Math.max(timeMax[neighbor], time[neighbor] + timeMax[i]);

                        }
                    }
                }
            }
            bw.write(timeMax[targetNode] + "\n");
        }
        bw.flush();
    }

}
