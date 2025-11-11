package b_9663;

//import java.util.*;
//import java.io.*;
//
//public class Main {
//    public static boolean[][] board;
//    public static boolean[] columnVisit;
//    public static int result = 0;
//    public static void main(String[] args) throws IOException {
//        // 퀸은 기물이 막고 있지만 않는다면 상하 좌우 대각선 그 어느 곳에나 이동할 수 있음
//        // N개의 열에서 각 열에는 한 가지의 퀸만 올 수 있음. 행도 마찬가지
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine()); // N * N 체스판
//        board = new boolean[N][N]; // N * N 체스판 생성
//        for(int col = 0; col < N; col++){
//            // 무조건 첫 행 부터 dfs를 시작합니다.
//            columnVisit = new boolean[N];
//            columnVisit[col] = true;
//            board[0][col] = true;
//            dfs(0);
//            board[0][col] = false;
//        }
//        bw.write(result+"\n");
//        bw.flush();
//    }
//
//    public static void dfs(int row){
//        if(row == board.length - 1){
//            result++; // 결과 값에 포함
//            return;
//        }
//        for(int col = 0; col < board.length; col++){ // 다음 행에서 가능한 열 탐색
//            if(isPossible(row + 1, col)){ // 다음 행에서 가능한 열을 발견했다면
//                columnVisit[col] = true; // 방문한 열에 표시
//                board[row + 1][col] = true; // 보드에 표시
//                dfs(row + 1);
//                columnVisit[col] = false; // 방문한 열에 표시
//                board[row + 1][col] = false; // 보드에 표시
//            }
//        }
//
//    }
//
//    public static boolean isPossible(int nowRow, int nowCol){
//        if (columnVisit[nowCol]) return false;
//        for (int r = nowRow, c = nowCol; r >= 0 && c >= 0; r--, c--) {
//            if (board[r][c]) return false;
//        }
//        for (int r = nowRow, c = nowCol; r >= 0 && c < board.length; r--, c++) {
//            if (board[r][c]) return false;
//        }
//
//        return true;
//    }
//}

// NQueen 1차원 배열 풀이
import java.io.*;
import java.util.*;

public class Main{
    public static int[] arr;
    public static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n]; // index 행에는 value 열에 퀸이 있다
        for(int i = 0; i < n; i++) arr[i] = -1;
        for(int i = 0; i < n; i++){
            arr[0] = i;
            dfs(0);
            arr[0] = -1;
        }
        bw.write(result+"\n");
        bw.flush();
    }

    public static void dfs(int nowRow){
        if(nowRow == arr.length - 1){
            result++;
            return;
        }
        for(int col = 0; col < arr.length; col++){
            // 다음 행 탐색
            if(isPossible(nowRow + 1, col)){ // 그 다음행의 해당 열에서 가능한지 검사
                // 가능하다면
                arr[nowRow + 1] = col; // 행에 정보 등록
                dfs(nowRow + 1);
                arr[nowRow + 1] = -1; // 행에 정보 해제
            }
        }
    }

    public static boolean isPossible(int row, int col){
        // 위쪽 방향 체크
        for(int r = row; r >= 0; r--){
            if(arr[r] == col) return false;
        }
        // 대각선에 가능한가
        // 북서쪽 방향 체크
        for(int r = row, c = col; r >= 0 && c >= 0; r--, c--){
            if(arr[r] == c) return false;
        }
        // 북동쪽 방향 체크
        for(int r = row, c = col; r >= 0 && c < arr.length; r--, c++){
            if(arr[r] == c) return false;
        }
        return true;
    }
}
