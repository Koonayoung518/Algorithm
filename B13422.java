import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B13422 {
    static int n,m,k;
    static int[] home;
    static int sum;
    public static int money(){
        int start =0; //start랑 end 간격이 훔칠 집 개수만큼
        int end =m;
        int count =0;
        if(n==m){ //집 전체에 도둑이 들 때
            if(sum <k) return 1;
            else return 0;
        }
        while(start < n){
            if(sum < k)
                count++;
            sum -= home[start++];
            sum += home[end++%n]; //원형이므로
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i< t; i++){
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]); //집 개수
            m = Integer.parseInt(s[1]); //훔칠 연속된 집의 개수
            k = Integer.parseInt(s[2]); //기준 돈
            home = new int[n];
            sum =0;
            String[] h = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                home[j] = Integer.parseInt(h[j]);
                if(j<m)
                sum+=home[j];
            }
            bw.write(String.valueOf(money())+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

