package b_11723;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[] v =  new boolean[21];
        String[] cmd;
        for(int i = 0; i < n; i++){
            cmd = br.readLine().split(" ");
            Integer value = (cmd.length > 1) ? Integer.parseInt(cmd[1]) : null;
            if(cmd[0].equals("add")) v[value] = true;
            else if(cmd[0].equals("remove")) v[value] = false;
            else if(cmd[0].equals("check")) bw.write((v[value]) ? "1\n" : "0\n");
            else if(cmd[0].equals("toggle")){
                if(v[value]) v[value] = false;
                else v[value] = true;
            }
            else if(cmd[0].equals("all")) Arrays.fill(v, true);
            else if(cmd[0].equals("empty")) Arrays.fill(v, false);
        }
        bw.flush();
    }
}
