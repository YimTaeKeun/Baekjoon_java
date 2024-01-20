package b_1240;

import java.util.*;
import java.io.*;
public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        Node[] nodes = new Node[Integer.parseInt(temp[0]) + 1];
        int cmdCnt = Integer.parseInt(temp[1]);
        long sum = 0;
        for(int i = 0; i < nodes.length - 2; i++){
            temp = br.readLine().split(" ");
            int length = Integer.parseInt(temp[2]), one = Integer.parseInt(temp[0]), two = Integer.parseInt(temp[1]);
            if(nodes[one] == null) nodes[one] = new Node(one);
            if(nodes[two] == null) nodes[two] = new Node(two);
            nodes[one].childNodes.add(nodes[two]);
            nodes[one].lengths.add(length);
            nodes[two].childNodes.add(nodes[one]);
            nodes[two].lengths.add(length);
        }
        for(int i = 0; i < cmdCnt; i++){
            temp = br.readLine().split(" ");
            int fromIdx = Integer.parseInt(temp[0]), toIdx = Integer.parseInt(temp[1]);
            Deque<Node> nodesDeque = new ArrayDeque<>();
            Deque<Integer> lengthDeque = new ArrayDeque<>();
            nodesDeque.addAll(nodes[fromIdx].childNodes);
            lengthDeque.addAll(nodes[fromIdx].lengths);
            while(!nodesDeque.isEmpty()){
                Node nowNode = nodesDeque.pollFirst();
                int nowLength = lengthDeque.pollFirst();

            }
        }
    }
    public static void find(){
        
    }
}
class Node{
    private int data;
    public List<Integer> lengths = new ArrayList<>();
    public List<Node> childNodes = new ArrayList<>();
    Node(int data){this.data = data;}
    @Override
    public int hashCode(){return data;}
    @Override
    public boolean equals(Object obj){
        if(data == ((Node) obj).data) return true;
        return false;
    }
}
