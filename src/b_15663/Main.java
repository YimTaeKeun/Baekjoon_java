package b_15663;

import java.util.*;
import java.io.*;

public class Main {
    public static int[] numbers;
    public static int m;
    public static ArrayList<String> li = new ArrayList<>();
    public static boolean[] visited;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);
        visited = new boolean[n];
        recursive(new Stack<>());
        bw.flush();

    }
    public static void recursive(Stack<Integer> stack) throws IOException {
        if(stack.size() == m){
            printStack((Stack<Integer>) stack.clone());
            return;
        }
        Integer prev = null;
        for(int i = 0; i < numbers.length; i++){
            if(!visited[i]){
                if(prev != null && prev == numbers[i]) continue;
                prev = numbers[i];
                visited[i] = true;
                stack.push(numbers[i]);
                recursive(stack);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void printStack(Stack<Integer> stack) throws IOException {
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop() + " ");
        }
        li.add(sb.toString());
        bw.write(sb + "\n");
    }
}
