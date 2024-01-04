package b_1464;

import java.util.*;
public class Main {
    static boolean isDecrease = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        String result = "";
        result += target.charAt(0);
        for(int i = 1; i < target.length(); i++){
            if(result.charAt(i - 1) < target.charAt(i)) result = target.charAt(i) + result;
            else result += target.charAt(i);
        }
        for(int i = result.length() - 1; i >= 0; i--) System.out.print(result.charAt(i));
        System.out.println();
        scanner.close();
    }
}
