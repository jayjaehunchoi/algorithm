import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
}

class Node2{
	int x;
	int y;
	int count;
	public Node2(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

class Main {
	static int[][] island;
	static boolean[][] check;
	static boolean[][] checkCopy;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Node> aList;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int x, int y, int num) {
		
		for(int i = 0 ; i < 4; i++) {
			int nx = x+ dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= island.length|| ny < 0 || ny >= island.length)continue;
			
			if(island[nx][ny] == 0) aList.add(new Node(nx,ny));
			if(!check[nx][ny] && island[nx][ny] == 1) {
				check[nx][ny] = true;
				island[nx][ny] = num;
				dfs(nx,ny,num);
			}
		}
	}
	
	public static void bfs(int x, int y, int num) {
		
		Queue<Node2> que = new LinkedList<Node2>();
		que.add(new Node2(x,y,1));
		
		while(!que.isEmpty()) {
			Node2 node = que.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || nx >= island.length|| ny < 0 || ny >= island.length)continue;
				
				if(island[nx][ny] != num && island[nx][ny] != 0) {
					
					min = Math.min(node.count, min);
					return;
				}
				if(!checkCopy[nx][ny] && island[nx][ny] == 0) {
					checkCopy[nx][ny] = true;
//					System.out.println(node.x + " " + node.y + " " + node.count);
					que.add(new Node2(nx,ny,node.count+1));
				}
				
			}
		}
		
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		island = new int[n][n];
		StringTokenizer st;
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < n ; j++) {
				island[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check = new boolean[n][n];
		int num = 1;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(island[i][j] == 1 && !check[i][j]) {
					check = new boolean[n][n];
					aList = new ArrayList<Node>();
					island[i][j] = num;
					dfs(i, j, num);
					
					for(int k = 0 ; k < aList.size() ; k++) {
						checkCopy = new boolean[n][n];
						bfs(aList.get(k).x, aList.get(k).y, num);
					}
					num++;
					
				}
			}
		}
		System.out.println(min);
	}
}
