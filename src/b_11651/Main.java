package b_11651;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer[]> cal = new ArrayList<>();
        for(int i = Integer.parseInt(br.readLine()); i > 0; i--){
            String[] temp = br.readLine().split(" ");
            cal.add(new Integer[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])});
        }
        Collections.sort(cal, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] target1, Integer[] target2){
                if(target1[1].equals(target2[1])) return target1[0] - target2[0];
                else return target1[1] - target2[1];
            }
        });
        for(Integer[] each: cal) System.out.println(each[0] + " " + each[1]);
    }
    
}
