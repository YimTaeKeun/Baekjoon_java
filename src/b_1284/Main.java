package b_1284;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String a = sc.nextLine();
            if(a.equals("0")) break;
            int result = 2;
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) == '1') result += 2;
                else if(a.charAt(i) == '0') result += 4;
                else result += 3;
            }
            result += a.length() - 1;
            System.out.println(result);
        }
    }
}
