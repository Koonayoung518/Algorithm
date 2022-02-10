import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class B16916 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String s,p;
    static int[] pi;
    public static void Pi(){
        int j=0;
        for(int i=1; i<p.length();i++){
            while(j>0&&p.charAt(j)!=p.charAt(i)){
                j = pi[j-1];
            }
            if(p.charAt(j)==p.charAt(i))//같으면
                pi[i] = ++j;
        }
    }
    public static void kmp() throws IOException{
        int result=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            while(j>0 && s.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }
            if(s.charAt(i) == p.charAt(j)){//패턴끝까지 맞으면
                if(j== p.length()-1){
                    result =1;
                    break;
                }
                else{
                    ++j;
                }
            }
        }
        bw.write(String.valueOf(result));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        s = br.readLine();
        p = br.readLine();
        pi = new int[p.length()];
        Pi();
        kmp();
        bw.flush();
        bw.close();
        br.close();

    }
}
