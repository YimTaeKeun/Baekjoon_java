package b_15654;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        recursive(0, new Stack<>(), new boolean[arr.length]);
        bw.flush();
    }
    public static void recursive(int nowCursor, Stack<Integer> stack, boolean[] visited) throws IOException{
        if(stack.size() == M){
            printStack((Stack<Integer>) stack.clone());
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                stack.push(arr[i]);
                recursive(nowCursor + 1, stack, visited);
                stack.pop();
                visited[i] = false;
            }

        }
    }
    public static void printStack(Stack<Integer> stack) throws IOException{
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.insert(0, stack.pop() + " ");
        }
        bw.write(sb + "\n");
    }
}
