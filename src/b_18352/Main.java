package b_18352;

import java.util.*;
import java.io.*;

public class Main {
    public static boolean[] visit; // 방문 표시
    public static ArrayList<Integer> resultNodes = new ArrayList<>(); // 답 노드들
    public static ArrayList<ArrayList<Integer>> nodeInfo;
    public static int targetMinimumSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken()), edgeCnt = Integer.parseInt(st.nextToken());
        targetMinimumSize = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken()); // 인접 리스트로 풀이
        nodeInfo = new ArrayList<>(); // 1번 부터 nodeCnt까지
        for(int i = 0; i <= nodeCnt; i++) nodeInfo.add(new ArrayList<>());
        for(int i = 0; i < edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            nodeInfo.get(start).add(end);
        }
        visit = new boolean[nodeCnt + 1];
        BFS(startNode);
        Collections.sort(resultNodes);
        if(resultNodes.isEmpty()) bw.write("-1\n");
        else for(Integer node : resultNodes) bw.write(node + "\n");
        bw.flush();

    }
    public static void BFS(int startNode){
        // 나 자신일리 없음
        Queue<Integer[]> q = new ArrayDeque<>(); // 원소로 k와
        visit[startNode] = true; // 시작 노드 체크
        q.add(new Integer[]{startNode, 0}); // 두 번째 원소는 시작 지점에서 해당 거리까지의 거리
        while(!q.isEmpty()){
            Integer[] nowNode = q.poll(); // 현재 노드
            ArrayList<Integer> searchNodeList = nodeInfo.get(nowNode[0]);
            for(int i = 0; i < searchNodeList.size(); i++){
                Integer nextNode = searchNodeList.get(i);
                if(!visit[nextNode]){
                    visit[nextNode] = true;
                    q.add(new Integer[]{nextNode, nowNode[1] + 1});
                    if(nowNode[1] + 1 == targetMinimumSize) resultNodes.add(nextNode);
                }
            }
        }
    }
}
