package b_5524;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = Integer.parseInt(br.readLine()); i > 0; i--) sb.append(br.readLine().toLowerCase() + "\n");
        System.out.println(sb);
    }
}
