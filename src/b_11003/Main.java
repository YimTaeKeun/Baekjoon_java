package b_11003;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Node> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            Node node = new Node(i, Integer.parseInt(st.nextToken()));

            if(dq.isEmpty()){
                dq.addLast(node);
            }
            else{
                while(!dq.isEmpty() && dq.peekLast().value > node.value) {
                    dq.removeLast();
                }
                dq.addLast(node);
            }
            if(dq.peekLast().index - dq.peekFirst().index >= windowSize) dq.removeFirst();
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
}
