package b_24511;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int qsCnt = Integer.parseInt(br.readLine());
        int[] qsInform = new int[qsCnt];
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < qsCnt; i++) qsInform[i] = Integer.parseInt(temp[i]);
        Deque<Integer> deque = new ArrayDeque<>();
        temp = br.readLine().split(" ");
        for(int i = 0; i < qsCnt; i++) if(qsInform[i] == 0) deque.addLast(Integer.parseInt(temp[i]));
        int cnt = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        for(int i = 0; i < cnt; i++){
            deque.addFirst(Integer.parseInt(temp[i]));
            bw.write(deque.pollLast() + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
