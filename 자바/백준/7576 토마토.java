
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
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
class Main{
	static Queue<Node> que = new LinkedList<>();
	static int[][] box;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	public static int bfs() {
		int count = 0 ;
		while(!que.isEmpty()) {
			Node node = que.poll();
			int x = node.x;
			int y = node.y;
//			System.out.println(x + " " + y + " " + count);
			for(int i = 0 ; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				
				if(nx < 0 || nx >= box.length || ny <0 || ny >= box[0].length)continue;
				if(!visited[nx][ny] && box[nx][ny] == 0) {
					visited[nx][ny] = true;
					box[nx][ny] = 1;
					que.offer(new Node(nx,ny,node.count+1));
				}
			}
			count = node.count;
		}
		return count;
		
	}
	
	public static boolean find() {
		
		for(int i = 0 ; i< box.length ; i++) {
//			System.out.println();
			for(int j = 0 ; j < box[0].length ; j++) {
//				System.out.print(box[i][j] + " ");
				if(box[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st= new StringTokenizer(br.readLine()," ");
    	
    	int m = Integer.parseInt(st.nextToken());
    	int n = Integer.parseInt(st.nextToken());
    	box = new int[n][m];
    	visited = new boolean[n][m];
    	
    	for(int i = 0 ; i < n ; i ++) {
    		st= new StringTokenizer(br.readLine()," ");
    		for(int j = 0 ; j < m ; j++) {
    			box[i][j] = Integer.parseInt(st.nextToken());
    			if(box[i][j] == 1) {
    				que.offer(new Node(i,j,0));
    			}
    		}
    	}
    	if(que.size() == n*m) {
    		System.out.println(1);
    		return;
    	}
    	
    	int answer = bfs();
    	if(find() == false) {
    		System.out.println(-1);
    	}else {
    		System.out.println(answer);
    	}
    }
}
