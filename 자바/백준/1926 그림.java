
import java.util.Scanner;

class Main{
	static int[][] paper;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max = 0;
	static int count;

  public static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= paper.length || ny < 0 || ny >= paper[0].length)continue;
			if(paper[nx][ny] == 1 && !visited[nx][ny]) {		
				count++;
				dfs(nx, ny);
			}
		}
		
	}
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);

    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	
    	paper = new int[n][m];
    	visited = new boolean[n][m];
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = 0 ; j < m ; j++) {
    			paper[i][j] = sc.nextInt();
    		}
    	}
    	int numberOfDraw = 0;
    	for(int i = 0 ; i < n ; i++) {
    		
    		for(int j = 0 ; j < m ; j++) {
    			
    			if(paper[i][j] == 1 && !visited[i][j] ) {
    				count = 1;
    				numberOfDraw++;
    				dfs(i, j);
    				max = Math.max(count, max);
    			}
    		}
    	}
    	
		System.out.println(numberOfDraw);
    System.out.println(max);

    }
}
