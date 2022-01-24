import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class B2606 {
    static int[] com;
    static int[][] network;
    static int count = 0;
    static void virus(int[][] net,int m, int x){
        if(com[x]== 0 || x == 0){// 방문 안했으면
            com[x] = 1;
            for(int i=0; i<m; i++){
                if(net[x][i] == 1){ // 연결된 컴퓨터가 있을 경우
                    if(com[i]== 0){// 방문 안했으면
                        count++;
                        virus(net, m, i);
                    }

                }            
            }
        }

    }
        public static void main(String[] args)  throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          StringTokenizer st;
          int m = Integer.parseInt(br.readLine());
          int n = Integer.parseInt(br.readLine());
          com = new int[m];
          network = new int[m][m];
          for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            network[x][y] =1;
            network[y][x] =1;
          } //입력 끝
          com[0] = 1;
            virus(network, m, 0);
          bw.write(String.valueOf(count));
          bw.flush();
          bw.close();
        }
        
}