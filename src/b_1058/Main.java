package b_1058;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // 입력
        List<Node> nodes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int humanCnt = Integer.parseInt(br.readLine());
        nodes.add(new Node(0));
        for(int i = 1; i <= humanCnt; i++) nodes.add(new Node(i));
        String temp;
        for(int i = 0; i < humanCnt; i++){
            temp = br.readLine();
            for(int r = i; r < humanCnt; r++){
                if(temp.charAt(r) == 'Y'){
                    nodes.get(i + 1).childNodes.add(nodes.get(r + 1));
                    nodes.get(r + 1).childNodes.add(nodes.get(i + 1));
                }
            }
        }
        // 친구 수 계산
        long result = 0;
        for(int i = 1; i <= humanCnt; i++){
            long tempResult = 0;
            boolean[] visit = new boolean[humanCnt + 1];
            visit[i] = true;
            Queue<Node> queue = new LinkedList<>(), queue2 = new LinkedList<>();
            queue.addAll(nodes.get(i).childNodes);
            while(!queue.isEmpty()){
                Node targetNode = queue.poll();
                if(!visit[targetNode.data]){
                    tempResult++;
                    visit[targetNode.data] = true;
                    queue2.addAll(targetNode.childNodes);
                }
            }
            while(!queue2.isEmpty()){
                Node targetNode = queue2.poll();
                if(!visit[targetNode.data]){
                    visit[targetNode.data] = true;
                    tempResult++;
                }
            }
            result = Math.max(result, tempResult);
        }
        System.out.println(result);
    }
}
class Node{
    int data = 0;
    List<Node> childNodes = new ArrayList<>(); 
    Node(int data){this.data = data;}
}
