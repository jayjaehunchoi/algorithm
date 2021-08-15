
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
  
  // 컨트롤러를 둬서 겹치는 친구들을 찾아준다.
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static boolean[][] check;
	static int count = 1;
	static List<Integer> bunji = new ArrayList<>();
	
	public static void dfs(int[][] map, int x ,int y) {

		check[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			
			int nx = x+dx[i];
			int ny = y+dy[i];
//			System.out.println("["+nx + " " + ny+"]");
			if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 0) {
				continue;
			}
			if(map[nx][ny] == 1 && !check[nx][ny]) {
				count++;
				dfs(map, nx, ny);
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] map = new int[n][n];
		check = new boolean[n][n];
		
		int totalnum = 0;
		
		for(int i = 0 ; i < n ; i++) {
			String m = sc.next();
			
			for(int j = 0 ; j < n ; j++) {
				
				map[i][j] = Integer.parseInt(m.substring(j,j+1));
				
			}
			
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(!check[i][j] && map[i][j] == 1) {
					// 새로이 시작할때마다 번지수는 증가한다.
          totalnum++;
					dfs(map, i, j);
					bunji.add(count);
					count = 1;
//					System.out.println(i + " " + j);
				}
			}
		}
		System.out.println(totalnum);
		
		Collections.sort(bunji);
		
		for(int l : bunji) {
			System.out.println(l);
		}
		
	}	
}
