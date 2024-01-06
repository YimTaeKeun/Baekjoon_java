package b_24468;

import java.io.*;
import java.util.*;
public class Main {
    static long result = 0, length = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        Integer[][] balls = new Integer[Integer.parseInt(temp[1])][2];
        final int TARGET_TIME = Integer.parseInt(temp[2]);
        length = Integer.parseInt(temp[0]);
        for(int i = 0; i < balls.length; i++){
            temp = br.readLine().split(" ");
            balls[i][0] = Integer.parseInt(temp[0]);
            balls[i][1] = (temp[1].charAt(0) == 'R') ? 1 : 0;
        }
        isCrash(balls);
        for(int t = 0; t < TARGET_TIME; t++){
            // for(Integer[] each: balls) System.out.print(Arrays.toString(each) + ", ");
            // System.out.println();
            // System.out.println();
            // 각 공 위치 변환
            // 겹침 판단 함수
            move(balls);
            isCrash(balls);
        }
        System.out.println(result / 2);
        // 각 공: {위치, isRight}, True: 1, False: 0
        // 필요함수: 각 공 위치 증가 함수, 각 공이 같은 위치에 서 있으면 서로 방향 바꿔주면서 변수 증가 시켜주는 함수
    }
    public static void move(Integer[][] balls){
        for(Integer[] ball: balls){
            if(ball[1] == 1) ball[0]++;
            else ball[0]--;
        }
    }
    public static void isCrash(Integer[][] balls){
        // 양끝점 고려
        for(int i = 0; i < balls.length; i++) if(balls[i][0] == 0 || balls[i][0] == length) turnBoolean(balls, i);
        for(int i = 0; i < balls.length; i++){
            for(int j = 0; j < balls.length; j++){
                if(i != j && balls[i][0] == balls[j][0]){
                    result++;
                    turnBoolean(balls, i);
                }
            }
        }
    }
    public static void turnBoolean(Integer[][] balls, int pos){
        balls[pos][1] = (balls[pos][1] == 1) ? 0 : 1;
    }
}
