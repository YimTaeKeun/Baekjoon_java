package b_11659;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int dn = sc.nextInt(), qn = sc.nextInt();
        long[] sumArr = new long[dn];
        sumArr[0] = sc.nextLong();
        for(int i = 1; i < dn; i++) {
            sumArr[i] = sumArr[i - 1] + sc.nextLong();
        }
        for(int i = 0; i < qn; i++) {
            int sIdx = sc.nextInt() - 1, eIdx = sc.nextInt() - 1;
            if(sIdx == 0) {
                bw.write(sumArr[eIdx] + "\n");
                continue;
            }
            bw.write((sumArr[eIdx] - sumArr[sIdx - 1]) + "\n");
        }
        bw.flush();
    }
}
