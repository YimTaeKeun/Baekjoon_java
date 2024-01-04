package b_1195;

import java.io.*;
import java.util.*;
public class Main {
    static int totalSize;
    static boolean middleCan = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String one = br.readLine();
        String two = br.readLine();
        totalSize = one.length() + two.length();
        System.out.println((one.length() > two.length()) ? returnSize(one, two) : returnSize(two, one));
    }
    public static int returnSize(String longString, String shortString){
        // 2와 1이 맞물려도 됨. 1과 1이 맞물려도 됨. 2와 2가 맞물리는 일만 피하면 됨.
        // 짧은 쪽의 끝 부터 시작함
        List<Integer> minSizes = new ArrayList<>();
        checkMiddle(longString, shortString, minSizes);
        if(!middleCan){
            checkLeft(longString, shortString, minSizes);
            checkRight(longString, shortString, minSizes);
        }
        return (minSizes.size() > 0) ? Collections.min(minSizes) : totalSize;
    }
    public static void checkLeft(String longString, String shortString, List<Integer> minSizes){
        for(int i = 0; i < shortString.length(); i++){
            for(int checkPos = 0; checkPos <= i; checkPos++){
                if(!isFit(shortString.charAt((shortString.length() - 1) - i + checkPos), longString.charAt(checkPos))) break;
                if(checkPos == i) minSizes.add(totalSize - (checkPos + 1));
            }
        }
    }
    public static void checkMiddle(String longString, String shortString, List<Integer> minSizes){
        loop: for(int i = 0; i < longString.length() - shortString.length() + 1; i++){
            for(int checkPos = 0; checkPos < shortString.length(); checkPos++){
                if(!isFit(shortString.charAt(checkPos), longString.charAt(i + checkPos))) break;
                if(checkPos == shortString.length() - 1) {
                    minSizes.add(totalSize - shortString.length());
                    middleCan = true;
                    break loop;
                }
            }
        }
    }
    public static void checkRight(String longString, String shortString, List<Integer> minSizes){
        for(int i = 0; i < shortString.length(); i++){
            for(int checkPos = 0; checkPos <= i; checkPos++){
                if(!isFit(shortString.charAt(checkPos), longString.charAt((longString.length() - 1) - i + checkPos))) break;
                if(checkPos == i) minSizes.add(totalSize - (checkPos + 1));
            }
        }
    }
    public static boolean isFit(char a, char b){
        if(a == '2' && b == '2') return false;
        return true;
    }
}
