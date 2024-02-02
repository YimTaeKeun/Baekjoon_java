package b_7569;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;
        int goalTomatoCnt = 0;
        Queue<Integer[]> calQueue = new LinkedList<>();
        temp = br.readLine().split(" ");
        int row = Integer.parseInt(temp[0]), col = Integer.parseInt(temp[1]), floorCnt = Integer.parseInt(temp[2]);
        int[][][] boxData = new int[floorCnt][col][row];
        for(int f = 0; f < floorCnt; f++){
            for(int c = 0; c < col; c++){
                temp = br.readLine().split(" ");
                for(int r = 0; r < row; r++){
                    int data = Integer.parseInt(temp[r]);
                    if(data == 0) goalTomatoCnt++;
                    else if(data == 1) calQueue.add(new Integer[] {f, c, r});
                    boxData[f][c][r] = data;
                }
            }
        }
        int prev = 0, result = 0;
        while(prev != goalTomatoCnt || goalTomatoCnt != 0){
            prev = goalTomatoCnt;
            int size = calQueue.size();
            for(int i = 0; i < size; i++){
                Integer[] target = calQueue.poll();
                for(int f = target[0] - 1; f <= target[0] + 1; f++){
                    if(f >= 0 && f < floorCnt && boxData[f][target[1]][target[2]] == 0){
                        boxData[f][target[1]][target[2]] = 1;
                        goalTomatoCnt--;
                        calQueue.add(new Integer[] {f, target[1], target[2]});
                    }
                }
                for(int c = target[1] - 1; c <= target[1] + 1; c++){
                    if(c >= 0 && c < col && boxData[target[0]][c][target[2]] == 0){
                        boxData[target[0]][c][target[2]] = 1;
                        goalTomatoCnt--;
                        calQueue.add(new Integer[] {target[0], c, target[2]});
                    }
                }
                for(int r = target[2] - 1; r <= target[2] + 1; r++){
                    if(r >= 0 && r < row && boxData[target[0]][target[1]][r] == 0){
                        boxData[target[0]][target[1]][r] = 1;
                        goalTomatoCnt--;
                        calQueue.add(new Integer[] {target[0], target[1], r});
                    }
                }
            }
            if(prev == goalTomatoCnt) break;
            result++;
        }
        System.out.println((goalTomatoCnt == 0) ? result : -1);
    }
}
