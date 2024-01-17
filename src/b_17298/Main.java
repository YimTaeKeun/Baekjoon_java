package b_17298;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        Stack<Integer> left = new Stack<>(), right = new Stack<>(), result = new Stack<>();
        for(int i = 0; i < cnt; i++) left.push(Integer.parseInt(temp[i]));
        for(int i = 0; i < cnt; i++){
            Integer target = left.pop();
            if(right.isEmpty()){
                right.push(target);
                result.push(-1);
                continue;
            }
            boolean flag = false;
            while(!right.isEmpty()){
                Integer rightCompare = right.peek();
                if(rightCompare > target){
                    flag = true;
                    result.push(rightCompare);
                    right.push(target);
                    break;
                }
                right.pop();
            }
            if(!flag){
                result.push(-1);
                right.push(target);
            }
        }
        for(int i = 0; i < cnt; i++) bw.write(result.pop() + " ");
        bw.write("\n");
        bw.flush();
    }
}
