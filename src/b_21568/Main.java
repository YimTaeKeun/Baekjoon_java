package b_21568;
// 확장 유클리드 호제법

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
        int[] result = extendedEuclidGcd(A, B);
        int gcdResult = gcd(A, B);
        int mul = C / gcdResult;
        if(C % gcdResult != 0) System.out.println("-1");
        else System.out.println(result[0] * mul + " " + result[1] * mul);
    }
    public static int[] extendedEuclidGcd(int a, int b){
        // 확장 유클리드 호제법
        if(b == 0) return new int[] {1, 0};
        int[] arr = extendedEuclidGcd(b, a % b);
        int x = arr[1], y = arr[0] - arr[1] * (a / b);
        return new int[] {x, y};
    }
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
