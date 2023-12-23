package b_1966;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t > 0; t--){
            long result = 0;
            Queue<Integer> queue = new LinkedList<>();
            String[] temp = br.readLine().split(" ");
            final int documentCnt = Integer.parseInt(temp[0]);
            int targetNowIndex = Integer.parseInt(temp[1]);
            temp = br.readLine().split(" ");
            for(String each: temp) queue.add(Integer.parseInt(each));
            
            while(true){
                int targetPariority = queue.peek();
                if(!isBiggerThan(queue, targetPariority)){
                    result++;
                    queue.poll();
                    if(targetNowIndex == 0) break;
                    else targetNowIndex--;
                } else{
                    queue.add(queue.poll());
                    targetNowIndex--;
                    if(targetNowIndex < 0) targetNowIndex = queue.size() - 1;
                }
            }
            System.out.println(result);
        }
    }
    public static boolean isBiggerThan(Queue<Integer> queue, int pariority){
        for(Integer each: queue) if(each > pariority) return true;
        return false;
    }
}
