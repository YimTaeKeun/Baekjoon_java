package b_17299;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> left = new Stack<>(), right = new Stack<>(), result = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < cnt; i++) {
            int elem = Integer.parseInt(temp[i]);
            if(map.get(elem) == null) map.put(elem, 0);
            map.put(elem, map.get(elem) + 1);
            left.push(elem);
        }
        for(int i = 0; i < cnt; i++){
            int target = left.pop();
            boolean flag = false;
            if(i == 0){
                right.push(target);
                result.push(-1);
                continue;
            }
            while(!right.isEmpty()){
                int rightTarget = right.peek();
                if(map.get(rightTarget) > map.get(target)){
                    flag = true;
                    right.push(target);
                    result.push(rightTarget);
                    break;
                }
                right.pop();
            }
            if(!flag){
                right.push(target);
                result.push(-1);
            }
        }
        for(int i = 0; i < cnt; i++) bw.write(result.pop() + " ");
        bw.write("\n");
        bw.flush();
    }
}
