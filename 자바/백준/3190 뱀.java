import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// 구현문제
// 다양하게 머리를 써야한다 ㅎㅎ

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Main{
	static int[][] board;
	static Map<Integer, Character> moves = new HashMap<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] check;
	static int count = 0;
	static int app;
	static Queue<Node> body;
	static int headx;
	static int heady;
	
	public static void snake(int x , int y, int dir) {
		boolean stop = true;
		body = new LinkedList<Node>();
		body.add(new Node(0,0));
		headx = x;
		heady = y;
		int direct = dir;
    
		while(true) {
			stop = move(headx,heady,direct);
			if(!stop) {
				return;
			}else {
				if(moves.get(count) == 'D') {
					switch(direct) {
					case 0: 
						direct = 3 ;
						break;
					case 1:
						direct = 2;
						break;
					case 2:
						direct = 0;
						break;
					case 3:
						direct = 1;
						break;
					}
				}else if(moves.get(count) == 'L') {
					switch(direct) {
					case 0: 
						direct = 2 ;
						break;
					case 1:
						direct = 3;
						break;
					case 2:
						direct = 1;
						break;
					case 3:
						direct = 0;
						break;
					}
				}
				moves.remove(count);
			}
		}
	}
	
	public static boolean move(int x, int y, int dir) {
		
		int nx = x;
		int ny = y;
		
		while(moves.getOrDefault(count, 'A') == 'A' ) {
			
			if(nx + dx[dir] < 0 || nx + dx[dir] >= board.length ||  ny + dy[dir] < 0 || ny + dy[dir] >= board.length ) {
				count++;
				return false;
			}
			count++;
			nx += dx[dir];
			ny += dy[dir];
			
			if(check[nx][ny]) {
				return false;
			}
			check[nx][ny] = true;
			
			body.add(new Node(nx,ny));
			
			
			if(board[nx][ny] != 1) {
				Node tmp = body.poll();
				check[tmp.x][tmp.y] = false;
			}
			
			else if(board[nx][ny] == 1){
				board[nx][ny] = 0;
				app--;
			}
		}
		headx = nx;
		heady = ny;
		return true;	
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	board = new int[n][n];
    	check = new boolean[n][n];
    	app = sc.nextInt();
    	
    	for(int i = 0 ; i < app ;i++) {
    		int x = sc.nextInt()-1;
    		int y = sc.nextInt()-1;
    		board[x][y] = 1;
    	}
    	int trans = sc.nextInt();
    	for(int i = 0 ; i < trans ; i++) {
    		int sec = sc.nextInt();
    		char dir = sc.next().charAt(0);
    		moves.put(sec,dir);
    	}
    	check[0][0] = true;
    	snake(0, 0, 3);
    	System.out.println(count);
    }
}
