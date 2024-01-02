package b_10989;

import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] cal = new int[Integer.parseInt(br.readLine())];
        for(int i = 0; i < cal.length; i++) cal[i] = Integer.parseInt(br.readLine());
        Arrays.sort(cal);
        for(int each: cal) bw.write(each + "\n");
        bw.flush();
        bw.close();
    }
}
