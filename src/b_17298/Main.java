package b_17298;
//
//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int cnt = Integer.parseInt(br.readLine());
//        String[] temp = br.readLine().split(" ");
//        Stack<Integer> left = new Stack<>(), right = new Stack<>(), result = new Stack<>();
//        for(int i = 0; i < cnt; i++) left.push(Integer.parseInt(temp[i]));
//        for(int i = 0; i < cnt; i++){
//            Integer target = left.pop();
//            if(right.isEmpty()){
//                right.push(target);
//                result.push(-1);
//                continue;
//            }
//            boolean flag = false;
//            while(!right.isEmpty()){
//                Integer rightCompare = right.peek();
//                if(rightCompare > target){
//                    flag = true;
//                    result.push(rightCompare);
//                    right.push(target);
//                    break;
//                }
//                right.pop();
//            }
//            if(!flag){
//                result.push(-1);
//                right.push(target);
//            }
//        }
//        for(int i = 0; i < cnt; i++) bw.write(result.pop() + " ");
//        bw.write("\n");
//        bw.flush();
//    }
//}






import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>(), tempStack = new Stack<>(), resultStack = new Stack<>();
        for(int i = 0; i < n; i++) stack.push(Integer.parseInt(arr[i]));
        while(!stack.isEmpty()){
            int now = stack.pop();
            if(tempStack.isEmpty()){
                tempStack.push(now);
                resultStack.push(-1);
                continue;
            }
            while(!tempStack.isEmpty()){
                if(now < tempStack.peek()){
                    resultStack.push(tempStack.peek());
                    break;
                }
                else{
                    tempStack.pop();
                    if(tempStack.isEmpty()){
                        resultStack.push(-1);
                    }
                }
            }
            tempStack.push(now);
        }
        while(!resultStack.isEmpty()) bw.write(resultStack.pop() + " ");
        bw.flush();
    }
}





















