
import java.util.Scanner;

class Main{
	static String[][] color;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= color.length || ny < 0 || ny >= color[0].length)continue;

			if(color[nx][ny].equals(color[x][y]) && !visited[nx][ny]) {	
				dfs(nx, ny);
			}
		}
		
	}
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);

    	int n = sc.nextInt();
    	
    	color = new String[n][n];
    	visited = new boolean[n][n];
    	for(int i = 0 ; i < n ; i++) {
    		color[i] = sc.next().split("");
    	}
      
      // 일반인
    	int numberDis = 0;
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			if(!visited[i][j]) {
    				numberDis++;
    				dfs(i, j);
    			}
    		}
    	}
    	
      // 적록색약
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			if(color[i][j].equals("R") ) {
    				color[i][j] = "G";
    			}
    		}
    	}
    	visited = new boolean[n][n];
    	
    	int numberDisNo = 0;
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			if(!visited[i][j] ) {
    				numberDisNo++;
    				dfs(i, j);
    			}
    		}
    	}
    	
    	System.out.println(numberDis);
    	System.out.println(numberDisNo);

    }
}
