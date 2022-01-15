import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class B1654 {
        public static void main(String[] args)  throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            long max =0;
            long min =0;
            long mid = 0;
            for(int i=0; i<k; i++){
                arr[i] = Integer.parseInt(br.readLine());
                if(max < arr[i])
                    max = arr[i];
            }
            max++;
            while(min<max){
                mid =  (max +min)/2;

                int count =0;
                for(int i=0; i<k; i++){
                    count += arr[i]/mid;
                }
                if(count < n)
                    max = mid;
                else{
                    min = mid + 1;
                }
            }
            long result = min -1;
            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            }
}