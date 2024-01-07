package b_2579;

import java.io.*;
import java.util.*;
public class Main {
    static Integer[] stairs;
    static boolean finish = false;
    static int lastOne = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stairs = new Integer[Integer.parseInt(br.readLine()) + 1];
        for(int i = 1; i < stairs.length; i++) stairs[i] = Integer.parseInt(br.readLine());
        if(stairs.length == 1) System.out.println(stairs[0]);
        else{
            Integer[][] dpArrayAlongStairs = new Integer[stairs.length][];
            dpArrayAlongStairs[1] = new Integer[] {stairs[1], 1};
            dpArrayAlongStairs[2] = new Integer[] {stairs[2], 1};
            System.out.println(Arrays.deepToString(dpArrayAlongStairs));
            while(!finish) {
                dpArrayAlongStairs = dpAdd(dpArrayAlongStairs);
                System.out.println(Arrays.deepToString(dpArrayAlongStairs));
            }
            System.out.println(Math.max(dpArrayAlongStairs[dpArrayAlongStairs.length - 1][0], lastOne + stairs[stairs.length - 1]));
        }
    }
    public static Integer[][] dpAdd(Integer[][] dpArrayAlongStairs){
        Integer[][] returnDpArray = new Integer[dpArrayAlongStairs.length][];
        // for(int i = 1; i < dpArrayAlongStairs.length - 1; i++) if(dpArrayAlongStairs[i] != null) returnDpArray[i] = new Integer[] {dpArrayAlongStairs[i][0], dpArrayAlongStairs[i][1]};
        if(dpArrayAlongStairs[dpArrayAlongStairs.length - 1] != null) returnDpArray[returnDpArray.length - 1] = new Integer[] {dpArrayAlongStairs[returnDpArray.length - 1][0], dpArrayAlongStairs[returnDpArray.length - 1][1]};
        for(int i = 1; i < dpArrayAlongStairs.length - 1; i++){
            if(dpArrayAlongStairs[i] != null){
                if(dpArrayAlongStairs[i][1] == 1) returnDpArray[i + 1] = checkMaxObject(returnDpArray, i + 1, new Integer[] {dpArrayAlongStairs[i][0] + stairs[i + 1], 2});
                if(i != dpArrayAlongStairs.length - 2) {
                    returnDpArray[i + 2] = checkMaxObject(returnDpArray, i + 2, new Integer[] {dpArrayAlongStairs[i][0] + stairs[i + 2], 1});
                }
            }
        }
        finish = checkFinish(returnDpArray);
        return returnDpArray;
    }
    public static Integer[] checkMaxObject(Integer[][] arr, int pos, Integer[] targetObject){
        if(arr[pos] == null) return targetObject;
        else {
            if(pos == arr.length - 2 && targetObject[0] > arr[pos][0]) lastOne = arr[pos][0];
            return (targetObject[0] > arr[pos][0]) ? targetObject : arr[pos];
        }
    }
    public static boolean checkFinish(Integer[][] returnDpArray){
        int size = returnDpArray.length;
        for(int i = 0; i < size - 2; i++) if(returnDpArray[i] != null) return false;
        if(returnDpArray[size - 1] == null || (returnDpArray[size - 2] != null && returnDpArray[size - 2][1] == 1)) return false;
        return true;
    }
}
