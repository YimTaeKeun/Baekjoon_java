package b_1033;

import java.util.*;
import java.io.*;

public class Main {
    public static long lcmNumber = 1;
    public static long[] results;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int materialCnt = Integer.parseInt(br.readLine());
        results = new long[materialCnt];
        List<List<Long[]>> arr = new ArrayList<>();
        List<Long> ratioNumbers = new ArrayList<>();
        for(int i = 0; i < materialCnt; i++) arr.add(new ArrayList<>());
        String[] temp;
        for(int i = 0; i < materialCnt - 1; i++){
            temp = br.readLine().split(" ");
            long aIdx = Long.parseLong(temp[0]), bIdx = Long.parseLong(temp[1]);
            long p = Long.parseLong(temp[2]), q = Long.parseLong(temp[3]);
            long div = gcd(p, q);
            ratioNumbers.add(p/div);
            ratioNumbers.add(q/div);
            arr.get((int)aIdx).add(new Long[] {bIdx, q / div, p/div});
            arr.get((int)bIdx).add(new Long[] {aIdx, p / div, q/div});
        }
        // 처리 시작
        for(int i = 0; i < ratioNumbers.size(); i++) lcmNumber *= ratioNumbers.get(i);
        boolean[] v = new boolean[materialCnt];
        v[0] = true;
        results[0] = lcmNumber;
        DFS(0, arr, v);
        long resultGcd = results[0];
        for(int i = 1; i < materialCnt; i++) resultGcd = gcd(resultGcd, results[i]);
        for(int i = 0; i < materialCnt; i++) bw.write(results[i] / resultGcd + " ");
        bw.newLine();
        bw.flush();

    }
    public static void DFS(int now, List<List<Long[]>> arr, boolean[] visit){
        List<Long[]> nowNodeList = arr.get(now);
        for(int i = 0; i < nowNodeList.size(); i++){
            Long[] nowNode = nowNodeList.get(i);
            int nextNodeNumber = nowNode[0].intValue();
            if(!visit[nextNodeNumber]){
                results[nextNodeNumber] = results[now] / nowNode[2] * nowNode[1];
                visit[nextNodeNumber] = true;
                DFS(nextNodeNumber, arr, visit);
            }
        }
    }
    public static long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b, a % b);
    }
}
