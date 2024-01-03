package b_1464;

import java.util.*;
public class Main {
    static boolean isDecrease = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String target = scanner.nextLine();
        while(true){
            stack.clear();
            int pos = turnTarget(stack, target);
            if(pos == -1) break;
            String temp = target;
            target = "";
            int n = stack.size();
            for(int i = 0; i < n; i++) target += Character.toString(stack.pop());
            target += temp.substring(pos);
            if(pos == temp.length() - 1 && isDecrease) break;
        }
        System.out.println(target);
        scanner.close();
    }
    public static int turnTarget(Stack<Character> stack, String string){
        isDecrease = true;
        boolean nowDecrease, flag = false;
        int pos = 0;
        for(; pos < string.length(); pos++){
            char pushTarget = string.charAt(pos);
            if(pos == 0) {
                stack.push(pushTarget);
                continue;
            }
            nowDecrease = stack.peek() > pushTarget;
            if(!flag) {
                if(!nowDecrease) isDecrease = false;
                else isDecrease = true;
                flag = true;
                if(stack.peek() == pushTarget) flag = false;
                stack.push(pushTarget);
            }
            else if(stack.peek() == pushTarget) stack.push(pushTarget);
            else if((isDecrease && !nowDecrease) || (!isDecrease && nowDecrease)) return pos;
            else stack.push(pushTarget);
        }
        if(isDecrease) return pos;
        else return -1;
    }
}
