package b_20492;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int reward = scanner.nextInt();
        System.out.println(getOne(reward) + " " + getTwo(reward));

    }
    public static int getOne(double reward){
        return (int) (reward * 0.78);
    }

    public static int getTwo(int reward){
        double namuge = reward * 0.2;
        return  (int) ((reward * 0.8) + getOne(namuge));
    }
}
