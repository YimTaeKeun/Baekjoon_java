package b_1672;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, String> key = new HashMap<>(){
            {
                put("AG", "C");
                put("AC", "A");
                put("AT", "G");
                put("GC", "T");
                put("GT", "A");
                put("CT", "G");
            }
        };
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String cal = scanner.nextLine();
        while(cal.length() > 1){
            String tempString = cal.substring(cal.length() - 2), resultString;
            if(tempString.charAt(0) == tempString.charAt(1)) resultString = tempString.substring(0, 1);
            else if(key.get(tempString) == null) resultString = key.get(tempString.substring(1) + tempString.substring(0, 1));
            else resultString = key.get(tempString);
            cal = cal.substring(0, cal.length() - 2) + resultString;
        }
        System.out.println(cal);
        scanner.close();
    }
}
