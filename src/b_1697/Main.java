package b_1697;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNumber = scanner.nextInt(), endNumber = scanner.nextInt();
        int[] dp = new int[1000002];
        Arrays.fill(dp, -1);
        dp[startNumber] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNumber);
        int result = 1;
        while(dp[endNumber] == -1){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                int target = queue.poll();
                if(target - 1 >= 0 && dp[target - 1] == -1){
                    dp[target - 1] = result;
                    queue.add(target - 1);
                }
                if(target + 1 <= 1000001 && dp[target + 1] == -1){
                    dp[target + 1] = result;
                    queue.add(target + 1);
                }
                if(target * 2 <= 1000001 && dp[target * 2] == -1){
                    dp[target * 2] = result;
                    queue.add(target * 2);
                }
            }
            result++;
        }
        System.out.println(dp[endNumber]);
        scanner.close();
    }
}
