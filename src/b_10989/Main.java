package b_10989;

import java.io.*;
import java.util.Arrays;
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int[] cal = new int[Integer.parseInt(br.readLine())];
//        for(int i = 0; i < cal.length; i++) cal[i] = Integer.parseInt(br.readLine());
//        Arrays.sort(cal);
//        for(int each: cal) bw.write(each + "\n");
//        bw.flush();
//        bw.close();
//    }
//}

/**
 * 20251101 계수 정렬을 이용한 풀이
 * */

//public class Main{
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[10001];
//        for(int i = 0; i < N; i++) arr[Integer.parseInt(br.readLine())]++;
//        for(int i = 1; i <= 10000; i++) {
//            if(arr[i] == 0) continue;
//            for(int j = 1; j <= arr[i]; j++) bw.write(i + "\n");
//        }
//        bw.flush();
//    }
//}

/*
* 251107 기수 정렬을 이용한 풀이
* */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int maxJaritsu = 0;
        for (int i = 0; i < n; i++) {
            String inputValue = br.readLine();
            maxJaritsu = Math.max(maxJaritsu, inputValue.length());
            list.add(Integer.parseInt(inputValue));
        }

        for(int jaritsu = 0; jaritsu < maxJaritsu; jaritsu++){
            for(int i = 0; i < list.size(); i++) list = gisuSort(jaritsu, list);
        }
        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
    }

    public static List<Integer> gisuSort(Integer gijunJaritsu, List<Integer> list){
        ArrayList<Queue<Integer>> stackList = new ArrayList<>();
        for(int i = 0; i < 10; i++) stackList.add(new ArrayDeque<>());
        for (Integer integer : list) {
            String strInteger = String.valueOf(integer);
            if(strInteger.length() - 1 - gijunJaritsu < 0) stackList.get(0).add(integer);
            else stackList.get(strInteger.charAt(strInteger.length() - 1 - gijunJaritsu) - '0').add(integer);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Queue<Integer> queue = stackList.get(i);
            while (!queue.isEmpty()) result.add(queue.poll());
        }
        return result;
    }
}