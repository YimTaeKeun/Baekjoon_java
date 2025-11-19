package b_1043;

import java.io.*;
import java.util.*;

public class Main{
    public static int[] union_arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int peopleCnt = Integer.parseInt(st.nextToken()), partyCnt = Integer.parseInt(st.nextToken());
        union_arr = new int[peopleCnt + 1];
        for(int i = 0; i <= peopleCnt; i++) union_arr[i] = i; // 유니온 파인드 리스트 초기화
        // 진실 아는 사람 리스트 0 집단으로 이동
        st = new StringTokenizer(br.readLine());
        int realCnt = Integer.parseInt(st.nextToken());
        for(int i = 0; i < realCnt; i++) union_(0, Integer.parseInt(st.nextToken())); // 0 집합으로 이동
        // 파티 저장
        ArrayList<Integer>[] partyInfo = new ArrayList[partyCnt];
        for(int i = 0; i < partyCnt; i++) partyInfo[i] = new ArrayList<>(); // 리스트 초기화

        for(int i = 0; i < partyCnt; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Integer prev = null;
            boolean flag = false;
            for(int j = 0; j < n; j++){
                int nowPerson = Integer.parseInt(st.nextToken());
                partyInfo[i].add(nowPerson);
                if(find_(nowPerson) == 0) flag = true;
                if(prev != null) {
                    if(flag) union_(0, nowPerson);
                    else union_(prev, nowPerson);
                }
                prev = nowPerson;
            }
            if(flag){
                for(Integer person : partyInfo[i]){
                    union_(0, person);
                }
            }
        }

        // 파티 수 세기
        int cnt = 0;
        for(int i = 0; i < partyCnt; i++){
            if(isNoRealManInParty(partyInfo[i])) cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
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

    public static boolean isNoRealManInParty(ArrayList<Integer> persons){
        for(int i = 0; i < persons.size(); i++){
            if(find_(persons.get(i)) == 0) return false; // 진실을 아는 0번 집합인 경우 false
        }
        return true;
    }
}
