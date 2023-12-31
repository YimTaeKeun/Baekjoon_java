package b_1051;

import java.io.*;
public class Main {
    static int col, row;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        col = Integer.parseInt(temp[0]);
        row = Integer.parseInt(temp[1]);
        Integer[][] board = new Integer[col][row];
        int result = 1;
        for(int i = 0; i < col; i++){
            String string = br.readLine();
            for(int j = 0; j < row; j++) board[i][j] = Integer.parseInt(string.substring(j, j + 1));
        }
        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; r++){
                int size = checkSize(board, board[c][r], c, r);
                if(size > result) result = size;
            }
        }
        System.out.println(result);
    }
    public static int checkSize(Integer[][] board, int target, int posC, int posR){
        int returnLength = 1, fixedPosC = posC,fixedPosR = posR;
        while(posC++ < col - 1 && posR++ < row - 1){
            if(board[posC][fixedPosR] == target && board[fixedPosC][posR] == target && board[posC][posR] == target && returnLength < posC - fixedPosC + 1) returnLength = posC - fixedPosC + 1;
        }
        return (returnLength * returnLength);
    }
    
}
