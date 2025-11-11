package b_10986;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int dn = sc.nextInt(), m = sc.nextInt();
        long[] sumArr = new long[dn + 1], modArr = new long[m];
        modArr[0] = 1;
        for(int i = 1; i <= dn; i++){
            sumArr[i] = sumArr[i - 1] + sc.nextLong();
            modArr[(int) (sumArr[i] % m)]++;
        }
        long ans = 0;
        for(int i = 0; i < m; i++) ans += sumOneToN(modArr[i] - 1);
        bw.write(ans+"\n");
        bw.flush();
    }
    public static long sumOneToN(long n){
        return n * (n + 1) / 2;
    }
}
