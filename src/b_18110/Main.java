package b_18110;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cal = new int[Integer.parseInt(br.readLine())];
        for(int i = 0; i < cal.length; i++) cal[i] = Integer.parseInt(br.readLine());
        Arrays.sort(cal);
        int cut = (int) Math.round(cal.length * 0.15);
        long sum = 0;
        for(int i = cut; i < cal.length - cut; i++) sum += cal[i]; 
        System.out.println((long) Math.round((double) sum /(cal.length - 2 * cut)));
    }
    
}
