import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class B1786 {
    static String text,p;
    static int[] pi;
    static ArrayList<Integer> result = new ArrayList<>();;       
    static int cnt = 0;
    public static void makepi(){
        int j=0;
        for(int i=1; i<p.length();i++){
            while(j>0 && p.charAt(i) != p.charAt(j)){//  같지 않으면
                 j = pi[j-1];
            }
            if(p.charAt(i) == p.charAt(j)){
                pi[i] = ++j;
            }
        }
    }
    public static void kmp(){
        int j=0;
        for(int i=0; i<text.length();i++){
            while(j>0 && p.charAt(j) != text.charAt(i)){
                j = pi[j-1];
            }
            if(p.charAt(j) == text.charAt(i)){
                if(j == pi.length-1){
                    cnt++;
                    result.add(i+1-p.length()+1);
                    j=pi[j];
                }
                else
                    j++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        text = br.readLine();
        p = br.readLine();
        pi = new int[p.length()];
        makepi();
        kmp();
        bw.write(cnt+"\n");
        for(int i=0; i<result.size(); i++)
            bw.write(result.get(i)+" ");
        bw.flush();
        bw.close();
        br.close();

    }
}

