import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] boards;
    static long[][] dp;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static long dfs(int x, int y) {
        if(x == n-1 && y == n-1) {
            return 1;
        }

      // 이미 방문했을 경우
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

      // 방문한 지점은 0으로 처리
        dp[x][y] = 0;
      
      // 위 아래로 가는 경우
        for (int i = 0; i < 2; i++) {
            int nx = x + (dx[i] * boards[x][y]);
            int ny = y + (dy[i] * boards[x][y]);

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        boards = new int[n][n];
        dp = new long[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
        
    }

}
