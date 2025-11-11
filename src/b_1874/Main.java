package b_1874;

import java.util.*;
import java.io.*;

public class Main {
    static int nowMaximum = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean isNo = false;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> resultList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int inputCnt = 0; inputCnt < n; inputCnt++){
            int inputValue = Integer.parseInt(br.readLine());
            boolean result = calculateStack(stack, inputValue, resultList);
            if(!result) isNo = true;
        }
        if(isNo) bw.write("NO");
        else {
            for (Character c : resultList) bw.write(c + "\n");
        }
        bw.flush();
    }
    public static boolean calculateStack(Stack<Integer> stack, int inputValue, ArrayList<Character> resultList){
        if(stack.isEmpty()){
            for(; nowMaximum <= inputValue; nowMaximum++) {
                resultList.add('+');
                stack.add(nowMaximum);
            }
        }
        else if (stack.peek() > inputValue) return false;
        else if(stack.peek() < inputValue){
            for(; nowMaximum <= inputValue; nowMaximum++) {
                resultList.add('+');
                stack.add(nowMaximum);
            }
        }
        resultList.add('-');
        stack.pop();
        return true;
    }
}
