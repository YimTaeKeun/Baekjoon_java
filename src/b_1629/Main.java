package b_1629;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        String target = scanner.next();
        // int howMany = scanner.nextInt();
        for(int i = 0; i < target.length(); i++) deque.addLast(Integer.parseInt(target.substring(i, i + 1)));
        scanner.close();
    }
}
