package b_15649;

//import java.util.*;
//import java.io.*;
//public class Main {
//    public static int TARGET_DEPTH = 0;
//    public static int n = 0;
//    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] temp = br.readLine().split(" ");
//        n = Integer.parseInt(temp[0]);
//        TARGET_DEPTH = Integer.parseInt(temp[1]);
//        for(int i = 1; i <= n; i++) {
//            boolean[] visited = new boolean[n + 1];
//            List<Integer> array = new ArrayList<>();
//            drf(array, visited, i);
//        }
//        bw.flush();
//    }
//    public static void drf(List<Integer> nowArray, boolean[] visited, int nowNode) throws IOException{
//        nowArray.add(nowNode);
//        if(nowArray.size() == TARGET_DEPTH) {
//            printArray(nowArray);
//            nowArray.remove(nowArray.size()-1);
//            return;
//        }
//        visited[nowNode] = true;
//        for(int i = 1; i <= n; i++) {
//            if(!visited[i]) {
//                drf(nowArray, visited, i);
//            }
//        }
//        nowArray.remove(nowArray.size()-1);
//        visited[nowNode] = false;
//    }
//
//    public static void printArray(List<Integer> list) throws IOException {
//        for(int i = 0; i < list.size(); i++) bw.write(list.get(i) + " ");
//        bw.newLine();
//    }
//}

// 주석을 활용하여 문제를 풀어봅니다.

import java.util.*;
import java.io.*;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, TARGET_DEPTH;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        TARGET_DEPTH = Integer.parseInt(temp[1]); // 선택 갯수를 의미합니다.

        // 노드를 1번부터 n번까지 반복합니다.
        // dfs로 풀이를 시작합니다.
        for(int i = 1; i <= n; i++){
            // i: 탐색 시작 노드
            // 매번 방문마다 visited는 초기화됩니다.
            // 1번부터 n번까지의 visited만 사용합니다.
            boolean[] visited = new boolean[n + 1];
            // 현재 진행된 array도 초기화 됩니다.
            // array를 바탕으로 출력합니다. array 길이가 max depth와 같다면 출력합니다.
            List<Integer> nowArray = new ArrayList<>();
            dfs(i, visited, nowArray);
        }
        bw.flush();
    }

    public static void dfs(int now, boolean[] visited, List<Integer> nowArray) throws IOException {
        visited[now] = true; // 현재 노드에 방문 기록 표시
        nowArray.add(now); // 현재 노드를 추가
        // array 길이가 max depth와 같다면 출력
        if(nowArray.size() == TARGET_DEPTH){
            // Array 출력
            printArray(nowArray);
            nowArray.remove(nowArray.size()-1); // 현재 노드를 제거
            visited[now] = false;
            return;
        }
        // 목표 깊이에 도달하지 못했을 경우

        for(int i = 1; i <= n; i++){
            // 현 지점에서 다음 노드 탐색 1번부터 n번까지 탐색
            if(!visited[i]){ // i번 노드를 방문하지 않았을 경우
                dfs(i, visited, nowArray);
            }
        }
        nowArray.remove(nowArray.size()-1);
        visited[now] = false;

    }

    public static void printArray(List<Integer> list) throws IOException{
        for(int i = 0; i < list.size(); i++) bw.write(list.get(i) + " ");
        bw.newLine();
    }
}
