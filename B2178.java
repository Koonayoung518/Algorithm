import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class B2178 {
    static int count = 0;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {-1,1,0,0}; // 상하좌우 방향
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()){ //큐에 아무것도 없을 때까지
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++){
                int nextX = nowX +dx[i];
                int nextY = nowY +dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(visited[nextX][nextY] || arr[nextX][nextY]== 0) continue;
                queue.add(new int[] {nextX,nextY});
                arr[nextX][nextY] =arr[nowX][nowY] +1;
                visited[nextX][nextY] = true;

            }
        }
    }
        public static void main(String[] args)  throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          StringTokenizer st = new StringTokenizer(br.readLine());
          n = Integer.parseInt(st.nextToken());
          m = Integer.parseInt(st.nextToken());
          arr = new int[n][m];
          for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt((j))));
            }
          }
          visited = new boolean[n][m];
          visited[0][0] = true;
          bfs(0, 0);
          bw.write(String.valueOf(arr[n-1][m-1]));
          bw.flush();
          bw.close();
        }
        
}