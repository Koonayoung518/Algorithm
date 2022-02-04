import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B2776 {
        public static void main(String[] args)  throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          StringTokenizer st;
          int t = Integer.parseInt(br.readLine()); //테스트 케이스 개수
          for(int i=0; i<t; i++){
              int n = Integer.parseInt(br.readLine()); //수첩1
              st = new StringTokenizer(br.readLine());
              HashMap<Integer, Boolean> hm = new HashMap<>();
              for(int j=0; j<n; j++){
                  hm.put(Integer.parseInt(st.nextToken()),true);
              }

              int m = Integer.parseInt(br.readLine()); //수첩2
              st = new StringTokenizer(br.readLine());
              for(int j=0; j<m; j++){
                if(hm.containsKey(Integer.parseInt(st.nextToken()))){
                    bw.write("1\n");
                }
                else{
                    bw.write("0\n");
                }
            }
          }
          bw.flush();
          bw.close();
        }
        
}