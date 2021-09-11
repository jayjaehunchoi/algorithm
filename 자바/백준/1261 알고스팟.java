import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Wall implements Comparable<Wall>{
	int x;
	int y;
	int beat;
	
	public Wall(int x, int y, int beat) {
		this.x = x; 
		this.y = y;
		this.beat = beat;
	}
	
	public int compareTo(Wall o) {
		return this.beat - o.beat;
	}
}

class Main{
	static int[][] maze;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] check; 		
	
	public static int dijkstra(int x, int y, int beat) {
		PriorityQueue<Wall> pq = new PriorityQueue<Wall>();
		pq.add(new Wall(x,y,beat));
		dp[x][y] = beat;
		
		while(!pq.isEmpty()) {
			
			Wall w = pq.poll();
			check[w.x][w.y] = true;
			
			for(int i = 0 ; i < 4; i++) {
				int nx = w.x + dx[i];
				int ny = w.y + dy[i];
				
				if(nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length)continue;
				
				if(dp[nx][ny] > w.beat + maze[nx][ny] && !check[nx][ny]) {
					dp[nx][ny] = w.beat + maze[nx][ny];
					
					pq.add(new Wall(nx, ny, dp[nx][ny]));
				}
			}
			
		}
		return dp[maze.length-1][maze[0].length-1];
		
	}


    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	maze = new int[m][n];
    	dp = new int[m][n];
    	check = new boolean[m][n];
    	for(int i = 0 ; i < m ; i++) {
    		String s =br.readLine();
    		for(int j = 0 ; j < n ; j++) {
    			maze[i][j] = Integer.parseInt(s.substring(j,j+1));
    			dp[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	int min = dijkstra(0, 0, 0);
    	System.out.println(min);
    }

}
