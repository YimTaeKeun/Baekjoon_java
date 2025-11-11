package b_2178;

//import java.util.*;
//import java.io.*;
//
//public class Main {
//    public static boolean[][] board;
//    public static int row;
//    public static int col;
//    public static int result = 0;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] temp = br.readLine().split(" ");
//        row = Integer.parseInt(temp[0]);
//        col = Integer.parseInt(temp[1]);
//        board = new boolean[row][col];
//        for(int i = 0; i < row; i++){
//            String t = br.readLine();
//            for(int j = 0; j < col; j++) board[i][j] = (t.charAt(j) == '1');
//        }
//        DFS(0, 0);
//        bw.write(result + "\n");
//        bw.flush();
//    }
//    public static void DFS(int nowRow, int nowCol){
//        Queue<Integer[]> q = new ArrayDeque<>();
//        int movement = 1;
//        q.add(new Integer[]{nowRow, nowCol, movement});
//        while(!q.isEmpty()){
//            Integer[] now = q.poll();
//            if (now[0] == row - 1 && now[1] == col - 1) {
//                result = now[2];
//                break;
//            }
//            movement = now[2];
//            int row = now[0], col = now[1];
//            // 다음 노드 탐색 후 큐에 추가
//            addPossibleNodesInQueue(row, col, q, movement);
//        }
//    }
//
//    public static void addPossibleNodesInQueue(int nowRow, int nowCol, Queue<Integer[]> q, int movement){
//        // 위
//        if(nowRow - 1 >= 0 && board[nowRow - 1][nowCol]) {
//            board[nowRow - 1][nowCol] = false;
//            q.add(new Integer[]{nowRow - 1, nowCol, movement + 1});
//        }
//        // 아래
//        if(nowRow + 1 < row && board[nowRow + 1][nowCol]) {
//            board[nowRow + 1][nowCol] = false;
//            q.add(new Integer[]{nowRow + 1, nowCol, movement + 1});
//        }
//        // 오른쪽
//        if(nowCol + 1 < col && board[nowRow][nowCol + 1]) {
//            board[nowRow][nowCol + 1] = false;
//            q.add(new Integer[]{nowRow, nowCol + 1, movement + 1});
//        }
//        // 왼쪽
//        if(nowCol - 1 >= 0 && board[nowRow][nowCol - 1]) {
//            board[nowRow][nowCol - 1] = false;
//            q.add(new Integer[]{nowRow, nowCol - 1, movement + 1});
//        }
//    }
//}

//import java.io.*;
//import java.util.*;
//
//public class Main{
//    public static int row, col;
//    public static boolean[][] board;
//    public static int result = 0;
//    public static int[][] pos = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] temp = br.readLine().split(" ");
//        row = Integer.parseInt(temp[0]);
//        col = Integer.parseInt(temp[1]);
//        board = new boolean[row][col];
//        for(int i = 0; i < row; i++){
//            String t = br.readLine();
//            for(int j = 0; j < col; j++) board[i][j] = (t.charAt(j) == '1');
//        }
//        board[0][0] = false;
//        BFS(0, 0);
//        bw.write(result+"\n");
//        bw.flush();
//    }
//
//    public static void BFS(int r, int c){
//        int movement = 1;
//        Queue<Integer[]> q = new ArrayDeque<>();
//        q.add(new Integer[]{r, c, movement});
//        while(!q.isEmpty()){
//            Integer[] now = q.poll();
//            int nowRow = now[0], nowCol = now[1];
//            movement = now[2];
//            if(nowRow == row - 1 && nowCol == col - 1){
//                result = movement;
//                break;
//            }
//            boolean[] possibleList = getPossibleList(nowRow, nowCol);
//            for(int i = 0; i < possibleList.length; i++){
//                if(possibleList[i]){
//                    board[nowRow + pos[i][0]][nowCol + pos[i][1]] = false;
//                    q.add(new Integer[]{nowRow + pos[i][0], nowCol + pos[i][1], movement + 1});
//                }
//            }
//        }
//    }
//
//    public static boolean[] getPossibleList(int r, int c){
//
//        boolean[] possibleList = new boolean[4]; // 상하좌우
//        for(int i = 0; i < 4; i++){
//            int nextR = r + pos[i][0], nextC = c + pos[i][1];
//            if(nextC >= 0 && nextR >= 0 && nextR < row && nextC < col){
//                if(board[nextR][nextC]) possibleList[i] = true;
//            }
//        }
//        return possibleList;
//    }
//}

import java.util.*;
import java.io.*;

public class Main{
    public static int row, col; // 각 보드의 사이즈를 말합니다.
    public static boolean[][] board; // 보드를 말하며, 1인 경우 true로 표시. 그 이외에는 false
    public static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        row = Integer.parseInt(temp[0]);
        col = Integer.parseInt(temp[1]);
        board = new boolean[row][col];
        for(int i = 0; i < row; i++){
            String t = br.readLine(); // 각 행마다 입력 문자열 받아옴
            for(int j = 0; j < col; j++) board[i][j] = t.charAt(j) == '1'; // 1이라면 true, 0이라면 false로 저장
        }
        // 입력 끝. 알고리즘 처리 시작
        // 0, 0부터 row - 1, col - 1까지 도달해야함
        // BFS로 풀이
        // BFS 함수 인자로 현재 위치 보냄
        // BFS는 큐를 활용함. 재귀 X
        BFS(0, 0);
        bw.write(result+"\n");
        bw.flush();


    }
    public static void BFS(int r, int c){
        Queue<Integer[]> q = new ArrayDeque<>(); // 해당 큐에는 현재 위치, 해당 위치까지 시작점으로부터 걸어온 거리
        q.add(new Integer[]{r, c, 1}); // 0, 0부터 시작, 0, 0까지는 1번 걸음
        while(!q.isEmpty()){ // 큐를 다 쓸 때까지 (BFS)
            Integer[] nowNode = q.poll(); // 현재 노드 꺼내기
            int nowNodeRow = nowNode[0], nowNodeCol = nowNode[1]; // 행 열 가져오기
            int movement = nowNode[2]; // 움직인 거리
            if(nowNodeRow == row - 1 && nowNodeCol == col - 1){ // 목표 지점에 도달했다면
                result = movement;
                return; // 함수 잦체를 종료 시켜버려야함
            }
            // 다음 방문 지점을 탐색합니다.
            int[][] pos = new int[][] {{-1, 0}, {1, 0}, {-1, 0}, {0, 1}}; // 상하좌우
            for(int[] p: pos){
                // p 로는 {-1, 0}과 같은 1차원 배열 등장
                int nextRow = nowNodeRow + p[0], nextCol = nowNodeCol + p[1]; // 다음 탐색 위치
                if(isPossible(nextRow, nextCol)){
                    // 밤문 표시 먼저
                    // BFS는 큐에 추가할 때 방문 표시 해줘야함
                    board[nextRow][nextCol] = false;
                    q.add(new Integer[]{nextRow, nextCol, movement + 1}); // 움직임을 현재 움직임에서 증가하여 저장
                }
            }
        }
    }

    public static boolean isPossible(int r, int c){
        // 해당 지점 (row, col)에서 방문 가능한지 묻기
        if(r >= 0 && r < row && c >= 0 && c < col) {
            //일단 범위 안에 있음
            // r, c가 true이면 방문 가능
            if(board[r][c]) return true;
        }
        return false; // 범위 외에 있는 좌표이므로 false
    }
}
