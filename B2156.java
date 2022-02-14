import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        int[] dp = new int[n];
    
        for(int i=0;i<n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = wine[0];

        for(int i=1; i< n; i++){
            if(i==1){
                dp[1] = wine[0] + wine[1];
                continue;
            }
            if(i==2){
                dp[2] = Math.max(dp[1], Math.max(wine[0]+wine[2], wine[1]+wine[2]));
                continue;
            }
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wine[i],dp[i-3]+wine[i-1]+wine[i]));
        }
        bw.write(String.valueOf(dp[n-1]));
        bw.flush();
        bw.close();
        br.close();
    }


}
