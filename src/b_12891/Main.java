package b_12891;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int s = sc.nextInt();
        int p = sc.nextInt();
        String text = sc.next();
        int[] need = new int[4];
        int[] now = new int[4];
        for(int i = 0; i < 4; i++) need[i] = sc.nextInt();

        int sIdx = 0;
        int eIdx = p - 1;
        for(int i = sIdx; i <= eIdx; i++){
            now[convertCharToNumber(text.charAt(i))]++;
        }
        int count = 0;
        do{
            if(checkNeed(need, now)) count++;
            now[convertCharToNumber(text.charAt(sIdx))]--;
            if(eIdx != s - 1) now[convertCharToNumber(text.charAt(eIdx + 1))]++;
            sIdx++;
            eIdx++;
        }while(eIdx <= s - 1);
        System.out.println(count);
    }
    public static int convertCharToNumber(char ch) {
        if(ch == 'A') return 0;
        if(ch == 'C') return 1;
        if(ch == 'G') return 2;
        if(ch == 'T') return 3;
        return -1;
    }

    public static boolean checkNeed(int[] need, int[] now){
        for(int i = 0; i < 4; i++) if(need[i] > now[i]) return false;
        return true;
    }
}
