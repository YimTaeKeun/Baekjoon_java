package b_1699;
import java.util.*;
public class Main{
    public static int result = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cal = scanner.nextInt();
        boolean flag = false;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= (int) Math.sqrt(cal); i++) {
            if(i * i == cal) {
                flag = true;
                break;
            }
            set.add(cal - (i * i));
        }
        if(!flag) calculate(set);
        System.out.println(result);
        scanner.close();
    }
    public static void calculate(Set<Integer> set){
        boolean flag = false;
        List<Integer> tempList = new ArrayList<>();
        result++;
        loop: for(Integer each: set){
            for(int i = 1; i <= (int) Math.sqrt(each); i++){
                if(i * i == each){
                    flag = true;
                    break loop;
                }
                else tempList.add(each - (i * i));
            }
        }
        if(!flag){
            for(Integer each: tempList) set.add(each);
            calculate(set);
        }
    }
}