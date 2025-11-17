package b_28279;

import java.util.*;
import java.io.*;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        String[] temp;
        for(int i = 0; i < tc; i++){
            temp = br.readLine().split(" ");
            game(
                    Integer.parseInt(temp[0]),
                    (temp.length > 1) ? Integer.parseInt(temp[1]) : null,
                    dq
            );
        }
        bw.flush();
    }
    public static void game(Integer p1, Integer p2, Deque<Integer> deq) throws IOException{
        switch (p1){
            case 1:
                deq.addFirst(p2);
                break;
            case 2:
                deq.addLast(p2);
                break;
            case 3:
                bw.write(deq.isEmpty() ? "-1\n" : deq.pollFirst() + "\n");
                break;
            case 4:
                bw.write(deq.isEmpty() ? "-1\n" : deq.pollLast()  + "\n");
                break;
            case 5:
                bw.write(deq.size() + "\n");
                break;
            case 6:
                bw.write(deq.isEmpty() ? "1\n" : "0\n");
                break;
            case 7:
                bw.write(deq.isEmpty() ? "-1\n" : deq.peekFirst() + "\n");
                break;
            case 8:
                bw.write(deq.isEmpty() ? "-1\n" : deq.peekLast() + "\n");
                break;
        }
    }
}
