package b_1411;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cal = new String[Integer.parseInt(br.readLine())];
        for(int i = 0; i < cal.length; i++) cal[i] = br.readLine();
        int result = 0;
        for(int i = 0; i < cal.length - 1; i++){
            for(int j = i + 1; j < cal.length; j++) if(isSimillar(cal[i], cal[j])) result++;
        }
        System.out.println(result);
    }
    public static boolean isSimillar(String target1, String target2){
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < target1.length(); i++){
            if(map.get(target1.charAt(i)) == null){
                for(var each: map.values()) if(each == target2.charAt(i)) return false;
                map.put(target1.charAt(i), target2.charAt(i));
            }
            else if(map.get(target1.charAt(i)) != target2.charAt(i)) return false;
        }
        return true;
    }
}
