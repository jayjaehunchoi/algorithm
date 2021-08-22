
// dfs, bfs를 복합적으로 사용하는 문제였다,
// 벽을 세울 수 있는 모든 경우의 수를 찾고,
// 찾을때마다 , bfs로 바이러스 전파 후 , 개수를 세어준뒤 , 최대값을 구하는 방식이다. 

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Virus{
	int x;
	int y;
	public Virus(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Main {
	static int[][] maps;
	static int n;
	static int m;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	static int max = 0;
	static int kk = 0;
	public static void dfs(int x) {
		
		if( x == 3) {
			bfs();
			return;
		}
		
		for(int i = 0 ; i < n ; i++ ) {
			for(int j = 0 ; j < m ; j++) {
				if(maps[i][j] == 0) {
					maps[i][j] = 1;
					dfs(x+1);
					maps[i][j] = 0;
				}
			}
		}
		
	}
	
	public static void bfs() {
		
		int[][] virusCount = new int[n][m];
		Queue<Virus> vQue = new LinkedList<>();
		int count = 0;
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				virusCount[i][j] = maps[i][j];
				if(virusCount[i][j] == 2) {
					vQue.offer(new Virus(i,j));
				}
			}
		}
		
		while(!vQue.isEmpty()) {
			
			Virus v = vQue.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				
				if(nx < 0 || nx >= virusCount.length || ny < 0 || ny >= virusCount[0].length)continue;
				
				if(virusCount[nx][ny] == 0) {
					virusCount[nx][ny] = 2;
					vQue.offer(new Virus(nx,ny));
				}
			}
			
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(virusCount[i][j] == 0) {
					count++;
				}
			}
		}
		if(max < count) {
			max = count;
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		maps = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		
		
		dfs(0);
		System.out.println(max);
		
	}

}
	
