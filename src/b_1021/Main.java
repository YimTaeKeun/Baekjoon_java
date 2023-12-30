package b_1021;

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> calDeque = new ArrayDeque<>();
        String[] temp = br.readLine().split(" ");
        Queue<Integer> targets = new LinkedList<>();
        for(int i = 0; i < Integer.parseInt(temp[0]); i++) calDeque.addLast(i);
        temp = br.readLine().split(" ");
        for(int i = 0; i < temp.length; i++) targets.add(Integer.parseInt(temp[i]) - 1);
        long result = 0;
        while(!targets.isEmpty()){
            int target = targets.poll();
            result += whereIsTrue(calDeque, target);
        }
        System.out.println(result);
    }
    public static Integer whereIsTrue(Deque<Integer> calDeque, int target){
        Deque<Integer> lDeque = new ArrayDeque<>(), rDeque = new ArrayDeque<>();
        lDeque.addAll(calDeque);
        rDeque.addAll(calDeque);
        int l = 0, r = 0;
        while(lDeque.peekFirst() != target){
            lDeque.addLast(lDeque.pollFirst());
            l++;
        }
        while(rDeque.peekFirst() != target){
            rDeque.addFirst(rDeque.pollLast());
            r++;
        }
        calDeque.clear();
        if(l < r) calDeque.addAll(lDeque);
        else calDeque.addAll(rDeque);
        calDeque.pollFirst();
        return Math.min(l, r);
    }
}
