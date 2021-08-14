import java.util.LinkedList;
import java.util.Queue;

// BFS 방문 노드 클래스
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

class Solution {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] check;
	static int min = Integer.MAX_VALUE;
	
  // Queue를 이용하여 bfs를 돌아준다.
	public static void bfs(int[][] maps) {
		
		Queue<Node> que = new LinkedList<Node>();
		que.add(new Node(0,0,1));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
      // 빠져나가는 조건(도착했을 때)
			if(node.x == maps.length-1 && node.y == maps[0].length-1) {
				min = Math.min(min, node.count);
				return;
			}
			
      // bfs의 핵심
			for(int i = 0 ; i < 4 ; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1 && !check[nx][ny]) {
					que.offer(new Node(nx,ny,node.count+1));	
					check[nx][ny] = true;
          
				}
			}
		}
		
	}
	
    public int solution(int[][] maps) {
        int answer = 0;
        
        check = new boolean [maps.length][maps[0].length];
        
        bfs(maps);
        
        if(min == Integer.MAX_VALUE) {
        	return -1;
        }
        
        return answer;
    }
}
