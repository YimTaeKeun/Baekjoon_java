package b_1940;

// 배열 풀이
//import java.util.*;
//import java.io.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int matCount = sc.nextInt();
//        int targetSum = sc.nextInt();
//        boolean[] arr = new boolean[100001];
//        int count = 0;
//        for(int i = 0; i < matCount; i++) arr[sc.nextInt()] = true;
//        if(targetSum <= 200000){
//            for(int i = 1; i <= targetSum / 2; i++){
//                if(arr[i] && i < targetSum - i && arr[targetSum - i]) count++;
//            }
//        }
//        System.out.println(count);
//
//    }
//}
// 투 포인터 풀이

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int targetSum = sc.nextInt();
        int count = 0;
        if(targetSum <= 200000){
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < n; i++) arr.add(sc.nextInt());
            Collections.sort(arr);
            for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    if(arr.get(i) + arr.get(j) == targetSum){
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}