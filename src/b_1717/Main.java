package b_1717;

import java.io.*;
public class Main {
    static int[] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        int boardSize = Integer.parseInt(temp[0]);
        int calculateCnt = Integer.parseInt(temp[1]);
        board = new int[boardSize + 1];
        for(int i = 1; i <= boardSize; i++) board[i] = i;
        for(int i = 0; i < calculateCnt; i++){
            temp = br.readLine().split(" ");
            switch (Integer.parseInt(temp[0])) {
                case 0:
                    union(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
                    break;
                case 1:
                    if(find(Integer.parseInt(temp[1])) == find(Integer.parseInt(temp[2]))) sb.append("YES\n");
                    else sb.append("NO\n");
                    break;
            }
        }
        System.out.print(sb);
    }
    public static int find(int x){
        if(board[x] != x) return find(board[x]);
        return x;
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) board[y] = x;
    }
}
