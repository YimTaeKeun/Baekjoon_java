package b_2251;

import java.io.*;
import java.util.*;

public class Main {
    public static int aCap, bCap, cCap;
    public static int[] sender = new int[] {0, 0, 1, 1, 2, 2};
    public static int[] receiver = new int[] {1, 2, 0, 2, 0, 1};
    public static boolean[][] visited;
    public static boolean[] answer;
    public static int[] now;
    ArrayList<Integer> resultArr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        now = new int[3];
        now[0] = Integer.parseInt(temp[0]);
        now[1] = Integer.parseInt(temp[1]);
        now[2] = Integer.parseInt(temp[2]);
        visited = new boolean[201][201];
        answer = new boolean[201];
        // C->A, C->B, B->A, B->C, A->C, A->B: 6가지 방향으로 가능. 출발은 C.
        // 상태 DFS, BFS
        BFS();
        for(int i = 0; i < answer.length; i++){
            if(answer[i]) bw.write(i + " ");
        }
        bw.flush();

    }

    public static void BFS(){
        Queue<AB> q = new ArrayDeque<>();
        q.add(new AB(0, 0)); // 초기상태 설정
        visited[0][0] = true;
        answer[now[2]] = true; // 0, 0, cCap일 때를 저장
        while(!q.isEmpty()){
            AB cur = q.poll();
            int A = cur.A;
            int B = cur.B;
            int C = now[2] - A - B;
            // 6가지 방향 탐색
            for(int i = 0; i < 6; i++){
                int[] next = {A, B, C};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0; // 주는 컵 초기화
                if(next[receiver[i]] > now[receiver[i]]){ // 물이 넘칠 때
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]]; // 차이만큼 센더가 다시 가져감
                    next[receiver[i]] = now[receiver[i]]; // 리시버는 최댓값으로 설정
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    if(next[0] == 0) answer[next[2]] = true; // A물통 비어있을 때
                }
            }
        }
    }
}

class AB{
    int A;
    int B;
    public AB(int A, int B){
        this.A = A;
        this.B = B;
    }
}
