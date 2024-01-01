package b_1027;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] buildings = new double[scanner.nextInt()];
        for(int t = 0; t < buildings.length; t++) buildings[t] = scanner.nextDouble();
        int result = 0;
        for(int i = 0; i < buildings.length; i++){
            int cnt = checkCnt(buildings, i);
            if(result < cnt) result = cnt;
        }
        System.out.println(result);
        scanner.close();
    }
    public static int checkCnt(double[] buildings, int pos){
        double inclination = 0, y_intercept = 0;
        int movePos = pos, cnt = 0;
        while(movePos-- > 0){
            inclination = (buildings[pos] - buildings[movePos]) / (pos - movePos);
            //움직이는 빌딩 기준
            y_intercept = buildings[movePos];
            if(isCan(buildings, movePos, pos, inclination, y_intercept)) cnt++;
        }
        movePos = pos;
        while(movePos++ < buildings.length - 1){
            inclination = (buildings[pos] - buildings[movePos]) / (pos - movePos);
            //고정된 빌딩 기준
            y_intercept = buildings[pos];
            if(isCan(buildings, pos, movePos, inclination, y_intercept)) cnt++;
        }
        return cnt;

    }
    public static boolean isCan(double[] buildings, int fromIndex, int toIndex, double inclination, double y_intercept){
        for(int i = 1; i < toIndex - fromIndex; i++){
            if(inclination * i + y_intercept <=buildings[fromIndex + i]) return false;
        }
        return true;
    }
}
