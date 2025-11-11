package b_11724;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
        boolean[][] arr = new boolean[n + 1][n + 1];
        for(int i = 1; i <= e; i++){
            String[] temp = br.readLine().split(" ");
            int one = Integer.parseInt(temp[0]), two = Integer.parseInt(temp[1]);
            arr[one][two] = true;
            arr[two][one] = true;
        }
        boolean[] visited = new boolean[n + 1]; // 1부터 n까지
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]) {
                dfs(i, visited, arr);
                result++;
            }
        }
        bw.write(result+"\n");
        bw.flush();
    }

    public static void dfs(int nodeValue, boolean[] visited, boolean[][] conList){
        Stack<Integer> stack = new Stack<>();
        stack.push(nodeValue);
        visited[nodeValue] = true;
        while(!stack.isEmpty()){
            int node = stack.peek();
            boolean flag = false;
            for(int i = 1; i < visited.length; i++){
                if(node != i && conList[node][i] && !visited[i]){
                    visited[i] = true;
                    stack.push(i);
                    flag = true;
                    break;
                }
            }
            if(!flag) stack.pop();
        }
    }
}
