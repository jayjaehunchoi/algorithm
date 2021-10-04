import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y =y;
	}
}

class Main {
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static char[][] boards;
	static boolean[][] checks;
	
  //반복문을 돌며 지뢰를 찾는다, 이미 방문한 곳은 체크할 이유 없고
  // 지뢰 확정은 numb -- 해준다.
  // 방문 + 의심군이면 list에 추가해놓고, 최종적으로 리스트와 남은 numb가 같으면 지뢰 확정시켜준다.
	public static void findCells(int x, int y) {
		List<Node> aList = new ArrayList<>();
		int numb = boards[x][y]-'0';
		
		for(int i = 0 ; i < 8; i++) {
			int nx = x+ dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= boards.length || ny >= boards.length)continue;
			if(boards[nx][ny] == '#' && !checks[nx][ny]) {
				if(numb != 0) {
					aList.add(new Node(nx,ny));
					checks[nx][ny] = true;
				}else{
					checks[nx][ny] = true;
				}
			}else if(boards[nx][ny] == '*') {
				numb--;
			}
		}
		if(aList.size() == numb) {
			for(int i = 0 ; i < aList.size(); i++) {
				boards[aList.get(i).x][aList.get(i).y] = '*';
			}
		}
		
	}
	// 최대값을 구하는 부분이다 보니, 들리지 않은 곳은 모두 지뢰라고 생각한다.
	public static int countCells() {
		int cnt = 0;
		for(int i = 0 ; i < boards.length; i++) {
			//System.out.println();
			for(int j = 0 ; j < boards.length; j++) {
				
				if(boards[i][j] == '#' && !checks[i][j]) {
					boards[i][j] = '*';
					cnt++;
				}else if(boards[i][j] == '*') {
					cnt ++;
				}
				//System.out.print(boards[i][j]);
			}
		}
		return cnt;
	}
	
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		boards = new char[n][n];
		checks = new boolean[n][n];
		for(int i = 0 ; i < n ; i++) {
			boards[i] = br.readLine().toCharArray();
		}
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(boards[i][j] != '#' && boards[i][j] != '*') {
					findCells(i, j);
				}
			}
		}
		System.out.println(countCells());
    }
  
}
