package b_1927;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int temp = 0;
        while(n-- > 0){
            temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(pq.isEmpty()) bw.write("0\n");
                else bw.write(pq.poll() + "\n");
            }
            else pq.add(temp);
        }
        bw.flush();
    }
}
