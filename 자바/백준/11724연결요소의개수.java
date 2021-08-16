// 간선이 없다고하여 정점이 없는것은 아니다.
// 정점의 개수 정점, 정점 노드에 꼭 값을 넣어줬어야 함.

import java.util.Scanner;

public class Main {
	
	static boolean[] check;
	
  // x 쭉 방문하다가 본인과 다르면서 1이면서, 방문하지 않은값이면 해당 행으로 이동
	public static void dfs(int[][] graph, int x) {
		
		for(int j = 0 ; j < graph[0].length ; j++) {
			if(graph[x][j] == 1 && !check[j] && x != j) {
				check[j] =true;
				dfs(graph, j);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] graph = new int[n+1][n+1];
		
		for(int i = 0 ; i < m ; i++) {
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		
		for(int i = 1 ; i < n+1 ; i++) {
			graph[i][i] = 1;
		}
		
		check = new boolean[n+1];
		
    // 반복되는 횟수만큼이 연결요소의 개수
		for(int i = 0 ; i < n+1 ; i++) {
			for(int j = 0 ; j < n+1 ; j++) {
				if(!check[j] && graph[i][j] == 1) {
					dfs(graph, j);
					count++;
					
				}
				
			}
		}
		System.out.println(count);
		
	}	
}
