import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1788 {
    static long[] dp;
    static long fibo(int n){
            if(dp[n] !=0) return dp[n];
            if(n == 1 || n== 2) return 1;
            if(n==0) return 0;
            return dp[n] = (fibo(n-1) % 1000000000 + fibo(n-2) % 1000000000) % 1000000000;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[Math.abs(n)+1];
        //n이 음수이면서 짝수이면 양수에 -를 붙인 값과 같음
        if(n<0 && n%2==0) System.out.println(-1);
        else if(n == 0) System.out.println(0);
        //n이 음수 이면서 홀수면 양수일 때와 값이 같음
        else System.out.println(1);
        long result =fibo(Math.abs(n));
        System.out.print(result);
    }
    
}
