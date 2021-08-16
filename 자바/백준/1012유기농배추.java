import java.util.Scanner;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static boolean[][] check;
	
	public static void dfs(int[][] bat , int x, int y) {
		
		check[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i ++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || ny < 0 || nx >= bat.length || ny >= bat[0].length) continue;
			if(!check[nx][ny] && bat[nx][ny]==1) {
				dfs(bat, nx , ny);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0 ; i < t ; i++) {
			int count = 0 ;
			
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] bat = new int[n][m];
			check = new boolean[n][m];
			
			for(int j = 0 ; j < k ; j++) {
				int x =sc.nextInt();
				int y =sc.nextInt();
				
				bat[y][x] = 1;
			}
			
			for(int j = 0 ; j < n ; j++) {
				for(int z = 0 ; z < m ; z++) {
					if(!check[j][z] && bat[j][z] == 1) {
						count++;
						dfs(bat, j , z);
					}
				}
			}
			
			System.out.println(count);
			
		}
		
	}	
}
