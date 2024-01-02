package b_1283;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new ArrayList<>();
        for(int t = Integer.parseInt(br.readLine()); t > 0; t--){
            String[] chunk = br.readLine().split(" ");
            int i = 0;
            boolean flag = false;
            for(; i < chunk.length; i++){
                if(!isContainHeader(list, chunk[i])) {
                    list.add(chunk[i].toLowerCase().charAt(0));
                    flag = true;
                    break;
                }
            }
            if(flag){
                for(int j = 0; j < chunk.length; j++){
                    if(i == j) System.out.print("[" + chunk[j].substring(0, 1) + "]" + chunk[j].substring(1) + " ");
                    else System.out.print(chunk[j] + " ");
                }
            }
            else{
                int k = 0, pos = -1;
                for(; k < chunk.length; k++){
                    pos = NotContainEachPos(list, chunk[k]);
                    if(pos != -1){
                        list.add(chunk[k].charAt(pos));
                        break;
                    }
                }
                if(pos == -1) for(String each: chunk) System.out.print(each + " ");
                else{
                    for(int l = 0; l < chunk.length; l++){
                        if(l == k){
                            for(int a = 0; a < chunk[l].length(); a++){
                                if(a == pos) System.out.print("[" + chunk[l].substring(a, a + 1) + "]");
                                else System.out.print(chunk[l].substring(a, a + 1));
                            }
                            System.out.print(" ");
                        }
                        else System.out.print(chunk[l] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static boolean isContainHeader(List<Character> list, String target){
        target = target.toLowerCase();
        if(list.contains(target.charAt(0))) return true;
        return false;
    }
    public static int NotContainEachPos(List<Character> list, String target){
        target = target.toLowerCase();
        for(int i = 1; i < target.length(); i++) if(!list.contains(target.charAt(i))) return i;
        return -1;
    }
}
