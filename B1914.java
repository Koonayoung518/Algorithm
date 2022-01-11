import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
public class B1914 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void hanoi(int n,int a, int b,int c) throws IOException{
        if(n ==1){
           bw.write(a + " "+ c+"\n");
           return;
        }
        hanoi(n-1,a, c, b); //1->2
        bw.write(a + " "+ c+"\n");
        hanoi(n-1,b,a,c); //2->3
    }
    public static void main(String[] args)  throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      BigInteger nnum = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
        System.out.println(nnum);
        if(n<=20){
            hanoi(n, 1, 2, 3);
        }

        bw.flush();
        bw.close();
    }

}