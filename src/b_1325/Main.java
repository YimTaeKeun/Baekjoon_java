package b_1325;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;
        StringBuilder sb = new StringBuilder();
        temp = br.readLine().split(" ");
        int nodeCnt = Integer.parseInt(temp[0]);
        int commandCnt = Integer.parseInt(temp[1]);
        boolean[] isThereParents = new boolean[nodeCnt + 1];
        Map<Integer, List<Integer>> node = new HashMap<>();
        for(int i = 1; i <= nodeCnt; i++) node.put(i, new ArrayList<>());
        for(int i = 0; i < commandCnt; i++){
            temp = br.readLine().split(" ");
            int childNodeNum = Integer.parseInt(temp[0]);
            int parentNodeNum = Integer.parseInt(temp[1]);
            isThereParents[childNodeNum] = true;
            node.get(parentNodeNum).add(childNodeNum);
        }
        int max = 0;
        List<Integer> resultList = new ArrayList<>();
        for(int i = 1; i <= nodeCnt; i++){
            if(!isThereParents[i]){
                boolean[] visit = new boolean[nodeCnt + 1];
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                int cnt = 0;
                while(!queue.isEmpty()){
                    int target = queue.poll();
                    if(visit[target]) continue;
                    cnt++;
                    visit[target] = true;
                    for(Integer each: node.get(target)){
                        queue.add(each);
                    }
                }
                if(max < cnt){
                    resultList.clear();
                    max = cnt;
                    resultList.add(i);
                } else if(max == cnt) resultList.add(i);
                // max = Math.max(max, cnt);
            }
        }
        resultList.sort(null);
        for(Integer each: resultList) sb.append(each + " ");
        System.out.println(sb);
    }
}
