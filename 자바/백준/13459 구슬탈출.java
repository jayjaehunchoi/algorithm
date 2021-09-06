
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

//동시에 굴러야 한다는 점.
class Marble{
	
	int rX;
	int rY;
	int bX;
	int bY;
	int recur;
	public Marble(int rX, int rY, int bX, int bY, int recur) {
		this.rX = rX;
		this.rY = rY;
		this.bX = bX;
		this.bY = bY;
		this.recur = recur;
	}

}
class Main{
	static Queue<Node> que;
	static boolean[][][][] visited;
	static char[][] board;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static boolean bfs(int rLocX,  int rLocY, int bLocX, int bLocY) {
		
		Queue<Marble> que = new LinkedList<Marble>();
		que.add(new Marble(rLocX,rLocY, bLocX, bLocY,0));
		
		visited[rLocX][rLocY][bLocX][bLocY] = true;
		
		int recur = 1;
		
		Node rLoc = null;
		Node bLoc = null;
		while(!que.isEmpty()) {

			Marble tmp = que.poll();
			
			for(int i = 0 ; i < 4; i++) {
				
				rLoc = move(tmp.rX, tmp.rY, 0, i);
				bLoc = move(tmp.bX, tmp.bY, 0, i);
				
				if(board[bLoc.x+dx[i]][bLoc.y+dy[i]] == 'O') continue;
				
        if(tmp.recur <10) {// 10에서 true가 찍히면 11번째라는 뜻임 그래서 제외
					if(board[rLoc.x+dx[i]][rLoc.y+dy[i]] == 'O') return true;
				}
				
				//끝까지 이동했을 때, 뒤늦게 이동해서 구슬에 걸리는 다른 구슬을 찾기 위해
				if(rLoc.x == bLoc.x && rLoc.y == bLoc.y) {
					if(rLoc.count > bLoc.count) {
						rLoc.x -= dx[i];
						rLoc.y -= dy[i];
					}else {
						bLoc.x -= dx[i];
						bLoc.y -= dy[i];
					}
				}
				if(visited[rLoc.x][rLoc.y][bLoc.x][bLoc.y]) continue;
				
				visited[rLoc.x][rLoc.y][bLoc.x][bLoc.y] = true;
				que.add(new Marble(rLoc.x, rLoc.y , bLoc.x, bLoc.y, tmp.recur+1));
				
			}
			
			if(tmp.recur > 10)return false;
		}
		return false;
		
	}
	
	public static Node move(int x, int y, int count, int i ) {
		
		int nx = x;
		int ny = y;
		
		while(board[nx+dx[i]][ny+dy[i]] != '#' && board[nx+dx[i]][ny+dy[i]] != 'O' ) {
			nx += dx[i];
			ny += dy[i];
			
			count++;
		}
		return new Node(nx,ny,count);
		
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	
    	board = new char[n][m];
    	visited = new boolean[n][m][n][m];
    	
    	int rLocX  = 0;
    	int rLocY  = 0;
    	int bLocX  = 0;
    	int bLocY  = 0;
    	
    	for(int i = 0; i < n ; i++) {
    		board[i] = sc.next().toCharArray();

    		for(int j = 0 ; j < m ; j ++) {
    			if(board[i][j] == 'R') {
    				rLocX = i;
    				rLocY = j;
    			}
    			if(board[i][j] == 'B') {
    				bLocX = i;
    				bLocY = j;
    			}
    		}
    	}
    	
    	if(bfs(rLocX, rLocY, bLocX, bLocY)==true) {
    		System.out.println(1);
    	}else {
    		System.out.println(0);
    	}
    	
    }
}
