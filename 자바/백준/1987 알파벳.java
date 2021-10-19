import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int row;
	int column;
	int count;

	public Node(int row, int column, int count) {
		this.row = row;
		this.column = column;
		this.count = count;
	}
}


class Main {
	static int r,c;
	static char[][] boards;
	static int[] alpha;
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max = 1;

	public static void dfs(Node node) {

		for(int i = 0 ; i < 4; i++) {
			int nx = dx[i] + node.row;
			int ny = dy[i] + node.column;
			
			if(nx < 0 || ny < 0 || nx >= r || ny >= c || alpha[boards[nx][ny]-'A'] != 0)continue;
			if(!check[nx][ny]) {
				
				Node nNode = new Node(nx, ny, node.count+1);
				max = Math.max(nNode.count, max);
				alpha[boards[nx][ny]-'A']++;
				check[nx][ny] = true;
				dfs(nNode);
				check[nx][ny] = false;
				alpha[boards[nx][ny]-'A']--;
			}
		}
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		boards = new char[r][c];
		check = new boolean[r][c];
		alpha = new int[26];
		for(int i = 0 ; i < r; i++) {
			boards[i] = br.readLine().toCharArray();
		}
		Node n = new Node(0, 0, 1);
		check[0][0] = true;
		alpha[boards[0][0]-'A']++;
		dfs(n);
		System.out.println(max);
    }
  
}
