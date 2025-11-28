package b_7662;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            Map<Integer, Integer> map = new HashMap<>(); // 숫자의 갯수를 의미합니다.
            PriorityQueue<Integer> minimumPq = new PriorityQueue<>(); // 오름차순 정렬
            PriorityQueue<Integer> maximumPq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬
            int qCnt = Integer.parseInt(br.readLine()); // 명령어 수
            String[] temp;
            int count = 0;
            for(int i = 0; i < qCnt; i++) {
                temp = br.readLine().split(" ");
                String command = temp[0];
                int value = Integer.parseInt(temp[1]);
                if(command.equals("I")) {
                    if(map.containsKey(value)) map.put(value, map.get(value) + 1);
                    else map.put(value, 1);
                    minimumPq.offer(value);
                    maximumPq.offer(value);
                    count++;
                }
                else if(command.equals("D")) {
                    if(count == 0) continue;
                    int v = 0;
                    if(value < 0){
                        do{
                            v = minimumPq.poll();
                        }while(map.get(v) == 0);
                    }
                    else{
                        do{
                            v = maximumPq.poll();
                        }while(map.get(v) == 0);
                    }
                    map.put(v, map.get(v) - 1);
                    count--;
                }
            }
            if(count == 0) bw.write("EMPTY\n");
            else{
                int min = 0, max = 0;
                do{
                    min = minimumPq.poll();
                }while(map.get(min) == 0);
                do{
                    max = maximumPq.poll();
                }while(map.get(max) == 0);
                bw.write(max + " " + min + "\n");
            }
        }
        bw.flush();
    }
}
