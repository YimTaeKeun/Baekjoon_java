package b_1946;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t > 0; t--){
            List<Integer[]> list = new ArrayList<>(), list2 = new ArrayList<>();
            int cnt = 0;
            for(int i = Integer.parseInt(br.readLine()); i > 0; i--){
                String[] temp = br.readLine().split(" ");
                list.add(new Integer[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])});
            }
            list2.addAll(list);
            list.sort((x, y) -> {return (x[0] - y[0]);});
            list2.sort((x, y) -> {return (x[1] - y[1]);});
            boolean can = true;
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < i; j++) can = isPick(list2, list2.indexOf(list.get(i)), list.get(j));
                if(can) cnt++;
            }
            System.out.println(cnt);
        }
    }
    public static boolean isPick(List<Integer[]> list2, int pos, Integer[] target){
        if(list2.indexOf(target) < pos) return false;
        return true;
    }
}
