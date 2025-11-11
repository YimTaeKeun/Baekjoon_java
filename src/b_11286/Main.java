package b_11286;

//import java.util.*;
//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//        Map<Integer, Integer[]> map = new HashMap<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < N; i++) {
//            int inputValue = Integer.parseInt(br.readLine());
//            if(inputValue == 0){
//                if(pq.isEmpty()) bw.write("0\n");
//                else{
//                    int pqValue = pq.peek();
//                    Integer[] mapValue = map.get(pqValue);
//                    if(mapValue[0] > 0) {
//                        bw.write(String.valueOf(-pqValue) + "\n");
//                        mapValue[0]--;
//                    }
//                    else if(mapValue[1] > 0){
//                        bw.write(String.valueOf(pqValue) + "\n");
//                        mapValue[1]--;
//                    }
//                    if(mapValue[0] == 0 && mapValue[1] == 0){
//                        pq.poll();
//                        map.remove(pqValue);
//                    }
//                }
//            }
//            else{
//                int absValue = Math.abs(inputValue);
//                if(!map.containsKey(absValue)){
//                    pq.add(absValue);
//                    if(inputValue < 0) map.put(absValue, new Integer[]{1, 0});
//                    else map.put(absValue, new Integer[]{0, 1});
//                }
//                else{
//                    Integer[] keyValue = map.get(absValue);
//                    if(inputValue < 0) keyValue[0]++;
//                    else keyValue[1]++;
//                    map.put(absValue, keyValue);
//                }
//            }
//        }
//        bw.flush();
//    }
//}




// priority queue로만 풀어보기
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    int abs1 = Math.abs(o1);
                    int abs2 = Math.abs(o2);
                    if(abs1 == abs2){
                        return (o1 > o2) ?  1 : -1;
                    }
                    return abs1 - abs2;
                }
        );
        for(int i = 0; i < N; i++){
            int inputValue = Integer.parseInt(br.readLine());
            if(inputValue == 0){
                if(pq.isEmpty()) {
                    bw.write("0\n");
                    continue;
                }
                bw.write(pq.poll() + "\n");
            }
            else pq.add(inputValue);
        }
        bw.flush();
    }
}