package b_1932;

import java.io.*;
import java.util.Arrays;
public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[Integer.parseInt(br.readLine()) + 1][];
        String[] temp;
        for(int i = 1; i < board.length; i++){
            board[i] = new int[i];
            temp = br.readLine().split(" ");
            for(int j = 0; j < i; j++) board[i][j] = Integer.parseInt(temp[j]);
        }
        if(board.length == 2) System.out.println(board[1][0]);
        else{
            int[] result = new int[] {board[1][0]};
            for(int i = 2; i < board.length; i++) result = getSumArr(result, board[i]);
            Arrays.sort(result);
            System.out.println(result[result.length - 1]);
        }
    }
    public static int[] getSumArr(int[] front, int[] back){
        int[] returnArr = new int[back.length];
        for(int f = 0; f < front.length; f++){
            returnArr[f] = Math.max(returnArr[f], front[f] + back[f]);
            returnArr[f + 1] = Math.max(returnArr[f + 1], front[f] + back[f + 1]);
        }
        return returnArr;
    }
}
