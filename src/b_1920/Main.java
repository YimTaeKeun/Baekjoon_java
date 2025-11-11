package b_1920;

// map 풀이도 있지만, 이진 탐색으로 풀 것

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        st = new StringTokenizer(br.readLine());
        int findCnt = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < findCnt; i++) bw.write(
                binarySearch(list, Integer.parseInt(st.nextToken())) ? "1\n" : "0\n"
        );
        bw.flush();
    }
    public static boolean binarySearch(List<Integer> sortedList, int target){
        int start = 0;
        int end = sortedList.size()-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(sortedList.get(mid) > target) end = mid-1;
            else if(sortedList.get(mid) < target) start = mid+1;
            else return true;
        }
        return false;
    }
}
