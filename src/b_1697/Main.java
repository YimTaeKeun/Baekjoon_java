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
            Integer[] temp = cal.poll();
            if(temp[0] == target){
                System.out.println(temp[1]);
                break;
            }
            if(temp[0] % 2 == 0) cal.add(new Integer[] {temp[0] / 2, temp[1] + 1});
            else{
                Boolean[] isThereResult = isThere(temp[0]);
                if(!isThereResult[0]) cal.add(new Integer[] {temp[0] - 1, temp[1] + 1});
                if(!isThereResult[1]) cal.add(new Integer[] {temp[0] + 1, temp[1] + 1});
            }
        }
        scanner.close();
    }
    public static Boolean[] isThere(int thisTarget){
        Boolean minus = false, plus = false;
        for(var each: cal){
            if(thisTarget + 1 == each[0] && !plus) plus = true;
            if(thisTarget - 1 == each[0] && !minus) minus = true;
            if(minus && plus) break;
        }
        return new Boolean[] {minus, plus};
    }
    
}
