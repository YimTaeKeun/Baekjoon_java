package b_11720;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] arr = s.toCharArray();
        int ans = 0;
        for(int i = 0; i < n; i++) ans += arr[i] - '0';
        bw.write(ans + "\n");
        bw.flush();
    }
}
