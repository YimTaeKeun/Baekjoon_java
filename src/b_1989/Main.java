package b_1989;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] preSum = new long[n + 1];
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            String temp  = st.nextToken();
            preSum[i] = preSum[i - 1] + Long.parseLong(temp);
            arr[i] = Integer.parseInt(temp);
        }
        Stack<Integer> monoStack = new Stack<>();
        long resultMax = 0;
        int resultMaxSIdx = 1;
        int resultMaxEIdx = 1;
        for(int i = 1; i <= n + 1; i++){
            int currentValue = (i == n + 1) ? 0 : arr[i];
            // 모노 스택이 비어있지 않고, 모노스택의 꼭대기의 인덱스의 arr 값이 더 크다면 일단 스탑
            while(!monoStack.isEmpty() && arr[monoStack.peek()] > currentValue){
                int p = monoStack.pop();
                int left = (monoStack.isEmpty()) ? 1 : monoStack.peek() + 1; // 모노 스택의 꼭짓점을 최솟값으로 함
                int right = i - 1;
                long s = (preSum[right] - preSum[left - 1]) * arr[p];
                if(s > resultMax){
                    resultMax = s;
                    resultMaxSIdx = left;
                    resultMaxEIdx = right;
                }
            }
            if(i <= n) monoStack.push(i);
        }
        bw.write(resultMax + "\n");
        bw.write(resultMaxSIdx + " " + resultMaxEIdx);
        bw.flush();
    }
}
