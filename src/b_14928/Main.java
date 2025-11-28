package b_14928;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next());
        System.out.println(n.mod(BigInteger.valueOf(20000303)));
    }
}
