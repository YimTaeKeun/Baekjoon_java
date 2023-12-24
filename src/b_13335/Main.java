package b_13335;

import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> trucks = new LinkedList<>();
        List<Integer[]> trucksPos = new ArrayList<>(1001);
        int time = 0;
        final int n = scanner.nextInt(), w = scanner.nextInt(), L = scanner.nextInt();
        for(int i = 0; i < n; i++) trucks.add(scanner.nextInt());
        int currentWeight = 0;
        for(int i = 0; i < n; i++){
            time++;
            int k = trucksPos.size();
            for(int j = 0; j < k; j++) trucksPos.set(j, new Integer[] {trucksPos.get(j)[0] + 1, trucksPos.get(j)[1]});
            if(trucksPos.size() > 0 && trucksPos.get(0)[0] > w) {
                currentWeight -= trucksPos.get(0)[1];
                trucksPos.remove(0);
            }
            if(currentWeight + trucks.peek() <= L && trucksPos.size() < w){
                int temp = trucks.poll();
                currentWeight += temp;
                trucksPos.add(new Integer[] {1, temp});
            }
            else i--;
        }
        if(trucksPos.size() > 0) time += w - trucksPos.get(trucksPos.size() - 1)[0] + 1;
        System.out.println(time);
        scanner.close();
    }
}
