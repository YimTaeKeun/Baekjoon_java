package b_18111;

import java.io.*;
import java.util.*;
public class Main {
    static Long[][] board;
    static long blockCnt = 0;
    static long totalCnt = 0;
    static long min = 0;
    public static void main(String[] args) throws IOException{
        initiallize();
        if(min > 0) min--;
        final int GET = 2, PUT = 1;
        long targetFloor = (totalCnt + blockCnt) / (board.length * board[0].length);
        if(targetFloor > 256) targetFloor = 256;
        long time = 0;
        List<Long[]> results = new ArrayList<>();
        for(; targetFloor >= min; targetFloor--){
            Long[][] nowBoard = new Long[board.length][board[0].length];
            for(int i = 0; i < nowBoard.length; i++) nowBoard[i] = Arrays.copyOf(board[i], board[0].length);
            long nowBlockCnt = blockCnt;
            time = 0;
            boolean isChanged = false;
            long targetFloorCnt = 0;
            do{
                isChanged = false;
                targetFloorCnt = 0;
                for(int c = 0; c < nowBoard.length; c++){
                    for(int r = 0; r < nowBoard[0].length; r++){
                        if(targetFloor < nowBoard[c][r]){
                            nowBlockCnt += (nowBoard[c][r] - targetFloor);
                            time += (GET * (nowBoard[c][r] - targetFloor));
                            nowBoard[c][r] = targetFloor;
                            isChanged = true;
                        }
                        else if(targetFloor > nowBoard[c][r] && nowBlockCnt >= (targetFloor - nowBoard[c][r])){
                            nowBlockCnt -= (targetFloor - nowBoard[c][r]);
                            time += (PUT * (targetFloor - nowBoard[c][r]));
                            nowBoard[c][r] = targetFloor;
                            isChanged = true;
                        }
                        else if(targetFloor == nowBoard[c][r]) targetFloorCnt++;
                    }
                }
            }while(isChanged);
            if(targetFloorCnt == (long)nowBoard.length * (long)nowBoard[0].length) results.add(new Long[] {time, (long)targetFloor});
        }
        Long[] result = Collections.min(results, new Comparator<Long[]>() {
            @Override
            public int compare(Long[] target1, Long[] target2){
                if(target1[0] != target2[0]) return (int)(target1[0] - target2[0]);
                else return (int)(target2[1] - target1[1]);
            }
        });
        System.out.println(result[0] + " " + result[1]);
    }
    public static void initiallize() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int col = Integer.parseInt(temp[0]), row = Integer.parseInt(temp[1]);
        board = new Long[col][row];
        blockCnt = Integer.parseInt(temp[2]);
        for(int c = 0; c < col; c++){
            temp = br.readLine().split(" ");
            for(int r = 0; r < row; r++){
                long t = Long.parseLong(temp[r]);
                board[c][r] = t;
                totalCnt += t;
                min = Math.min(t, min);
            }
        }
    }
}
