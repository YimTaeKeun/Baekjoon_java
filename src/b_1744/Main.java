package b_1744;

//import java.util.*;
//import java.io.*;
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//        List<Integer> plusList = new ArrayList<>(), minusAndZeroList = new ArrayList<>();
//        for(int i = 1; i <= N; i++){
//            int temp = Integer.parseInt(br.readLine());
//            if(temp > 0) plusList.add(temp);
//            else minusAndZeroList.add(temp);
//        }
//        // plusList는 내림차순, minus는 오름차순 정렬
//        plusList.sort(Collections.reverseOrder());
//        Collections.sort(minusAndZeroList);
//        int cursor = 0; // 각 리스트의 인덱스를 가리킵니다. 각 리스트 마다 cursor 초기화 필요
//        long result = 0;
//        while(cursor < plusList.size()){
//            if(cursor == plusList.size() - 1) {
//                result += plusList.get(cursor); // 마지막 하나 남은 원소 더함
//                break;
//            }
//            // cursor와 cursor + 1에 해당하는 원소 존재
//            long now = plusList.get(cursor);
//            long next = plusList.get(cursor + 1);
//            if(now + next < now * next){ // 곱이 더 크다면
//                result += now * next; // 묶음
//                cursor += 2; // 두 칸씩 띄어넘음
//            }
//            else{
//                result += now; // 묶지 않음
//                cursor++; // 묶지 않음
//            }
//        }
//        cursor = 0;
//        while (cursor < minusAndZeroList.size()){
//            if(cursor == minusAndZeroList.size() - 1){
//                result += minusAndZeroList.get(cursor); // 마지막 하나 남은거 걍 더함. 묶을 다음 수가 없기 때문
//                break;
//            }
//            long now = minusAndZeroList.get(cursor);
//            long next = minusAndZeroList.get(cursor + 1);
//            if(now + next < now * next){
//                result += now * next;
//                cursor += 2;
//            }
//            else{
//                result += now;
//                cursor++;
//            }
//        }
//        bw.write(result + "\n");
//        bw.flush();
//    }
//}

// 우선 순위 큐와 함수를 이용한 간결한 풀이
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder()), minusAndZeroQ = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            int t = Integer.parseInt(br.readLine());
            if(t > 0) plusQ.add(t);
            else minusAndZeroQ.add(t);
        }
        long result = 0;
        result += getMaxResult(plusQ);
        result += getMaxResult(minusAndZeroQ);
        bw.write(result+"\n");
        bw.flush();
    }
    public static long getMaxResult(PriorityQueue<Integer> pq){
        long result = 0;
        while(!pq.isEmpty()){
            long now = pq.poll();
            if(pq.isEmpty()) {
                result += now;
                break;
            }
            if(now + pq.peek() < now * pq.peek()) result += now * pq.poll();
            else result += now;
        }
        return result;
    }
}
