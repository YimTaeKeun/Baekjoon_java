package b_2535;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] temp;
        List<Integer[]> cal = new ArrayList<>();
        int[] chance = new int[n + 1];
        for(int i = 1; i <= n; i++) chance[i] = 2;
        for(int i = n; i > 0; i--){
            temp = br.readLine().split(" ");
            cal.add(new Integer[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])});
        }
        Collections.sort(cal, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] one, Integer[] two){
                return -(one[2] - two[2]);
            }
        });
        int winnerCnt = 0;
        for(Integer[] each: cal){
            if(chance[each[0]] != 0){
                chance[each[0]]--;
                winnerCnt++;
                System.out.println(each[0] + " " + each[1]);
            }
            if(winnerCnt == 3) break;
        }
    }
}
