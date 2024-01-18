package b_1935;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        Map<Character, Double> map = new HashMap<>();
        br.readLine();
        String equationString = br.readLine();
        for(int i = 0; i < equationString.length(); i++){
            char eqSub = equationString.charAt(i);
            if(map.get(eqSub) != null) stack.push(map.get(eqSub));
            else{
                if(eqSub >= 65 && eqSub <= 90){
                    double target = Double.parseDouble(br.readLine());
                    stack.push(target);
                    map.put(eqSub, target);
                }
                else{
                    double two = stack.pop(), one = stack.pop();
                    if(eqSub == '*') stack.push(one * two);
                    else if(eqSub == '+') stack.push(one + two);
                    else if(eqSub == '-') stack.push(one - two);
                    else if(eqSub == '/') stack.push(one / two);
                }
            }
        }
        System.out.printf("%.2f\n", Math.round(stack.pop() * 100) / 100.0);
    }
}
