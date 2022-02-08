import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B5052 {
    static int n;
    static String[] number;
    public static boolean check(){
        for(int i=0; i<n-1; i++){
            if(number[i+1].startsWith(number[i]))
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            number = new String[n];
            for(int j=0; j<n; j++){
                number[j] = br.readLine();
            }
            Arrays.sort(number);
            if(check())
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

