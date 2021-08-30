import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	
	int INF = 1000000001;
	int count = 0;
	
	public void dijkstra(int N, int[][] house ,int K,int start) {
		
		int[] dp = new int[51];
		boolean[] visited = new boolean[51];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
		Arrays.fill(dp, INF);
		
		dp[start] = 0;
		pq.add(new int[] {0, start});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int preP = cur[1];
			
			if(visited[preP])continue;
			
			visited[preP] = true;
			
			for(int i = 1 ; i < N+1 ; i++) {
				if(dp[i] > dp[preP] + house[preP][i]) {
					dp[i] = dp[preP] + house[preP][i];
					pq.add(new int[] {dp[i], i});
				}
			}
			
		}
		for(int i = 1 ; i < N+1 ; i++) {
			if(dp[i] <= K) {
				count++;
			}
		}
		
	}
	
    public int solution(int N, int[][] road, int K) {
        int[][] house = new int[51][51];
        
        for(int i = 0 ; i < 51; i++) {
       	 Arrays.fill(house[i], INF);
        }
        
        for(int i = 0 ; i < road.length; i++) {
        	int x = road[i][0];
        	int y = road[i][1];
        	int time = road[i][2];
        	
        	if(house[x][y] > time) {
        		house[x][y] = time;
            	house[y][x] = time;
        	}
        	
        }
        dijkstra(N, house, K ,1);
        
        return count;
    }
}
