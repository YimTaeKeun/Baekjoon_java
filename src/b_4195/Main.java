package b_4195;

import java.util.*;
import java.io.*;
public class Main {
    static int[] cal;
    static int[] rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = Integer.parseInt(br.readLine()); tc > 0 ; tc--){
            Map<String, Integer> nameToNum = new HashMap<>();
            int commandCnt = Integer.parseInt(br.readLine());
            cal = new int[2 * commandCnt];
            rank = new int[2 * commandCnt];
            for(int i = 0; i < rank.length; i++) rank[i] = 1;
            for(int i = 0; i < 2 * commandCnt; i++) cal[i] = i;
            int pos = 0, one = 0, two = 0;
            for(int i = 0; i < commandCnt; i++){
                String[] names = br.readLine().split(" ");
                if(nameToNum.get(names[0]) == null) nameToNum.put(names[0], pos++);
                if(nameToNum.get(names[1]) == null) nameToNum.put(names[1], pos++);
                one = nameToNum.get(names[0]);
                two = nameToNum.get(names[1]);
                union_set(one, two);
                // int r = find_root(one);
                // int result = 0;
                // for(int k = 0; k < pos; k++) if(find_root(k) == r) result++;
                sb.append(rank[find_root(one)] + "\n");
            }
        }
        System.out.print(sb);  
    }
    public static int find_root(int x){
        if(x != cal[x]) return cal[x] = find_root(cal[x]);
        return x;
    }
    public static void union_set(int x, int y){
        x = find_root(x);
        y = find_root(y);
        if(x == y) return;
        if(rank[x] > rank[y]){
            cal[y] = x;
            rank[x] += rank[y];
        }
        else{
            cal[x] = y;
            rank[y] += rank[x];
        }
    }
}
