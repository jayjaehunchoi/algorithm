import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

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
class Main {
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int[][] arr;
	static boolean[][] check;
	static Node shark = null;
	static List<Node> aList;
	static int size = 2;
  
	public static void bfs() {
		Queue<Node> que = new LinkedList<Node>();
		que.add(shark);
		check[shark.x][shark.y] = true;
		
		while(!que.isEmpty()) {
			Node n = que.poll();
			for(int i = 0 ; i < 4;  i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
        // 규칙 1 : 상어보다 크거나 범위 넘어가면 못감
				if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length || arr[nx][ny] > size)continue;
				if(!check[nx][ny]) {
          // 규칙 2 : 상어 크기와 같거나 , 0 이면 지나갈 수 있음
					if(arr[nx][ny] == size ||arr[nx][ny] == 0 ) {
						check[nx][ny] = true;
						que.add(new Node(nx,ny,n.count+1));
					}
          // 규칙 3 : 상어보다 크기가 작으면 먹을 수 있음 (먹을 수 있는 친구들을 리스트에 추가해줌)
					else{
						check[nx][ny] = true;
						que.add(new Node(nx,ny,n.count+1));
						aList.add(new Node(nx,ny, n.count+1));	
					}
				}
			}
		}
	}

    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 
    	 int n = Integer.parseInt(br.readLine());
    	 
    	 StringTokenizer st;
    	 
    	 arr= new int[n][n];
    	 for(int i = 0 ; i < n ; i++) {
    		 st = new StringTokenizer(br.readLine(), " ");
    		 for(int j = 0 ; j < n ; j++) {
    			 arr[i][j] = Integer.parseInt(st.nextToken());
    			 // 상어 위치를 파악했으면 0으로 처리해줌
           if(arr[i][j] == 9)  {
    				 shark = new Node(i,j,0);
    				 arr[i][j] = 0;
    			 }
    		 }
    	 }
    	 int ans = 0;
    	 int vol = 0;
		 Node fish = null;
		 while(true) {
			 check = new boolean[n][n];
			 aList = new ArrayList<Node>();
			 bfs();
			 if(aList.size() == 0) {
				 System.out.println(ans);
				 return;
			 }else { // 상어 규칙 : 가장 가까운 먹이 >  가장 높은 위치의 먹이 > 가장 왼쪽의 먹이 
				 fish = aList.get(0);
				 for(int k = 1; k < aList.size(); k++) {
					 if(fish.count > aList.get(k).count) {
						 fish = aList.get(k);
					 }else if(fish.count == aList.get(k).count) {
						 if(fish.x > aList.get(k).x) {
							 fish = aList.get(k);
						 }else if(fish.x == aList.get(k).x) {
							 if(fish.y > aList.get(k).y) {
								 fish = aList.get(k);
							 }
						 }
					 }
				 }
			 }
			 arr[fish.x][fish.y] = 0;
			 vol++;
			 Node node = null;
       // 먹은 양과 크기가 동일해지면 , 크기 1 증가
			 if(vol == size) {
				 node = new Node(fish.x,fish.y,fish.count);
				 size++;
				 vol = 0;
			 }else {
				 node = new Node(fish.x,fish.y,fish.count);
			 }
			 shark = node;
			 ans = shark.count;
    	}
    }
  
}
