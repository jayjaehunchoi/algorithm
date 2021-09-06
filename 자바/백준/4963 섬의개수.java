import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main{
	static int[] dx = {-1,1,0,0,1,1,-1,-1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};
	static boolean[][] visited;
	static int[][] maps;
	public static void dfs(int x, int y) {
		
		for(int i = 0 ; i < 8 ; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx <0 || nx >= maps.length || ny < 0 || ny >= maps[0].length)continue;
			if(!visited[nx][ny] && maps[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
		
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	while(true) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int w = Integer.parseInt(st.nextToken());
    		int h = Integer.parseInt(st.nextToken());
    		
    		if(w == 0 && h == 0) {
    			return;
    		}
    		maps = new int[h][w];
    		visited = new boolean[h][w];
    		for(int i = 0 ; i < h; i++) {
    			st = new StringTokenizer(br.readLine(), " ");
    			for(int j = 0 ; j < w; j++) {
    				maps[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		int count = 0;
    		
    		for(int i = 0 ; i < h; i++) {
    			for(int j = 0 ; j < w; j++) {
    				if(maps[i][j] == 1 && !visited[i][j]) {
    					dfs(i, j);
    					count++;
    				}
    			}
    		}
    		System.out.println(count);
    		
    	}
    }
}
