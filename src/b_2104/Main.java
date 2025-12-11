package b_2104;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n + 1];
        long[] preSum = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            String temp = st.nextToken();
            arr[i] = Long.parseLong(temp);
            preSum[i] += preSum[i-1] + arr[i];
        }
        Stack<Integer> monoStack = new Stack<>();
        long result = 0;
        for(int i = 1; i <= n + 1; i++){
            long cur = (i == n + 1) ? 0 : arr[i];
            while(!monoStack.isEmpty() && arr[monoStack.peek()] > cur){
                int p = monoStack.pop();
                int left = (monoStack.isEmpty()) ? 1 : monoStack.peek() + 1;
                int right = i - 1; // 현재 값 전까지
                result = Math.max(result, (preSum[right] - preSum[left - 1]) * arr[p]);
            }
            if(i <= n) monoStack.push(i);
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
