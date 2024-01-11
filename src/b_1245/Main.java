package b_1245;

import java.io.*;
import java.util.*;
public class Main {
    static int[][][] board;
    static int cnt = 0, col = 0, row = 0;
    static Deque<Integer[]> posDeque;
    public static void main(String[] args) throws IOException{
        // 1은 방문, 0은 노방문
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        col = Integer.parseInt(temp[0]);
        row = Integer.parseInt(temp[1]);
        board = new int[col][row][2];
        for(int i = 0; i < col; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < row; j++) board[i][j] = new int[] {Integer.parseInt(temp[j]), 0};
        }
        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; r++){
                if(board[c][r][1] == 0){
                    posDeque = new ArrayDeque<>();
                    if(isPeek(c, r)){
                        cnt++;
                        board[c][r][1] = 1;
                        Deque<Integer[]> tempDeque = new ArrayDeque<>();
                        boolean flag = false;
                        while(!posDeque.isEmpty()){
                            Integer[] pos = posDeque.pollFirst();
                            if(isPeek(pos[0], pos[1])){
                                board[pos[0]][pos[1]][1] = 1;
                                tempDeque.addLast(pos);
                            }
                            else{
                                board[c][r][1] = 0;
                                cnt--;
                                flag = true;
                                break;
                            }
                        }
                        if(flag){
                            while(!tempDeque.isEmpty()){
                                Integer[] pos = tempDeque.pollFirst();
                                board[pos[0]][pos[1]][1] = 0;
                            }
                        }
                        tempDeque.clear();
                        posDeque.clear();
                    }
                }
            }
        }
        System.out.println(cnt);
    }
    public static boolean isPeek(int posC, int posR){
        int target = board[posC][posR][0];
        Deque<Integer[]> tempDeque = new ArrayDeque<>();
        for(int c = posC - 1; c < posC + 2; c++){
            if(c >= 0 && c < col){
                for(int r = posR - 1; r < posR + 2; r++){
                    if((r >= 0 && r < row) && !(c == posC && r == posR)){
                        if(board[c][r][0] > target) return false;
                        else if(board[c][r][1] == 0 && board[c][r][0] == target) tempDeque.addLast(new Integer[] {c, r});
                    }
                }
            }
        }
        posDeque.addAll(tempDeque);
        return true;
    }
}
