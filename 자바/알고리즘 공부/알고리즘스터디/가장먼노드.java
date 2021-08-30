import java.util.*;
import java.lang.*;
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
class Solution {
	static int INF = 100000001;
    static int[] dp;
    static List<Node>[] aList;
	
    public void dijkstra(){
        dp[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(0,1));
        
        while(!pq.isEmpty()){
            
            Node n = pq.poll();
            int index = n.idx;
            int dist = n.dist;
            
            if(dp[index] < dist)continue;
            
            for(int i = 0 ; i < aList[index].size(); i++){
                if(dp[aList[index].get(i).idx] > dist + aList[index].get(i).dist){
                    dp[aList[index].get(i).idx] = dist + aList[index].get(i).dist;
                    pq.add(new Node(dp[aList[index].get(i).idx], aList[index].get(i).idx));
                }
                
            }
            
        }
       
        
        
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        dp = new int[n+1];
        Arrays.fill(dp, INF);
        
        aList = new ArrayList[n+1];
        for(int i = 0 ; i < aList.length; i++){
            aList[i] = new ArrayList<Node>();
        }
        
        for(int i = 0 ; i < edge.length; i++){
            aList[edge[i][0]].add(new Node(1,edge[i][1]));
            aList[edge[i][1]].add(new Node(1,edge[i][0]));
        }
        
        dijkstra();
        
        int a = 0;
        for(int i = 1 ; i < n+1; i++){
            a = Math.max(a, dp[i]);
        }
        for(int i = 1 ; i < n+1; i++){
           if(a == dp[i]){
               answer++;
           }
        }
        
        
        return answer;
    }
}
