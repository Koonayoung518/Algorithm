import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2167 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        int[][] array = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            String[] tt = br.readLine().split(" ");
            int a =  Integer.parseInt(tt[0])-1;
            int b =  Integer.parseInt(tt[1])-1;
            int c =  Integer.parseInt(tt[2])-1;
            int d =  Integer.parseInt(tt[3])-1;
            int result=0;
            for(int x=a; x<=c; x++){
                for(int y=b; y<=d; y++){
                    result +=array[x][y];
                }
            }
            bw.write(String.valueOf(result)+"\n");
        } 
        bw.flush();
        bw.close();
        br.close();
    }
}

