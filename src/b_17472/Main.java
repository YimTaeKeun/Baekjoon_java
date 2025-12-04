package b_17472;


import java.io.*;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int rowSize;
    public static int colSize;
    public static int islandCnt = 1;
    public static int[] union_arr;
    public static int[][] islandDist = new int[7][7]; // 최대 6개의 섬이 있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        board = new int[rowSize][colSize]; // 보드 초기화
        // 보드 입력
        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        // 보드 내부 섬에 번호를 붙임
        boolean[][] visited = new boolean[rowSize][colSize];
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                if(board[i][j] != 0 && !visited[i][j]) BFSBoard(i, j, visited);
            }
        }
        // 섬 간 최소 거리 구하기
        union_arr = new int[islandCnt + 1];
        for(int i = 0; i <= islandCnt; i++) union_arr[i] = i;
        calculateIslandDist();
        islandCnt--; // 실제 갯수는 하나 적으므로
        // MST 계산
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= islandCnt; i++){
            for(int j = i + 1; j <= islandCnt; j++){
                if(islandDist[i][j] > 1){ // 거리가 1 이상만
                    edges.add(new Edge(i, j, islandDist[i][j]));
                }
            }
        }
        edges.sort(null);
        int result = 0;
        int connectCnt = 0;
        boolean change = false;
        while(connectCnt < islandCnt - 1){
            change = false;
            for(Edge edge : edges){
                int from = find_(edge.from);
                int to = find_(edge.to);
                if(from == to) continue;
                union_(from, to);
                result += edge.weight;
                connectCnt++;
                change = true;
            }
            if(!change) break;
        }
        if(!change) bw.write("-1\n");
        else bw.write(result + "\n");
        bw.flush();


    }

    public static void calculateIslandDist(){
        // 행 계산
        for(int nowRow = 0; nowRow < rowSize; nowRow++){
            int zeroCnt = 0;
            Integer prev = null;
            for(int nowCol = 0; nowCol < colSize; nowCol++){
                int islandNumber = board[nowRow][nowCol];
                if(islandNumber != 0){
                    if(prev != null && prev != islandNumber && zeroCnt > 1){
                        if(islandDist[prev][islandNumber] == 0) {
                            islandDist[prev][islandNumber] = zeroCnt;
                            islandDist[islandNumber][prev] = zeroCnt;
                        }
                        else {
                            islandDist[prev][islandNumber] = Math.min(zeroCnt, islandDist[prev][islandNumber]);
                            islandDist[islandNumber][prev] = Math.min(zeroCnt, islandDist[islandNumber][prev]);
                        }
                    }
                    prev = board[nowRow][nowCol];
                    zeroCnt = 0;
                }
                else zeroCnt++;
            }
        }
        // 열 계산
        for(int nowCol = 0; nowCol < colSize; nowCol++){
            int zeroCnt = 0;
            Integer prev = null;
            for(int nowRow = 0; nowRow < rowSize; nowRow++){
                int islandNumber = board[nowRow][nowCol];
                if(islandNumber != 0){
                    if(prev != null && prev != islandNumber && zeroCnt > 1){
                        if(islandDist[prev][islandNumber] == 0) {
                            islandDist[prev][islandNumber] = zeroCnt;
                            islandDist[islandNumber][prev] = zeroCnt;
                        }
                        else {
                            islandDist[prev][islandNumber] = Math.min(zeroCnt, islandDist[prev][islandNumber]);
                            islandDist[islandNumber][prev] = Math.min(zeroCnt, islandDist[islandNumber][prev]);
                        }
                    }
                    prev = board[nowRow][nowCol];
                    zeroCnt = 0;
                }
                else zeroCnt++;
            }
        }
    }

    public static void BFSBoard(int startRow, int startCol, boolean[][] visited){
        Queue<Integer[]> q = new LinkedList<>();
        visited[startRow][startCol] = true;
        q.add(new Integer[]{startRow, startCol});
        board[startRow][startCol] = islandCnt;
        int[][] move = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하 좌우
        while(!q.isEmpty()){
            Integer[] node = q.poll();
            int nowRow = node[0];
            int nowCol = node[1];
            for(int p = 0; p < 4; p++){
                int nextRow = nowRow + move[p][0];
                int nextCol = nowCol + move[p][1];
                if(isRightPos(nextRow, nextCol) && !visited[nextRow][nextCol] && board[nextRow][nextCol] == 1){ // 움직일 수 있는 위치라면
                    visited[nextRow][nextCol] = true;
                    board[nextRow][nextCol] = islandCnt;
                    q.add(new Integer[]{nextRow, nextCol});
                }
            }
        }
        islandCnt++;
    }

    public static boolean isRightPos(int row, int col){
        if(row < 0 || row >= rowSize) return false;
        if(col < 0 || col >= colSize) return false;
        return true;
    }

    public static int find_(int x){
        if(union_arr[x] == x) return x;
        return union_arr[x] = find_(union_arr[x]);
    }

    public static void union_(int a, int b){
        a = find_(a);
        b = find_(b);
        if(a == b) return;
        union_arr[b] = a;
    }
}

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int weight;
    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
