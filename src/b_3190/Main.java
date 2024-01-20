package b_3190;

import java.io.*;
import java.util.*;
public class Main {
    static boolean[][][] board;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new boolean[n][n][2];
        board[0][0][0] = true;
        String[] temp;
        int appleCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < appleCnt; i++){
            temp = br.readLine().split(" ");
            int col = Integer.parseInt(temp[0]) - 1;
            int row = Integer.parseInt(temp[1]) - 1;
            board[col][row][1] = true;
        }
        int cmdCnt = Integer.parseInt(br.readLine());
        Queue<String[]> cmdQueue = new LinkedList<>();
        for(int i = 0; i < cmdCnt; i++) cmdQueue.add(br.readLine().split(" "));
        Snake snake = new Snake();
        long resultTime = 0;
        boolean moveResult = true;
        do{
            moveResult = snake.moveBody();
            resultTime++;
            if(!cmdQueue.isEmpty() && resultTime == Integer.parseInt(cmdQueue.peek()[0])){
                String cmdStr = cmdQueue.poll()[1];
                snake.setMode(cmdStr);
            }
        }while(moveResult);
        System.out.println(resultTime);
    }
    static class Snake{
        Deque<Integer[]> snakeBodyPoses = new ArrayDeque<>();
        private List<Integer[]> modes = new ArrayList<>();
        private Integer[] mode;
        Snake(){
            modes.add(new Integer[] {0, 1});
            modes.add(new Integer[] {1, 0});
            modes.add(new Integer[] {0, -1});
            modes.add(new Integer[] {-1, 0});
            mode = modes.get(0);
            snakeBodyPoses.addLast(new Integer[] {0, 0});
        }
        public boolean moveBody(){
            int goCol = mode[0], goRow = mode[1];
            Integer[] tailPos = snakeBodyPoses.peekFirst();
            int movedColPos = tailPos[0] + goCol, movedRowPos = tailPos[1] + goRow;
            if(movedColPos == -1 || movedRowPos == -1 || movedColPos == n || movedRowPos == n || board[movedColPos][movedRowPos][0]) return false;
            snakeBodyPoses.addFirst(new Integer[] {movedColPos, movedRowPos});
            board[movedColPos][movedRowPos][0] = true;
            if(!board[movedColPos][movedRowPos][1]){
                Integer[] headPos = snakeBodyPoses.pollLast();
                board[headPos[0]][headPos[1]][0] = false;
            } else board[movedColPos][movedRowPos][1] = false;
            return true;
        }
        public void setMode(String modeString){
            if(modeString.equals("D")){
                int nowModePos = modes.indexOf(mode);
                if(nowModePos == 3) mode = modes.get(0);
                else mode = modes.get(nowModePos + 1);
            }
            else if(modeString.equals("L")){
                int nowModePos = modes.indexOf(mode);
                if(nowModePos == 0) mode = modes.get(3);
                else mode = modes.get(nowModePos - 1);
            }
        }
        public Integer[] getMode(){return mode;}
    }
}
