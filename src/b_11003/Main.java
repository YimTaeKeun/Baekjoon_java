package b_11003;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Node> dq = new ArrayDeque<>();
        int n = sc.nextInt();
        int windowSize = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("사이클: " + i);
            Node node = new Node(i, sc.nextInt());
            if(i >= windowSize) {
                System.out.println("삭제1");
                System.out.println(dq.peekFirst());
                dq.removeFirst();
            }

            if(dq.isEmpty()){
                System.out.println("추가1");
                System.out.println(node);
                dq.addLast(node);
            }
            else{
                while(!dq.isEmpty() && dq.peek().value > node.value) {
                    System.out.println("삭제2");
                    System.out.println(dq.peekLast());
                    dq.removeLast();
                }
                System.out.println("추가2");
                System.out.println(node);
                dq.addLast(node);
            }
            if(dq.peekFirst() != null) bw.write(dq.peekFirst().value + " ");
        }
        bw.flush();
    }
}
class Node{
    int index;
    int value;
    public Node(int index, int value){
        this.index = index;
        this.value = value;
    }
    @Override
    public String toString(){
        return "노드 정보: " + index + " " + value + "\n";
    }
}
