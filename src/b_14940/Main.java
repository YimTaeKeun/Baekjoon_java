package b_14940;

import java.util.*;
import java.io.*;

public class Main {
    public static int row, col;
    public static int[][] board;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp;
        temp = br.readLine().split(" ");
        row = Integer.parseInt(temp[0]);
        col = Integer.parseInt(temp[1]);
        board = new int[row][col];
        visited = new boolean[row][col];
        int startRow = 0, startCol = 0;
        for(int i = 0; i < row; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < col; j++) {
                if(temp[j].equals("2")){
                    startRow = i;
                    startCol = j;
                }
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }
        visited[startRow][startCol] = true;
        board[startRow][startCol] = 0;
        BFS(startRow, startCol);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(visited[i][j]) bw.write(board[i][j] + " ");
                else if(board[i][j] == 0) bw.write("0 ");
                else bw.write( "-1 ");
            }
            bw.newLine();
        }
        bw.flush();
    }
    public static void BFS(int startRow, int startCol){
        int[][] pos = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{startRow, startCol, 0}); // 마지막 원소는 본인에서 목표지점까지 떨어진 거리
        while(!q.isEmpty()){
            Integer[] now = q.poll();
            int r = now[0], c = now[1], distance = now[2];
            for(int i = 0; i < 4; i++){
                int nextRow = r + pos[i][0];
                int nextCol = c + pos[i][1];
                if(nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col){ // 좌표상 가능한가
                    if(board[nextRow][nextCol] != 0 && !visited[nextRow][nextCol]){
                        visited[nextRow][nextCol] = true;
                        board[nextRow][nextCol] = distance + 1;
                        q.add(new Integer[]{nextRow, nextCol, distance + 1});
                    }
                }
            }

        }
    }

}
