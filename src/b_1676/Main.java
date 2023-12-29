package b_1676;

import java.util.Scanner;
public class Main {
    static Integer[] result = new Integer[] {0, 0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int target = scanner.nextInt(); target > 1; target--){
            returnCnt(target);
        }
        System.out.println(Math.min(result[0], result[1]));
        scanner.close();
    }
    public static void returnCnt(int target){
        if(target % 2 == 0) {
            result[0]++;
            returnCnt(target / 2);
        }
        else if(target % 5 == 0){
            result[1]++;
            returnCnt(target / 5);
        }
    }
}
