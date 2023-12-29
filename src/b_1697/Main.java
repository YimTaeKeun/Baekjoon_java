package b_1697;

import java.util.*;
public class Main {
    public static Queue<Integer[]> cal  = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int target = scanner.nextInt();
        int starter = scanner.nextInt();
        cal.add(new Integer[] {starter, 0});
        while(true){
            Integer[] thisTarget = cal.poll();
            if(thisTarget[0] == target){
                System.out.println(thisTarget[1]);
                break;
            }
            Boolean[] chceckResult = isThere(thisTarget[0]);
            if(!chceckResult[0] && thisTarget[0] + 1 != target && thisTarget[0] < starter * 2) cal.add(new Integer[] {thisTarget[0] + 1, thisTarget[1] + 1});
            if(!chceckResult[1] && thisTarget[0] - 1 != target) cal.add(new Integer[] {thisTarget[0] - 1, thisTarget[1] + 1});
            if(thisTarget[0] % 2 == 0) cal.add(new Integer[] {thisTarget[0] / 2, thisTarget[1] + 1});
        }
        scanner.close();
    }
    public static Boolean[] isThere(int thisTarget){
        Boolean minus = false, plus = false;
        for(var each: cal){
            if(each[0] == thisTarget + 1 && !plus) plus = true;
            if(each[0] == thisTarget - 1 && !minus) minus = true;
            if(plus && minus) break;
        }
        return new Boolean[] {plus, minus};
    }
}
