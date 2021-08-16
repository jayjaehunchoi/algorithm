
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int x;
	int y;
	int count;
	
	public Node(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Main {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt;
	static int min = Integer.MAX_VALUE;
	static boolean[][] check;
	
	public static void bfs(int[][] map, int x, int y) {
		
		Queue<Node> que = new LinkedList<Node>();
		
		que.offer(new Node(x,y,1));
		check[x][y] = true;

		
		while(!que.isEmpty()) {
			
			Node node = que.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx == map.length-1 && ny == map[0].length-1) {
					cnt = node.count;
					cnt += 1;
					
					return;
				}
				
				
				if(nx < 0 || nx >=map.length || ny < 0 || ny >=map[0].length)continue;
				
				if(!check[nx][ny] && map[nx][ny] == 1) {
					
					check[nx][ny] = true;
					que.offer(new Node(nx, ny, node.count+1));
					
					
				}
			}
			
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		check = new boolean[n][m];
		
		String[] temp;
		
		for(int i = 0 ; i < n ; i++) {
			String s = sc.next();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(s.substring(j,j+1));
				
			}
		}
		
		bfs(map,0,0);
		
		System.out.println(cnt);

		
	}	
}
