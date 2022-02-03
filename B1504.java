import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int idx, weight;
    Node(int idx, int weight){
        this.idx=idx;
        this.weight=weight;
    }
    public int compareTo(Node n) {
        return this.weight-n.weight;
    }
}
public class Main {
        static int n,e;
        static int a,b,c;
        static int v1, v2;
        static ArrayList<Node>[] list;
        static boolean[] visited;
        static int[] dist;
        static int INF =200000000;
        public static int Dijkstra(int start, int end){
            dist = new int[n]; //가중치 저장 배열 초기화
            Arrays.fill(dist, INF); //간선수 * 가중치
            visited = new boolean[n]; // 방문 여부 초기화
            Arrays.fill(visited, false); 
            PriorityQueue<Node> queue = new PriorityQueue<>();
            dist[start] =0; //출발지 설정
            queue.add(new Node(start,0));

            while(!queue.isEmpty()){
            Node now = queue.poll();
            if(dist[now.idx]< now.weight) continue;
            if(!visited[now.idx]){
                visited[now.idx] = true;
                for(int i=0; i<list[now.idx].size(); i++){
                    Node next = list[now.idx].get(i);
                    if(dist[next.idx] > now.weight + next.weight){
                        dist[next.idx] = now.weight + next.weight;
                        queue.add(new Node(next.idx,dist[next.idx]));
                    }
                }
            }
            }
            return dist[end];
        }
        public static void main(String[] args)  throws IOException{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           int result1=0;
           int result2=0;
           String[] t= br.readLine().split(" ");
           n = Integer.parseInt(t[0]);
           e = Integer.parseInt(t[1]);
           list = new ArrayList[n];// 인접리스트 초기화
           for(int i=0; i<n; i++){
               list[i] = new ArrayList<>();
           }
           for(int i=0; i<e; i++){
            String[] tt = br.readLine().split(" ");
               a = Integer.parseInt(tt[0])-1;
               b = Integer.parseInt(tt[1])-1;
               c = Integer.parseInt(tt[2]);
               list[a].add(new Node(b,c)); //양방향이므로 두 번
               list[b].add(new Node(a,c));
           }
           String[] t3 = br.readLine().split(" ");
           v1 = Integer.parseInt(t3[0])-1;
           v2 = Integer.parseInt(t3[1])-1;
           // 1-> v1 -> v2 -> N
           result1 = Dijkstra(0, v1) + Dijkstra(v1, v2) + Dijkstra(v2, n-1);
           // 1-> v2 -> v1 -> N
           result2 = Dijkstra(0, v2) + Dijkstra(v2, v1) + Dijkstra(v1, n-1);
           if(result1 >= INF && result2>=INF)
                bw.write(String.valueOf(-1));
           else
                bw.write(String.valueOf((result1<result2)? result1: result2));
            bw.flush();
            bw.close();
            br.close();
        }
}