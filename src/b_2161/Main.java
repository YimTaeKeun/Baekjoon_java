package b_2161;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        for(int i = 1; i <= target; i++) deque.addLast(i);
        do{
            System.out.print(deque.pollFirst() + " ");
            if(!deque.isEmpty()) deque.addLast(deque.pollFirst());
        }while(!deque.isEmpty());
        System.out.println();
        scanner.close();
    }
}
