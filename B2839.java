import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2839 {
    static int cnt =0;
    public static int suger(int n){
       while(true){
        if(n%5==0){
            cnt+= n/5;
            return cnt;
        }else{
            n-=3;
            cnt++;
        }
        if(n<0){
            return -1;
        }
       }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(suger(n)));
        bw.flush();
        bw.close();
        br.close();
    }


}
