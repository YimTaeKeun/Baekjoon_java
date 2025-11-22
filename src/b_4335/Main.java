package b_4335;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean newGame = true;
        int start = 0, end = 0;
        boolean flag = false;
        while(true){
            if(newGame){
                start = 1;
                end = 10;
                newGame = false;
                flag = false;
            }

            int t = Integer.parseInt(br.readLine());
            if(t == 0) break;
            String s = br.readLine();
            if(s.equals("too high")){
                if(end < t) continue;
                if(start >= t){
                    flag = true;
                    continue;
                }
                end = t - 1;
            }
            else if(s.equals("too low")){
                if(start > t) continue;
                if(end <= t){
                    flag = true;
                    continue;
                }
                start = t + 1;
            }
            else if(s.equals("right on")){
                if(!(start <= t && t <= end)) flag = true;
                newGame = true;
                if(flag) bw.write("Stan is dishonest\n");
                else bw.write("Stan may be honest\n");
            }
        }
        bw.flush();

    }
    public static boolean isHonest(int start, int end, int x){
        if(start < 1 || end > 10 || start > x || end < x) return false;
        return true;
    }
}
