package b_7568;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer[]> cal = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            String[] temp = br.readLine().split(" ");
            cal.add(new Integer[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), i, 0});
        }
        Collections.sort(cal, new Comparator<Integer[]>() {
           @Override
           public int compare(Integer[] target1, Integer[] target2){
            if(target1[0] > target2[0] && target1[1] > target2[1]) return -1;
            else if(target1[0] < target2[0] && target1[1] < target2[1]) return 1;
            else return 0;
           } 
        });
        int ranking = 1;
        cal.get(0)[3] = 1;
        for(int i = 1; i < cal.size(); i++){
            Integer[] prev = cal.get(i - 1), now = cal.get(i);
            if(now[0] < prev[0] && now[1] < prev[1]) {
                cal.get(i)[3] = i + 1;
                ranking = i + 1;
            }
            else cal.get(i)[3] = ranking;
        }
        int[] rankArr = new int[cal.size()];
        for(Integer[] each: cal) rankArr[each[2]] = each[3];
        for(Integer each: rankArr) System.out.print(each + " ");
        System.out.println();
    }
}
