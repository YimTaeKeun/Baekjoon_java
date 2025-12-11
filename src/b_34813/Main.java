package b_34813;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char target = s.charAt(0);
        if(target == 'F') System.out.println("Foundation");
        else if(target == 'C') System.out.println("Claves");
        else if(target == 'V') System.out.println("Veritas");
        else if(target == 'E') System.out.println("Exploration");
    }
}
