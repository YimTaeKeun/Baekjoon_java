package b_1707;

import java.util.*;
import java.io.*;

public class Main {
    public static Node[] nodes;
    public static List<Node>[] array; // 인접 리스트
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        String[] temp;
        while(tc-- >0){
            temp = br.readLine().split(" ");
            int nodeCnt = Integer.parseInt(temp[0]), edgeCnt = Integer.parseInt(temp[1]);
            visited = new boolean[nodeCnt + 1]; // 1번부터 nodeCnt까지 방문헀는지 알아보기
            nodes = new Node[nodeCnt + 1]; // 실제 노드들 저장
            for(int i = 1; i <= nodeCnt; i++) nodes[i] = new Node(i);
            array =  new List[nodeCnt + 1]; // 인접리스트
            for(int i = 0; i < array.length; i++) array[i] = new ArrayList<>(); // 리스트 초기화
            // 경로 저장
            for(int i = 0; i < edgeCnt; i++){
                temp = br.readLine().split(" ");
                int from = Integer.parseInt(temp[0]), to = Integer.parseInt(temp[1]);
                array[from].add(nodes[to]);
                array[to].add(nodes[from]);
            }
            boolean isAble = true;
            for(int i = 1; i <= nodeCnt; i++){
                if(!visited[i]){
                    if(!BFS(i)) isAble = false;
                }
            }
            if(isAble) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();

    }
    public static boolean BFS(int startNode){
        visited[startNode] = true;
        nodes[startNode].state = true; // 초기 상태는 true로 설정
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(nodes[startNode]);
        while(!queue.isEmpty()){
            Node nowNode = queue.poll();
            // 다음 노드 탐색
            List<Node> nextNodes = array[nowNode.value];
            for(int i = 0; i < nextNodes.size(); i++){
                var target = nextNodes.get(i);
                if(!visited[target.value]){
                    visited[target.value] = true;
                    target.state = !nowNode.state;
                    queue.add(target);
                }
                else if(target.state == nowNode.state) return false; // 다음 탐색 노드가 nowNode의 상태와 일치한다면 false
            }

        }
        return true;
    }
}

class Node{
    int value; // 노드 번호
    Boolean state = null; // 기본 상태
    public Node(int value){
        this.value = value;
    }
}
