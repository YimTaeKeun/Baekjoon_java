package b_1931;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.difference - o2.difference;
            }
        });
        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            pq.add(new Node(start, end));
        }

        int cnt = 0;
        List<Node> successList = new LinkedList<>(); // 성공한 노드들의 집합

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(successList.isEmpty()) successList.add(node);
            if(successList.size() == 1){
                Node prev =  successList.get(0);
            }
            for(int i = 0; i < successList.size() - 1; i++){
                Node prev = successList.get(i);
                Node next = successList.get(i + 1);
                if(prev.end <= node.start && node.end <= next.start){
                    // 이전 끝시간보다 현 시작 시간이 같거나 크고, 현 끝 시간이 다음 시작 시간보다 작아야함
                    successList.add(i + 1, node);
                    break;
                }
            }
        }
        bw.write(successList.size() + "\n");
        bw.flush();
    }
}

class Node{
    public int start; // 시작 시간
    public int end; // 끝나는 시간
    public int difference; // 시간의 차이

    public Node(int start, int end){
        this.start = start;
        this.end = end;
        this.difference = end - start;
    }
    @Override
    public String toString() {
        return start + "-" + end;
    }
}
