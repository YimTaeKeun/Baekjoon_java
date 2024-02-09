package b_20301;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int howMany = scanner.nextInt(), k = scanner.nextInt(), toReverseTime = scanner.nextInt();
        int removeCnt = 0;
        boolean isReverse = false;
        Deque<Integer> calDeque = new ArrayDeque<>();
        for(int i = 1; i <= howMany; i++) calDeque.addLast(i);
        while(!calDeque.isEmpty()){
            removeCnt++;
            if(!isReverse){
                for(int i = 0; i < k - 1; i++) calDeque.addLast(calDeque.pollFirst());
                sb.append(calDeque.pollFirst() + "\n");
            }
            else{
                for(int i = 0; i < k - 1; i++) calDeque.addFirst(calDeque.pollLast());
                sb.append(calDeque.pollLast() + "\n");
            }
            if(removeCnt % toReverseTime == 0) isReverse = !isReverse;
        }
        System.out.println(sb);
        scanner.close();
    }
    
}
