import java.util.*;
import java.io.*;
class Node{
	
	int x;
	int y;
	int count;
	int beat;
	
	public Node(int x, int y, int count, int beat) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.beat = beat;
}

}

// 이 문제에서는 벽 부수고 지나가기 vs 벽 안부수고 지나가기 두가지 방법이있다. 따라서 풀이는 3차원 배열 혹은 int값으로 체크를 만들어줘야한다.
class Main {
	static int[][] map;
	static int[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static int bfs() {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0, 0, 1, 0));
		check[0][0] = 0;
		Node node = null;
		while(!que.isEmpty()) {
			
			node = que.poll();
			if(node.x == map.length-1 && node.y == map[0].length-1) {
				return node.count;
			}
			for(int i = 0 ; i < 4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)continue;
        // 이미 지나간 곳을 또 지나가려한다면
				if(check[nx][ny] <= node.beat)continue;
				
				if(map[nx][ny] == 0) { // 벽이 없는 길
					que.add(new Node(nx,ny,node.count+1, node.beat));
					check[nx][ny] = node.beat;
					
				} else { //벽이 있을 때, 아직 벽을 부순 경험이 없다면
					if(node.beat==0) {
						que.add(new Node(nx, ny, node.count+1, node.beat+1));
						check[nx][ny] = node.beat+1;
					}
					
					
				}
				
			}
		}
		return -1;
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m  = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		check = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < m ;j++) {
				map[i][j] = Integer.parseInt(s.substring(j,j+1));
				check[i][j] = Integer.MAX_VALUE;
			}
		}
		 System.out.println(bfs());
		
		
		
	}
}
