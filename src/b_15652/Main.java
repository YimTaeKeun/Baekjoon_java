package b_15652;

import java.util.*;
import java.io.*;

public class Main {
    // 1부터 N까지 M개를 고른 수열
    public static int N;
    public static int M;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        recursive(new Stack<>(), 0);
        bw.flush();
    }
    public static void recursive(Stack<Integer> stack, int count) throws IOException {
        if(count == M) {
            printStack((Stack<Integer>) stack.clone());
            return;
        }
        for(int i = (stack.isEmpty() ? 1 : stack.peek()); i <= N; i++) {
            stack.push(i);
            recursive(stack, count + 1);
            stack.pop();
        }
    }
    public static void printStack(Stack<Integer> stack) throws IOException{
        StringBuilder result = new StringBuilder();
        while(!stack.empty()){
            result.insert(0, stack.pop() + " ");
        }
        bw.write(result.toString() + "\n");
    }
}
