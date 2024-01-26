package b_4562;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int t = scanner.nextInt(); t > 0; t--){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println((x < y) ? "NO BRAINS" : "MMM BRAINS");
        }
        scanner.close();
    }
}
