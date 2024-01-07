package b_2579;

import java.io.*;
public class Main {
    static int stairs[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stairs = new int[Integer.parseInt(br.readLine()) + 1];
        for(int i = 1; i < stairs.length; i++) stairs[i] = Integer.parseInt(br.readLine());
        int[][] dpArr = new int[stairs.length][];
        if(dpArr.length == 2) System.out.println(stairs[1]);
        else{
            dpArr[1] = new int[] {stairs[1], -1};
            dpArr[2] = new int[] {stairs[2], -1};
            while(!isFinish(dpArr)) dpArr = dp(dpArr);
            System.out.println(Math.max(dpArr[dpArr.length - 1][0], dpArr[dpArr.length - 1][1]));
        }
    }
    public static int[][] dp(int[][] arr){
        int[][] returnDp = new int[arr.length][];
        if(arr[arr.length - 1] != null) returnDp[returnDp.length - 1] = new int[] {arr[arr.length - 1][0], arr[arr.length - 1][1]};
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i] != null){
                if(arr[i][0] != -1){
                    if(returnDp[i + 1] == null) returnDp[i + 1] = new int[] {-1, arr[i][0] + stairs[i + 1]};
                    else returnDp[i + 1][1] = Math.max(returnDp[i + 1][1], arr[i][0] + stairs[i + 1]);
                    if(i != arr.length - 2){
                        if(returnDp[i + 2] == null) returnDp[i + 2] = new int[] {arr[i][0] + stairs[i + 2], -1};
                        else returnDp[i + 2][0] = Math.max(returnDp[i + 2][0], arr[i][0] + stairs[i + 2]);
                    }
                }
                if(arr[i][1] != -1 && i != arr.length - 2){
                    if(returnDp[i + 2] == null) returnDp[i + 2] = new int[] {arr[i][1] + stairs[i + 2], -1};
                    else returnDp[i + 2][0] = Math.max(returnDp[i + 2][0], arr[i][1] + stairs[i + 2]);
                }
            }
        }
        return returnDp;
    }
    public static boolean isFinish(int[][] arr){
        int size = arr.length;
        for(int i = 0; i < size - 2; i++) if(arr[i] != null) return false;
        if(arr[size - 1] == null || (arr[size - 2] != null && arr[size - 2][0] != -1)) return false;
        return true;
    }
}
