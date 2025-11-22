package b_1516;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 건물 갯수
        int[] topo = new int[n + 1]; // 위상 정렬 파악을 위한 배열
        ArrayList<Integer>[] adjList = new ArrayList[n + 1]; // 연결 관계 나타내는 인접리스트
        for(int i = 1; i <= n; i++) adjList[i] = new ArrayList<>(); // 리스트 초기화
        int[] time = new int[n + 1]; // 걸리는 시간 저장 배열
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine()); // 새로운 입력 받음
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                String token = st.nextToken(); // 토큰이 -1이면 바로 아웃
                if(token.equals("-1")) break;
                // 순서관계 저장 다음 토큰 다음에 현재 노드 연결
                adjList[Integer.parseInt(token)].add(i);
                topo[i]++; // 내가 피 연결되는 것이므로 나 자신 ++
            }
        }
        // 처리 시작
        int[] resultTime = new int[n + 1]; // 최종시간 저장
        boolean[] visited = new boolean[n + 1]; // 방문 상태 저장
        for(int i = 1; i <= n; i++) resultTime[i] = time[i]; // 일단 자기 자신 걸리는 시간을 포함
        // 각각 노드를 방문할 때만 visit 처리
        int complete = 0;
        while(complete != n){ // 모든 노드를 방문하지 않았을 떄만 while문을 돌림
            for(int i = 1; i <= n; i++){
                if(topo[i] == 0 && !visited[i]){ // 받는 수가 없을 떄, 방문하지 않았을 때
                    // 위상 정렬 실행 조건
                    visited[i] = true;
                    complete++; // 완료 갯수 저장
                    ArrayList<Integer> nextNodes = adjList[i]; // 다음 노드 리스트 가져옴
                    for(Integer each: nextNodes){
                        resultTime[each] = Math.max(resultTime[each], time[each] + resultTime[i]); // 현재 노드의 값 최댓값에 다음 노드 건설 시간 더해서 다음 노드 최종 값 중에서 비교
                        topo[each]--; // 위상 정렬 간선 제거
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++) bw.write(resultTime[i] + "\n");
        bw.flush();
    }
}