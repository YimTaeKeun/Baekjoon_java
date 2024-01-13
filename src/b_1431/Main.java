package b_1431;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> cal = new ArrayList<>();
        for(int i = Integer.parseInt(br.readLine()); i > 0; i--) cal.add(br.readLine());
        Collections.sort(cal, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2){
                if(str1.length() != str2.length()) return str1.length() - str2.length();
                else{
                    long str1Sum = 0, str2Sum = 0;
                    for(int i = 0; i < str1.length(); i++) if(str1.charAt(i) >= 48 && str1.charAt(i) <= 57) str1Sum += Integer.parseInt(str1.substring(i, i + 1));
                    for(int i = 0; i < str2.length(); i++) if(str2.charAt(i) >= 48 && str2.charAt(i) <= 57) str2Sum += Integer.parseInt(str2.substring(i, i + 1));
                    if(str1Sum != str2Sum) return (int) (str1Sum - str2Sum);
                    else{
                        List<String> temp = new ArrayList<>();
                        temp.add(str1);
                        temp.add(str2);
                        temp.sort(null);
                        if(str1.equals(temp.get(0))) return -1;
                        else if(str2.equals(temp.get(0))) return 1;
                        return 0;
                    }
                }
            }
        });
        for(String each: cal) System.out.println(each);
    }
}
