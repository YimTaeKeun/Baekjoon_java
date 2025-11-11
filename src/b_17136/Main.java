package b_17136;

import java.util.*;
import java.io.*;

public class Main {
    public static int[] paperCnt = new int[] {0, 5, 5, 5, 5, 5}; // idx * idx 색종이 현재 갯수
    public static boolean[][] board = new boolean[10][10];
    public static boolean[][] v = new boolean[10][10];
    public static int result = -1;
    public static boolean isImpossible = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 10; i++){
            String[] temp = br.readLine().split(" ");
            v[i] = new boolean[10];
            for(int j = 0; j < 10; j++) {
                board[i][j] = temp[j].equals("1");
            }
        }
        // 시작점을 잡습니다.
        dfs(0, 0, 0);
//        if(isImpossible) bw.write("-1\n");
        bw.write(result + "\n");
        bw.flush();
    }

    public static void dfs(int startRow, int startCol, int nowPaperCnt){
//        if(isImpossible) return;
        for(int i = startRow; i < 10; i++){
            int j = 0;
            if(i == startRow) j = startCol;
            for(; j < 10; j++){
//                System.out.println(i + " " + j + "탐색");
                if(board[i][j] && !v[i][j]){ // board에 true라고 되어 있고 한번도 방문한 적이 없었다면
                    // board[i][j]는 start 점으로 합격
                    for(int k = 5; k >= 1; k--){
                        if(isPossible(i, j, k)){ // start 지점에ㅐ서부터 size 만큼의 크기가 된다면, 여기서 종이 갯수는 고려 X
//                            System.out.println(i + " " + j + "에 " + k + " size 가능");
                            if(paperCnt[k] == 0){
//                                System.out.println(k + "사이즈 종이 부족");
                                isImpossible = true;
                                continue;
                            }
                            isImpossible = false;
                            for(int r = i; r < i + k; r++){
                                for(int c = j; c < j + k; c++) v[r][c] = true;
                            }
                            paperCnt[k]--;
                            v[i][j] = true;
                            if(j == 9){
                                if (i == 9){
                                    // 1 by 1밖에 안됨
                                    nowPaperCnt++;
                                    break;
                                }
                                else dfs(i + 1, 0, nowPaperCnt + 1);
                            }
                            else {
//                                System.out.println("dfs 실행");
                                dfs(i, j + 1, nowPaperCnt + 1);
                            }
//                            System.out.println("dfs 나옴");
                            paperCnt[k]++;
                            for(int r = i; r < i+ k; r++){
                                for(int c = j; c < j + k; c++) v[r][c] = false;
                            }
                            if(k == 1) return;
                        }
                    }
                }
                if(i == 9 && j == 9){
                    if((result == -1 || result > nowPaperCnt) && !isImpossible){
//                        System.out.println("들어오긴함" + nowPaperCnt);
                        result = nowPaperCnt;
                        return;
                    }
                }
            }
        }
    }

    public static boolean isPossible(int startRow, int startCol, int size){
        // startRow, startCol 부터 시작해서 size 만큼의 크기를 가질 수 있는지 체크합니다.
        for(int i = startRow; i < startRow + size; i++){
            if(i >= 10) return false;
            for(int j = startCol; j < startCol + size; j++){
                if(j >= 10) return false;
                if(!board[i][j]) return false;
            }
        }
        return true;
    }
}
