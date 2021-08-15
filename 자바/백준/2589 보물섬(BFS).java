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
	
	static boolean[][] check;
	
	static int count;
	static int minCnt = Integer.MAX_VALUE;
	static int maxCnt = 0;
	
  // 모든 땅 들러서 최단거리 구한 후 그 중 최대값을 구해주면 됨.
	public static void bfs(String[][] map , int x , int y) {
		
		Queue<Node> que = new LinkedList<Node>();
		
		que.add(new Node(x, y, 0));
		
		while(!que.isEmpty()) {
			
			Node node = que.poll();
			
			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny].equals("L") && !check[nx][ny]) {
					
					que.offer(new Node (nx,ny,node.count+1));
					check[nx][ny] =true;
					
				}
				count = node.count;
			}
			
			
		}
		
		if(minCnt > count ) {
			minCnt = count;
		}
		if(maxCnt < minCnt) {
			maxCnt = minCnt;
		}

	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String [][] map = new String[n][m];
		check = new boolean[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			String a = sc.next();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = a.substring(j,j+1);
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j].equals("L")) {
					check = new boolean[n][m];
					// 이것때문에 ;; 몇번 틀림, 자기 자신은 방문처리해줘야한다 꼭..!
          				check[i][j] = true;
					bfs(map,i,j);
					minCnt = Integer.MAX_VALUE;
					
				}
				
			}
		}
		
		System.out.println(maxCnt);

		
	}	
}
