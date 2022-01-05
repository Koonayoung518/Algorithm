package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2747 {
    static long[] dp = new long[46];
    public static long fibo(int n){
        //저장된 값이 있을 경우
        if(dp[n] !=0) return dp[n];
        //없으면 재귀로 dp에 값 저장
        else {
            dp[n] = fibo(n-1) + fibo(n-2);
            return dp[n];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // long 배열 초기값이 null이 아니라 0이라서 dp[0]=0을 하면 안됨
        dp[1] =dp[2]=1;
        System.out.println(fibo(n));
    }
}