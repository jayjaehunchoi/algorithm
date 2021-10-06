
class Solution {
	final int DIVIDER = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] boards = new int[n+1][m+1];
      // 1,1 부터 시작
        boards[1][1] = 1;
      // 0번째 idx = 가로좌표(y), 1번째 idx = 세로좌표(x);
        for(int i = 0 ; i < puddles.length; i++) {
        	int x = puddles[i][0];
        	int y = puddles[i][1];
        	boards[y][x] = -1;
        }
        for(int i = 1 ; i <= n ; i++) {
        	for(int j = 1 ; j <= m; j++) {
        		
        		if(boards[i][j] == -1) {
        			boards[i][j] = 0;
        			continue;
        		}
        		if(i != 0) {
        			boards[i][j] += boards[i-1][j];
        		}
        		if(j != 0) {
        			boards[i][j] += boards[i][j-1];
        		}
        		boards[i][j] %= DIVIDER;
        	}
        }
        
        return boards[n][m] % DIVIDER;
    }
}
