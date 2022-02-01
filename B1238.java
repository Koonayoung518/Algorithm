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
public class B1238 {
        static ArrayList<Node>[] list;
        static int[] dist;
        static int n,m,x;
        static int[] result;
        static boolean[] visited;
        public static void Dijkstra(){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            for(int i=0; i<n; i++){
                visited = new boolean[n];
                Arrays.fill(visited, false);
                dist = new int[n]; //가중치 저장 리스트 초기화
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[i] =0; // 출발지 설정
                queue.add(new Node(i,0)); // 출발지 큐에 넣기
                while(!queue.isEmpty()){
                    Node now = queue.poll();
                    if(now.weight>dist[now.idx]) continue; // 가중치 더 크면 패스
                    if(!visited[now.idx]){
                        visited[now.idx] = true;
                        for(int j=0; j<list[now.idx].size();j++){
                            Node next = list[now.idx].get(j);
                            if(dist[next.idx] > now.weight + next.weight){
                                dist[next.idx] = now.weight + next.weight;
                                queue.add(new Node(next.idx,dist[next.idx]));
                            }
                        }
                    }
                }
                if(i ==x){//파티하는 마을이 출발지 -> 다시 원래 마을로 돌아가는 길
                    for(int j=0; j<n;j++){
                        result[j] += dist[j];
                    }
                }
                else{//파티하러 가는길
                    result[i] += dist[x];
                }
            }
        }
        public static void main(String[] args)  throws IOException{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           String[] t= br.readLine().split(" ");
           n  = Integer.parseInt(t[0]); //정점
           m  = Integer.parseInt(t[1]); //간선
           x  = Integer.parseInt(t[2])-1; // 도착지
           result = new int[n];

           list = new ArrayList[n]; //인접리스트 초기화
           for(int i=0; i<n;i++){
               list[i] = new ArrayList<>();
           }
           for(int i=0; i<m; i++){ //입력
            String[] tt= br.readLine().split(" ");
            int start = Integer.parseInt(tt[0])-1;
            int end = Integer.parseInt(tt[1])-1;
            int weight = Integer.parseInt(tt[2]);
            list[start].add(new Node(end,weight));
           }
           Dijkstra();
           int max = result[0];
           for(int i=1; i<n; i++){
               if(max < result[i])
                    max = result[i];
           }
           bw.write(String.valueOf(max));
            bw.flush();
            bw.close();
            br.close();
        }
}