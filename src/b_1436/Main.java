package b_1436;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int cnt = 1;
        long apoNum = 666;
        while(cnt++ != target){
            long i = apoNum + 1;
            for(; ; i++){
                if(String.valueOf(i).contains("666")) break;
            }
            apoNum = i;
        }
        System.out.println(apoNum);
        scanner.close();
    }
    
}
