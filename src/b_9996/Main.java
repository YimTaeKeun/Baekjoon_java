package b_9996;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int checkCnt = Integer.parseInt(br.readLine());
        String[] patternString = br.readLine().split("\\*");
        for(int i = 0; i < checkCnt; i++){
            String target = br.readLine();
            boolean left = false, right = false;
            if(patternString[0].equals("")) left = true;
            else if(target.length() >= patternString[0].length() && target.substring(0, patternString[0].length()).equals(patternString[0])){
                left = true;
                target = target.substring(patternString[0].length());
            }
            if(patternString[1].equals("") || (target.length() >= patternString[1].length() && target.substring(target.length() - patternString[1].length()).equals(patternString[1]))) right = true;
            if(left && right) System.out.println("DA");
            else System.out.println("NE");
        }
        
    }
}
