import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	
	
}

public class Main {
	static int[][] nations;
	static boolean[][] visited;
	static int l;
	static int r;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Node> nodes = new ArrayList<Node>();
	static int cnt;
  
  // 국경이 열린 국가 확인
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		nodes.add(new Node(x,y));
		cnt++;
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= nations.length || ny >= nations[0].length)continue;
			int comp = Math.abs(nations[x][y]-nations[nx][ny]);
			if(comp >= l && comp <= r && !visited[nx][ny]) {
				dfs(nx,ny);
			}
		}
	}
	
  // 인구 이동 조건 발생
	public static void move() {
		int sum = 0;
		for(int i = 0 ; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			sum += nations[node.x][node.y];
		}
		
		for(int i = 0 ; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			nations[node.x][node.y] = sum/cnt;
		}
		nodes.clear();
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		nations = new int[n][n];
		for(int i = 0 ; i < n ;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < n ; j++) {
				nations[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while(true) {
			boolean changed = false;
			visited = new boolean[n][n];
			for(int i =  0 ; i < n ; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j]) {
						cnt = 0;
						dfs(i,j);
						if(cnt > 1) {
              // 인구이동
							move();
							changed = true;
						}else {
              // 인구 이동 x
							nodes.clear();
						}	
					}
				}
			}
      // 인구 이동이 없었다면
			if(!changed) {
				System.out.println(answer);
				return;
			}
			answer++;
		}
		
	}
} 
