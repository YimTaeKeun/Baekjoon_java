package b_14428;

import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int k;
    public static Node[] segmentArr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        initSegmentArr();
        int qCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < qCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 1) changeNode(a, b);
            else if(cmd == 2){
                bw.write(getMinIdx(a, b) + "\n");
            }
        }
        bw.flush();
    }

    public static void setK(){
        int temp = 1;
        while(Math.pow(2, temp) < n) temp++;
        k = temp;
    }

    public static void initSegmentArr() throws IOException {
        setK();
        int s = (int) Math.pow(2, k);
        segmentArr = new Node[s * 2];
        for(int i = 0; i < segmentArr.length; i++) segmentArr[i] = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = s; i < s + n; i++){
            segmentArr[i] = new Node(Integer.parseInt(st.nextToken()), i - s + 1);
        }
        for(int i = s + n - 1; i > 1; i--){
            if(segmentArr[i / 2].compareTo(segmentArr[i]) > 0){
                segmentArr[i / 2] = new Node(segmentArr[i].value, segmentArr[i].idx);
            }
        }
    }
    public static int changeToSegIdx(int queryIdx){
        return queryIdx + (int) Math.pow(2, k) - 1;
    }

    public static void changeNode(int queryIdx, int value){
        queryIdx = changeToSegIdx(queryIdx);
        segmentArr[queryIdx].value = value;
        for(int i = queryIdx; i > 1; i /= 2){
            Node now = segmentArr[i];
            Node compareNode = (i % 2 == 1) ? segmentArr[i - 1] : segmentArr[i + 1];
            if(compareNode.value == Integer.MAX_VALUE) {
                segmentArr[i / 2].value = value;
                continue;
            }
            if(compareNode.compareTo(now) > 0){ // 지금 것이 더 작다면
                segmentArr[i / 2] = new Node(now.value, now.idx);
            }
            else if(now.compareTo(compareNode) > 0) {
                segmentArr[i / 2] = new Node(compareNode.value, compareNode.idx);
            }
        }
    }

    public static int getMinIdx(int sIdx, int eIdx){
        sIdx = changeToSegIdx(sIdx);
        eIdx = changeToSegIdx(eIdx);
        Node result = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        while(sIdx <= eIdx){
            if(sIdx % 2 == 1){
                if(result.compareTo(segmentArr[sIdx]) > 0) result = new Node(segmentArr[sIdx].value, segmentArr[sIdx].idx);
            }
            if(eIdx % 2 == 0){
                if(result.compareTo(segmentArr[eIdx]) > 0) result = new Node(segmentArr[eIdx].value, segmentArr[eIdx].idx);
            }
            sIdx = (sIdx + 1) / 2;
            eIdx = (eIdx - 1) / 2;
        }
        return result.idx;
    }
}


class Node implements Comparable<Node> {
    int value;
    int idx;

    public Node(int value, int idx){
        this.value = value;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node o) {
        if(this.value == o.value) return this.idx - o.idx;
        return this.value - o.value;
    }
}
