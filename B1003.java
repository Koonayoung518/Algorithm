package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] count = new int[41][2];
        //테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());
        int[] n_list = new int[t];
        count[0][0] =1;
        count[0][1] =0;
        count[1][0] =0;
        count[1][1] =1;
        //n 입력 받기
        for(int i=0; i<t; i++){
            n_list[i] =Integer.parseInt(br.readLine());
        }
       for(int i=0; i<t; i++){
           if(n_list[i]>=2){
               for(int j=2; j<=n_list[i]; j++){
                count[j][0] = count[j-2][0] + count[j-1][0];
                count[j][1] = count[j-2][1] + count[j-1][1];
               }
           }
           bw.write(count[n_list[i]][0]+" "+count[n_list[i]][1]+"\n");
               }
        bw.flush();
        bw.close();
    }
}
