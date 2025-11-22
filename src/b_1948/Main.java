package b_1948;

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int cityCnt = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int edgeCnt = Integer.parseInt(st.nextToken());
//        int[] topo = new int[cityCnt + 1], reverseTopo = new int[cityCnt + 1]; // 위상정렬 array
//        int[] timeArr = new int[cityCnt + 1];
//        ArrayList<Integer[]>[] adjList = new ArrayList[cityCnt + 1], reverseList = new ArrayList[cityCnt + 1]; // 연결 관계 표시 인접 리스트
//        for(int i = 0; i <= cityCnt; i++){
//            adjList[i] = new ArrayList<>();
//            reverseList[i] = new ArrayList<>();
//        }
//        for(int i = 0; i < edgeCnt; i++){
//            st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), time = Integer.parseInt(st.nextToken());
//            adjList[from].add(new Integer[] {to, time});
//            reverseList[to].add(new Integer[] {from, time});
//            topo[to]++;
//            reverseTopo[from]++;
//        }
//        st = new StringTokenizer(br.readLine());
//        int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
//        int complete = 0;
//        // 위상 정렬 수행
//        boolean[] v = new boolean[cityCnt + 1];
//        while(complete < cityCnt){
//            for(int i = (complete == 0) ? from: 1; i <= cityCnt; i++){
//                if(topo[i] == 0 && !v[i]){ // 위상 정렬 수행 조건
//                    v[i] = true;
//                    ArrayList<Integer[]> neighbors = adjList[i];
//                    complete++;
//                    if(complete==cityCnt) break;
//                    for(Integer[] each: neighbors){ // 다음 노드들을 가져옵니다. 이는 현재 노드와 다음 노드까지 얼마나 걸리는지 기록도 되어있습니다.
//                        topo[each[0]]--;
//                        timeArr[each[0]] = Math.max(timeArr[each[0]], timeArr[i] + each[1]);
//                    }
//                }
//            }
//        }
//        int resultMax = timeArr[to];
//        bw.write(resultMax + "\n");
//        // 역추적 시작
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(to);
//        int resultCnt = 0;
//        boolean[][] visited = new boolean[cityCnt + 1][cityCnt + 1];
//        while(!queue.isEmpty()){
//            int nowNode = queue.poll();
//            ArrayList<Integer[]> neighbors = reverseList[nowNode];
//            for(Integer[] each: neighbors){
//                int nextNodeNumber = each[0], time = each[1];
//                reverseTopo[nextNodeNumber]--;
//                if(timeArr[nextNodeNumber] + time == timeArr[nowNode] && !visited[nowNode][nextNodeNumber]){
//                    visited[nowNode][nextNodeNumber] = true;
//                    queue.add(nextNodeNumber);
//                    resultCnt++;
//                }
//            }
//        }
//        bw.write(resultCnt + "\n");
//        bw.flush();
//    }
//}

// 모범 답안
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cityCnt = Integer.parseInt(br.readLine()), edgeCnt = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> adjList = new ArrayList<>(), reverseList = new ArrayList<>(); // 인접 리스트, 역 리스트
        int[] indegree = new int[cityCnt + 1]; // 진입 차수
        StringTokenizer st;
        // 리스트 초기화
        for(int i = 0; i <= cityCnt; i++){
            adjList.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }
        // 입력
        for(int i = 0; i < edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), value = Integer.parseInt(st.nextToken());
            adjList.get(start).add(new dNode(end, value));
            reverseList.get(end).add(new dNode(start, value));
            indegree[end]++;
        }
        st = new StringTokenizer(br.readLine()); // 출발, 도착 입력받음
        int startNode = Integer.parseInt(st.nextToken()), endNode = Integer.parseInt(st.nextToken());
        // 위상 정렬 시작
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startNode);
        int[] result = new int[cityCnt + 1]; // 시간 답
        while(!q.isEmpty()){
            int nowNode = q.poll();
            for(dNode node : adjList.get(nowNode)){
                indegree[node.targetNode]--; // 진입 차수 삭제
                result[node.targetNode] = Math.max(result[node.targetNode], node.value + result[nowNode]);
                if(indegree[node.targetNode] == 0) q.offer(node.targetNode);
            }
        }
        // 위상 정렬 reverse
        int resultCount = 0; // 간선 개수를 의미합니다.
        boolean[] visited = new boolean[cityCnt + 1];
        visited[endNode] = true;
        q = new ArrayDeque<>();
        q.offer(endNode);
        while(!q.isEmpty()){
            int nowNode = q.poll();
            for(dNode node : reverseList.get(nowNode)){
                if(result[nowNode] == result[node.targetNode] + node.value){
                    resultCount++;
                    if(!visited[node.targetNode]) { // 방문하지 않았다면 방문처리하고 큐에 추가
                        visited[node.targetNode] = true;
                        q.offer(node.targetNode);
                    }
                }
            }
        }
        bw.write(result[endNode] + "\n");
        bw.write(resultCount + "\n");
        bw.flush();
    }
}

class dNode{
    int targetNode; // 다음 노드 번호를 의미합니다.
    int value; // 다음 노드까지 가는 데 걸리는 시간을 의미합니다.
    public dNode(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }
}