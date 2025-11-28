package b_5582;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String one = br.readLine();
        String two = br.readLine();
        bw.write(lcsNumber(one, two) + "\n");
        bw.flush();
    }

    public static int lcsNumber(String one, String two) {
        int[] prev = new int[two.length() + 1];
        int[] curr = new int[two.length() + 1];
        int max = 0;
        for(int i = 1; i <= one.length(); i++) {
            for(int j = 1; j <= two.length(); j++) {
                if(one.charAt(i - 1) == two.charAt(j - 1)) curr[j] = prev[j - 1] + 1;
            }
            prev = curr;
            curr = new int[two.length() + 1];
            for(Integer each : prev) if(each > max) max = each;
        }

        return max;
    }
}
