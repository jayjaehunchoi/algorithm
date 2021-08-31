import java.util.*;
import java.lang.*;
import java.io.*;
class Node implements Comparable<Node>{
    int dist;
    int idx;
    
    @Override
    public int compareTo(Node o){
        return this.dist - o.dist;
    }
    public Node(int dist, int idx){
        this.dist = dist;
        this.idx = idx;
    }
    
}
class Main{
    static int v;
    static int e;
    static int k;
    static int[] dp;
    static List<Node>[] aList;
    static int INF = 100000001;
    public static void dijkstra(int k){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dp[k] = 0;
        pq.add(new Node(0,k));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            int distance = n.dist;
            int preP = n.idx;
            
            if(dp[n.idx] < distance)continue;
            
            for(int i = 0 ; i < aList[preP].size(); i++){
                if(dp[aList[preP].get(i).idx] > distance + aList[preP].get(i).dist){         
                    dp[aList[preP].get(i).idx] = distance + aList[preP].get(i).dist;

                    pq.add(new Node(dp[aList[preP].get(i).idx], aList[preP].get(i).idx));
                }
            }
            
            
        }
        
        
    }    
        
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        dp = new int[v+1];
        aList = new ArrayList[v+1];
        
        for(int i = 0 ; i < aList.length; i++){
            aList[i] = new ArrayList<Node>();
        }
        Arrays.fill(dp, INF);
        for(int i = 0 ; i < e ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            aList[s].add(new Node(w,end));
        }
        dijkstra(k);
        for(int i = 1; i < v+1; i++){
            if(dp[i] == INF){
                System.out.println("INF");
            }else{
                System.out.println(dp[i]);
            }
        }
    }
}
