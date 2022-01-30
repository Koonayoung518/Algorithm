import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class B7562 {
    static  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[][] arr;
    static int i, n;
    static int startX, startY, endX, endY;
    static int[] dx = {-2,-1,2,1,2,1,-2,-1};
    static int[] dy = {1,2,1,2,-1,-2,-1,-2};
    static void bfs(int x, int y) throws IOException{
        if(x == endX && y==endY) return;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y}); //시작점
        visited[x][y] = true;

        while(!queue.isEmpty()){ //큐에 아무것도 없을 때까지
            int[] now = queue.poll(); //큐에서 꺼내기
            int nowX = now[0];
            int nowY = now[1];

            for(int j=0; j<dx.length; j++){
                int nextX = nowX + dx[j];
                int nextY = nowY + dy[j];
                if(nextX>=0&&nextX<n&&nextY>=0&&nextY<n&&!visited[nextX][nextY]){
                    queue.add(new int[] {nextX,nextY});
                    visited[nextX][nextY] =true;
                    arr[nextX][nextY] = arr[nowX][nowY] +1;
                }
            }
           
        }
    }
        public static void main(String[] args)  throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine());
          i = Integer.parseInt(st.nextToken());
         for(int j=0; j<i; j++){
            n =  Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs(startX, startY);
            bw.write(String.valueOf(String.valueOf(arr[endX][endY])+"\n"));
         }
          bw.flush();
          bw.close();
        }
        
}