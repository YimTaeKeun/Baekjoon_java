package b_1697;

import java.util.*;
public class Main {
    public static Queue<Integer[]> cal  = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int target = scanner.nextInt();
        cal.add(new Integer[] {scanner.nextInt(), 0});
        while(true){
            Integer[] thisTarget = cal.poll();
            if(thisTarget[0] == target){
                System.out.println(thisTarget[1]);
                break;
            }
            Boolean[] chceckResult = isThere(thisTarget[0]);
            if(!chceckResult[0]) cal.add(new Integer[] {thisTarget[0] + 1, thisTarget[1] + 1});
            if(!chceckResult[1]) cal.add(new Integer[] {thisTarget[0] - 1, thisTarget[1] + 1});
            if(thisTarget[0] % 2 == 0 && !chceckResult[2]) cal.add(new Integer[] {thisTarget[0] / 2, thisTarget[1] + 1});
        }
        scanner.close();
    }
    public static Boolean[] isThere(int thisTarget){
        Boolean minus = false, plus = false, division = false;
        for(var each: cal){
            if(each[0] == thisTarget + 1 && !plus) plus = true;
            if(each[0] == thisTarget - 1 && !minus) minus = true;
            if(thisTarget % 2 == 0 && each[0] == thisTarget / 2) division = true;
            if(plus && minus && division) break;
        }
        return new Boolean[] {plus, minus, division};
    }
}
