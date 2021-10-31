import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[] dx= {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] visited;
	static int[][] room;
	static int count = 1;
  
  
	public static void dfs(int x, int y, int dir) {
		
		visited[x][y] = true;
		
		int start = startPoint(dir);
		int curDir = dir;
		for(int i = start; i < start+4; i++) {
			int val = i % 4;
			int nx = dx[val] + x;
			int ny = dy[val] + y;
			curDir = turnLeft(curDir);
			if(room[nx][ny] == 1 || visited[nx][ny])continue;
			count++;
			dfs(nx, ny, curDir);	
			break;
		}
		int back = backPoint(curDir);
		int newX = x + dx[back];
		int newY = y + dy[back];
    // dfs 특성상 return 만으로는 종료가 안됨. 따라서 system exit으로 종료해줬음.
		if(room[newX][newY] == 1) {
			System.out.println(count);
			System.exit(0);
		}else {
			dfs(newX, newY, curDir); // 후진하지만 , 청소는 하지 않음
		}
		
	}
	
// 후진 방향정하기
	public static int backPoint(int dir) {
		int res = 0;

		switch(dir) {
			case 0 : 
				res = 2;
				break;
			case 1 : 
				res = 1;
				break;
			case 2 : 
				res = 0;
				break;
			case 3 : 
				res = 3;
				break;
		}
		return res;
	}
	// 방향에 따른 시작점 정하기
	public static int startPoint(int dir) {
		int res = 0;

		switch(dir) {
			case 0 : 
				res = 1;
				break;
			case 1 : 
				res = 0;
				break;
			case 2 : 
				res = 3;
				break;
			case 3 : 
				res = 2;
				break;
		}
		return res;
	}
	
  // 방향에 따라 왼쪽으로 
	public static int turnLeft(int dir) {
		int res = 0;

		switch(dir) {
			case 0 : 
				res = 3;
				break;
			case 1 : 
				res = 0;
				break;
			case 2 : 
				res = 1;
				break;
			case 3 : 
				res = 2;
				break;
		}
		return res;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int curX = Integer.parseInt(st.nextToken());
		int curY = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		room = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i< n ;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < m ; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(curX, curY, dir);
		System.out.println(count);
	}
} 
