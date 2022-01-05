package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {
    static int  z(int n, int r, int c){
        if(n <= 1){
            return r* 2 +c;
        }
        else{
            return (r/n)*2*n*n + (c/n)*n*n + z(n/2,r%n, c%n);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int num = (int) Math.pow(2, n-1);
       System.out.print(z(num,r,c));
}
}
