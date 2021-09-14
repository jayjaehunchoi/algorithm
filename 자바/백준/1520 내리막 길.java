import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main {
	static int[][] dp;
	static int[][] map;
	static int m;
	static int n;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static int dfs(int x, int y) {
		
		if(x == m && y == n) { // 끝점 도달하면 1 반환
			return 1;
		}
		
		if(dp[x][y] != -1) { //방문노드 다시 검색 ㄴㄴ
			return dp[x][y];
		}else {

			dp[x][y] = 0;
			for(int i = 0 ; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				
				if(nx < 1 || nx > m || ny < 1 || ny > n)continue;
				if(map[x][y] > map[nx][ny]) {
					dp[x][y] += dfs(nx,ny); //갈래로 갈렸는데 끝점까지 도달했다면, 값이 더해지면서 올라오다가 해당 노드에서 합쳐짐
				}
			}
		}
		
		
		return dp[x][y];
		
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		dp = new int[m+1][n+1];
		map = new int[m+1][n+1];
		
		for(int i = 1 ; i <= m; i++ ) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j <=n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(1, 1));
		
	}
}

