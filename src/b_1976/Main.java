package b_1976;

import java.util.*;
import java.io.*;

public class Main {
    public static int[] union_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cityCnt = Integer.parseInt(br.readLine());
        union_arr = new int[cityCnt + 1];
        for(int i = 0; i <= cityCnt; i++) union_arr[i] = i;

        int planCnt = Integer.parseInt(br.readLine());
        for(int i = 1; i <= cityCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= cityCnt; j++) {
                if(st.nextToken().equals("1")) union_(i, j);
            }
        }

        Integer prev = null;
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean answer = true;
        for(int i = 0; i < planCnt; i++) {
            if(prev == null) {
                prev = find_(Integer.parseInt(st.nextToken()));
                continue;
            }
            if(prev != find_(Integer.parseInt(st.nextToken()))){
                answer = false;
                break;
            }
        }
        bw.write(answer ? "YES" : "NO");
        bw.flush();
    }

    public static int find_(int x){
        if(union_arr[x] == x) return x;
        return union_arr[x] = find_(union_arr[x]);
    }

    public static void union_(int x, int k){
        x = find_(x);
        k = find_(k);
        if(x == k) return;
        union_arr[k] = x;
    }
}
