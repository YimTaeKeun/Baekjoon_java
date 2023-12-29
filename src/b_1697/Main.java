package b_1697;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Queue<Integer> cal = new LinkedList<>(), cal2 = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int time = 0;
        cal.add(scanner.nextInt());
        loop: while(true){
            while(!cal.isEmpty()){
                int temp = cal.poll();
                if(temp == target) break loop;
                if(temp % 2 == 0) cal2.add(temp / 2);
                else{
                    if(!cal.contains(temp - 1)) cal2.add(temp - 1);
                    if(!cal.contains(temp + 1)) cal2.add(temp + 1);
                }
            }
            cal.addAll(cal2);
            time++;
        }
        System.out.println(time);
        scanner.close();
    }
    
}
