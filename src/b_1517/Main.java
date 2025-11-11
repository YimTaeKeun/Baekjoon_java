package b_1517;

import java.io.*;
import java.util.*;

public class Main {
    public static Long ans = 0L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 데이터의 갯수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 데이터 입력 받음
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) arr.add(Integer.parseInt(st.nextToken()));
        arr = mergeSort(arr);
//        for(int i = 0; i < N; i++) bw.write(arr.get(i)+" ");
        bw.write(String.valueOf(ans));
        bw.flush();

    }
    public static List<Integer> mergeSort(List<Integer> arr){
        // 둘로 분리
        List<Integer> leftList =  new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for(int i = 0; i < arr.size() / 2; i++) leftList.add(arr.get(i));
        for(int i = arr.size() / 2; i < arr.size(); i++) rightList.add(arr.get(i));

        List<Integer> result = new ArrayList<>();

        if(leftList.size() > 1) leftList = mergeSort(leftList);
        if(rightList.size() > 1) rightList = mergeSort(rightList);
        int lCursor = 0, rCursor = 0;
        for(int i = 0 ; i < leftList.size() + rightList.size(); i++){
            Integer leftValue = (lCursor == leftList.size()) ? null : leftList.get(lCursor);
            Integer rightValue = (rCursor == rightList.size()) ? null : rightList.get(rCursor);
            if(leftValue == null) {
                result.add(rightValue);
                rCursor++;
            }
            else if(rightValue == null) {
                result.add(leftValue);
                lCursor++;
            }
            else if(leftValue <= rightValue){
                result.add(leftValue);
                lCursor++;
            }
            else{
                result.add(rightValue);
                ans += leftList.size() - lCursor;
                rCursor++;
            }
        }
        return result;
    }
}
