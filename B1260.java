import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class B1260 {
    static  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;
    static boolean[] visited;
    static int[][] arr;
    static int n,m, v;
    static void dfs(int x) throws IOException{
        visited[x] = true;
        bw.write(String.valueOf(x+1)+ " ");
        for(int i=0; i<n; i++){
            if(arr[x][i] ==1 && visited[i] ==false)
                dfs(i);
        }
    }
    static void bfs(int x) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x); //시작점
        visited[x] = true;
        bw.write(String.valueOf(x+1)+ " ");

        while(!queue.isEmpty()){ //큐에 아무것도 없을 때까지
            int now = queue.poll();

            for(int i=0; i<n; i++){
                if(arr[now][i]==1 && visited[i] ==false){
                    queue.add(i);
                    visited[i] = true;
                    bw.write(String.valueOf(i+1)+ " ");
                }
            }
        }
    }
        public static void main(String[] args)  throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
          StringTokenizer st = new StringTokenizer(br.readLine());
          n = Integer.parseInt(st.nextToken());
          m = Integer.parseInt(st.nextToken());
          v = Integer.parseInt(st.nextToken());
          arr = new int[n][n];
          visited = new boolean[n];
          for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            arr[x][y] = arr[y][x] =1;
          }
         dfs(v-1);
         visited = new boolean[n]; //방문 상태 초기화
         bw.write("\n");
         bfs(v-1);
          bw.flush();
          bw.close();
        }
        
}