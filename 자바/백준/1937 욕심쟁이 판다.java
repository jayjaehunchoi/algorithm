import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	static int n;
	static int[][] map;
	static int[][] dp;
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
    static int dfs(int i, int j) {
        
        // 이미 방문한 지점이면 이어서 더 갈 필요가 없음
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int cnt = 1;
        for (int k = 0; k < 4; k++) {
        	int nx = dx[k] + i;
        	int ny = dy[k] + j;
        	
        	if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[i][j] >= map[nx][ny])continue;
              // 다음 노드 이어서 탐색하면서 더이상 같데가 없으면 그대로 1 return , 더 있으면 recursion
              cnt = Math.max(dfs(nx, ny)+ 1, cnt);
              dp[i][j] = cnt;
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException{
    	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(reader.readLine());
         map = new int[n][n];
         dp = new int[n][n];
         
         for (int i = 0; i < n; i++) {
             StringTokenizer st = new StringTokenizer(reader.readLine());
             for (int j = 0; j < n; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
             }
         }
         int ans = 0;
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 ans = Math.max(dfs(i, j), ans);
             }
         }
         System.out.println(ans);
    }
}
