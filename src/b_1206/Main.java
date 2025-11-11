package b_1206;

public class Main {
    public static void main(String[] args) {
        System.out.println(gcd(0.5, 0.3));
    }
    public static double gcd(double one, double two){
        return (two == 0) ? one : gcd(two, one % two);
    }
    public static double lcm(double one, double two){
        return one * two / gcd(one, two);
    }
}
