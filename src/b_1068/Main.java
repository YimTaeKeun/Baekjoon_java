package b_1068;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++) nodes.add(new Node(i));
        for(int i = 0; i < n; i++){
            int target = scanner.nextInt();
            if(target != -1) nodes.get(target).childNodes.add(nodes.get(i));
        }
        int removeIndex = scanner.nextInt();
        removeChildNodes(nodes, nodes.get(removeIndex).childNodes);
        nodes.set(nodes.indexOf(new Node(removeIndex)), null);
        for(Node each: nodes){
            if(each != null) each.childNodes.remove(new Node(removeIndex));
        }
        int cnt = 0;
        for(Node each: nodes){
            if(each != null && each.childNodes.isEmpty()) cnt++;
        }
        System.out.println(cnt);
        scanner.close();
    }
    public static void removeChildNodes(List<Node> nodes, List<Node> childNodes){
        if(childNodes.size() != 0){
            for(var each: childNodes) {
                nodes.remove(each);
                removeChildNodes(nodes, each.childNodes);
            }
        }
    }
}
class Node{
    int data;
    List<Node> childNodes = new ArrayList<>();
    Node(int data){this.data = data;}
    @Override
    public boolean equals(Object obj){return data == ((Node)obj).data;}
    @Override
    public int hashCode() {
        return data;
    }
}
