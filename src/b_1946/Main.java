package b_1946;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t > 0; t--){
            int[][] cal = new int[Integer.parseInt(br.readLine())][2];
            int cnt = 0;
            for(int i = 0; i < cal.length; i++){
                String[] temp = br.readLine().split(" ");
                cal[i][0] = Integer.parseInt(temp[0]);
                cal[i][1] = Integer.parseInt(temp[1]);
            }
            for(int i = 0; i < cal.length; i++) if(isPick(cal, i)) cnt++;
            System.out.println(cnt);
        }
    }
    public static boolean isPick(int[][] cal, int pos){
        int[] thisInform = cal[pos];
        for(int i = 0; i < cal.length; i++){
            if(pos != i){
                if(cal[i][0] < thisInform[0] && cal[i][1] < thisInform[1]) return false;
            }
        }
        return true;
    }
}
