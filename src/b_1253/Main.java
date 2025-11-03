package b_1253;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextLong();
        int count = 0;
        Arrays.sort(arr);
        // two-pointer solving
        for(int k = 0; k < n; k++){
            int i = 0;
            int j = n - 1;
            while (i < j) {
                if(arr[i] + arr[j] == arr[k]){
                    if(i != k && j != k){
                        count++;
                        break;
                    }
                    if(i == k) i++;
                    if(j == k) j--;
                }
                else if (arr[i] + arr[j] > arr[k]) j--;
                else if (arr[i] + arr[j] < arr[k]) i++;
            }
        }
        System.out.println(count);
    }
}
