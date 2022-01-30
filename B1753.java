import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Node implements Comparable<Node>{
    int idx, w;
    Node(int idx, int w){
        this.idx=idx;
        this.w=w;
    }
    public int compareTo(Node n) {
        return this.w-n.w;
    }
}
public class B1753 {
    static ArrayList<Node>[] list;
    static int[] dist;
    static int first;
    static int INF = Integer.MAX_VALUE;

    private static void Dijkstra(){
        // 출발지 비용 0으로 하고, 출발지 큐에 넣기
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[first] =0;
        queue.add(new Node(first,0));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            //더 큰 가중치로 도착했을 경우 패스
            if(now.w > dist[now.idx]) continue;
            //현재 위치에 연결된 간선 탐색
            for(int i=0; i<list[now.idx].size(); i++){
                Node next = list[now.idx].get(i);
                //비용이 더 작을 때 갱신하고 큐에 넣기
                if(dist[next.idx] > now.w + next.w){
                    dist[next.idx] = now.w + next.w;
                    queue.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
        public static void main(String[] args)  throws IOException{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           StringTokenizer st = new StringTokenizer(br.readLine());
           int V  = Integer.parseInt(st.nextToken());
           int E  = Integer.parseInt(st.nextToken());
           first =  Integer.parseInt(br.readLine())-1;
           int u,v,w;
            dist = new int[V+1]; // 거리 배열 무한대로 초기화
            Arrays.fill(dist, INF);

            list = new ArrayList[V+1]; //인접리스트 초기화
            for(int i=0; i<V; i++){
                list[i] = new ArrayList<>();
            }
           for(int i=0; i<E; i++){
                String[] s = br.readLine().split(" ");
                u = Integer.parseInt(s[0])-1;
                v = Integer.parseInt(s[1])-1;
                w = Integer.parseInt(s[2]);
                list[u].add(new Node(v,w));
            }
            Dijkstra();
            for(int i=0; i< V; i++){
                if(dist[i] == INF){
                    bw.write("INF\n");
                }
                else
                    bw.write(String.valueOf(dist[i])+"\n");
            }
            bw.flush();
            bw.close();
            br.close();
        }
        
}