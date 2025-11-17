package b_3955;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        String[] temp;
        while(tc-- > 0) {
            temp = br.readLine().split(" ");
            long K = Long.parseLong(temp[0]), C = Long.parseLong(temp[1]);
            if(1 % gcd(K, C) != 0) {
                bw.write("IMPOSSIBLE\n");
                continue;
            }
            // 2. 특수 케이스
            if (C == 1) {
                long y = K + 1;
                if (y > 1_000_000_000L) bw.write("IMPOSSIBLE\n");
                else bw.write(y + "\n");
                continue;
            }
            if (K == 1) {
                long y = 1; // C > 1 인 경우
                if (C == 1) y = 2;
                bw.write(y + "\n");
                continue;
            }

            long[] res = extendedEuclidGcd(C, K);
            long y0 = res[0]; // 한 사람당 나눠주는 갯수
            long z0 = res[1]; // 봉지 갯수

            long t1 = Math.floorDiv(-y0, K) + 1;
            long t2 = Math.floorDiv(z0, C) + 1;
            long t  = Math.max(t1, t2);

            long y = y0 + K * t;

            if (y <= 0 || y > 1_000_000_000L) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(y + "\n");
            }
        }
        bw.flush();
    }
    public static long[] extendedEuclidGcd(long a, long b){
        // 확장 유클리드 호제법
        if(b == 0) return new long[] {1, 0};
        long[] arr = extendedEuclidGcd(b, a % b);
        long x = arr[1], y = arr[0] - arr[1] * (a / b);
        return new long[] {x, y};
    }
    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
