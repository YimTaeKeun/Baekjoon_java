package b_1717;

//import java.io.*;
//public class Main {
//    static int[] board;
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        String[] temp = br.readLine().split(" ");
//        int boardSize = Integer.parseInt(temp[0]);
//        int calculateCnt = Integer.parseInt(temp[1]);
//        board = new int[boardSize + 1];
//        for(int i = 1; i <= boardSize; i++) board[i] = i;
//        for(int i = 0; i < calculateCnt; i++){
//            temp = br.readLine().split(" ");
//            switch (Integer.parseInt(temp[0])) {
//                case 0:
//                    union(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
//                    break;
//                case 1:
//                    if(find(Integer.parseInt(temp[1])) == find(Integer.parseInt(temp[2]))) sb.append("YES\n");
//                    else sb.append("NO\n");
//                    break;
//            }
//        }
//        System.out.print(sb);
//    }
//    public static int find(int x){
//        if(board[x] != x) return find(board[x]);
//        return x;
//    }
//    public static void union(int x, int y){
//        x = find(x);
//        y = find(y);
//        if(x != y) board[y] = x;
//    }
//}

// 2025년 11월 18일 재풀이
import java.io.*;
import java.util.*;

public class Main{
    public static int[] union_arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), qCnt = Integer.parseInt(st.nextToken());
        union_arr = new int[n + 1];
        for(int i = 0; i <= n; i++) union_arr[i] = i;
        for(int i = 0; i < qCnt; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if(cmd.equals("0")) union_(a, b);
            else if(cmd.equals("1")) bw.write((find_(a) == find_(b)) ? "YES\n" : "NO\n");
        }
        bw.flush();
    }
    public static int find_(int x){
        if(union_arr[x] == x) return x;
        return union_arr[x] = find_(union_arr[x]); // 재대입
    }
    public static void union_(int a, int b){
        a = find_(a);
        b = find_(b);
        if(a == b) return;
        union_arr[b] = a;
    }
}