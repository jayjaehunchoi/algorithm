import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Rupee implements Comparable<Rupee>{
	int x;
	int y;
	int lost;
	
	public Rupee(int x, int y, int lost) {
		this.x = x;
		this.y = y;
		this.lost = lost;
	}

	@Override
	public int compareTo(Rupee o) {
		return this.lost - o.lost;
	}
}

class Main{
	static int[][] cave;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static int dijkstra(int x, int y, int lost) {
		
		PriorityQueue<Rupee> pq = new PriorityQueue<Rupee>();
		pq.add(new Rupee(x,y,lost));
		dp[x][y] = lost;
		
		while(!pq.isEmpty()) {
			
			Rupee rp = pq.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx  = rp.x + dx[i];
				int ny = rp.y + dy[i];
				
				if(nx < 0 || nx >= cave.length || ny < 0 || ny >= cave.length)continue;
				
				if(dp[nx][ny] > dp[rp.x][rp.y] + cave[nx][ny]) {
					dp[nx][ny] = rp.lost + cave[nx][ny];
					
					pq.add(new Rupee(nx,ny,dp[nx][ny]));
				}
				
			}

		}
		return dp[cave.length-1][cave.length-1]; 
		
	}
	


    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int cnt = 0;
    	while(true) {
    		cnt++;
    		int n = Integer.parseInt(br.readLine());
    		
    		if(n ==0) {
    			return;
    		}
    		
    		cave = new int[n][n];
    		dp = new int[n][n];
    		StringTokenizer st;
    		for(int i = 0 ; i < n; i++) {
    			st= new StringTokenizer(br.readLine(), " ");
    			for(int j = 0 ; j < n ; j++) {
    				cave[i][j] = Integer.parseInt(st.nextToken());
    				dp[i][j] = Integer.MAX_VALUE;
    			}
    		}
    		int min = dijkstra(0, 0, cave[0][0]);
    		
    		System.out.println("Problem " + cnt + ": " + min);
    		
    	}
    }
}
