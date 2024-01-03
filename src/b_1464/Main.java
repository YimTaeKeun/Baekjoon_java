package b_1464;

import java.util.*;
public class Main {
    static boolean isDecrease = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Character> deque = new ArrayDeque<>();
        String target = scanner.nextLine();
        boolean onBreak = false;
        while(true){
            deque.clear();
            int pos = turnTarget(deque, target);
            if(pos == -1) break;
            String temp = target;
            target = "";
            int n = deque.size();
            for(int i = 0; i < n; i++) target += Character.toString(deque.pollLast());
            if(target.length() > 0 && temp.substring(pos).length() > 0 && target.charAt(0) < temp.substring(pos).charAt(0) && target.charAt(target.length() - 1) > temp.substring(pos).charAt(0)) onBreak = true;
            target += temp.substring(pos);
            if(onBreak) break;
        }
        System.out.println(target);
        scanner.close();
    }
    public static int turnTarget(Deque<Character> deque, String string){
        isDecrease = true;
        boolean nowDecrease, flag = false;
        int pos = 0;
        for(; pos < string.length(); pos++){
            char pushTarget = string.charAt(pos);
            if(pos == 0) {
                deque.addFirst(pushTarget);
                continue;
            }
            nowDecrease = deque.peekLast() > pushTarget;
            if(!flag) {
                if(!nowDecrease) isDecrease = false;
                else isDecrease = true;
                flag = true;
                if(deque.peekLast() == pushTarget) flag = false;
                deque.addLast(pushTarget);
            }
            else if(deque.peekLast() == pushTarget) deque.addLast(pushTarget);
            else if((isDecrease && !nowDecrease) || (!isDecrease && nowDecrease)) return pos;
            else deque.addLast(pushTarget);
        }
        if(isDecrease) return pos;
        else return -1;
    }
}
