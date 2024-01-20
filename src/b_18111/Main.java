package b_18111;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int col = Integer.parseInt(temp[0]);
        int row = Integer.parseInt(temp[1]);
        long nowBlockCnt = Long.parseLong(temp[2]);
        long maxHeight = nowBlockCnt;
        int minHeight = -1;
        int[][] board = new int[col][row];
        for(int i = 0; i < col; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < row; j++){
                int c = Integer.parseInt(temp[j]);
                board[i][j] = c;
                maxHeight += c;
                if(minHeight == -1) minHeight = c;
                else minHeight = Math.min(minHeight, c);
            }
        }
        maxHeight /= (col * row);
        maxHeight = Math.min(maxHeight, 256);
        minHeight--;
        if(minHeight < 0) minHeight = 0;
        long ansTime = -1;
        long ansHeight = 0;
        for(long nowFloor = maxHeight; nowFloor >= minHeight; nowFloor--){
            long time = 0;
            for(int c = 0; c < col; c++){
                for(int r = 0; r < row; r++){
                    if(board[c][r] > nowFloor) time += 2 * (board[c][r] - nowFloor);
                    else if(board[c][r] < nowFloor) time += (nowFloor - board[c][r]);
                }
            }
            if(ansTime == -1){
                ansTime = time;
                ansHeight = nowFloor;
            }
            else{
                if(ansTime == time) ansHeight = Math.max(ansHeight, nowFloor);
                else if(ansTime > time){
                    ansTime = Math.min(ansTime, time);
                    ansHeight = nowFloor;
                }
            }
        }
        System.out.println(ansTime + " " + ansHeight);
    }
}
