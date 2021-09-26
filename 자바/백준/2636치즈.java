import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int rows;
	static int columns;
	static int[][] maps;
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
  
	public static void dfs(int x, int y) {
		
		check[x][y] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= rows || ny >= columns)continue;
			if(maps[nx][ny] == 1) {
				maps[nx][ny] = 2;
				continue;
			}
			if(!check[nx][ny] && maps[nx][ny] == 0) {
				dfs(nx,ny);
			}
		}
	}
	
	public static int findMelt() {
		int melt = 0 ;
		
		for(int i = 0 ; i < rows; i++) {
			for(int j = 0 ; j < columns; j++) {
				if(maps[i][j] == 2) {
					melt++;
					maps[i][j] = 0;
				}
			}
		}
		return melt;
	}

	
    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	 rows = Integer.parseInt(st.nextToken());
    	 columns = Integer.parseInt(st.nextToken());
    	 
    	 maps = new int[rows][columns];
    	 
    	 
    	 for(int i = 0 ; i < rows; i++) {
    		 st = new StringTokenizer(br.readLine(), " ");
    		 for(int j = 0 ; j < columns ; j++) {
    			 maps[i][j] = Integer.parseInt(st.nextToken());
    		 }
    	 }
    	 int melt = 0;
    	 int cnt = 0;
    	 while(true) {
    		 check = new boolean[rows][columns];
    		 dfs(0,0);
    		 int m = findMelt();
    		 if(m == 0) {
    			 System.out.println(cnt);
    			 System.out.println(melt);
    			 return;
    		 }else {
    			 melt = m;
    		 }
    		 cnt++;
    		 
    	 }
    	
    }
  
}
