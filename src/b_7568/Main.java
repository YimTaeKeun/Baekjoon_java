package b_7568;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int humanCnt = Integer.parseInt(br.readLine());
        Integer[][] people = new Integer[humanCnt][2];
        String[] temp;
        for(int i = 0; i < humanCnt; i++){
            temp = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(temp[0]);
            people[i][1] = Integer.parseInt(temp[1]);
        }
        for(int i = 0; i < humanCnt; i++){
            int ranking = 1;
            for(int j = 0; j < humanCnt; j++){
                if(i != j){
                    if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) ranking++;
                }
            }
            bw.write(ranking + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
