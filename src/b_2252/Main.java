package b_2252;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken()), qCnt = Integer.parseInt(st.nextToken());
        int[] arr = new int[nodeCnt + 1]; // 위상 정렬 array
        ArrayList<Integer>[] lists = new ArrayList[nodeCnt + 1];
        for(int i = 0; i <= nodeCnt; i++) lists[i] = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < qCnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
            arr[end]++;
        }
        boolean[] visited = new boolean[nodeCnt + 1];
        while(resultList.size() != nodeCnt){
            for(int i = 1; i <= nodeCnt; i++){
                if(arr[i] == 0 && !visited[i]){
                    // 위상 정렬 실행 조건
                    resultList.add(i);
                    visited[i] = true;
                    ArrayList<Integer> li = lists[i];
                    for(Integer each: li) arr[each]--;
                }
            }
        }
        for(int i = 0; i < resultList.size(); i++) bw.write(resultList.get(i)+" ");
        bw.flush();
    }
}
