
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	static int count = 0;
	
	public static void dfs(int[][] node , int i , boolean[] check) {
		
		check[i] = true;
		
		for(int j = 0 ; j < node.length ; j++) {
			if(i != j && node[i][j] == 1 && !check[j]) {
				count++;
				dfs(node, j , check);
			}
		}
		
	}
	
	public static void bfs(int[][] node , int i , boolean[] check) {
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(i);
		check[i] = true;
		
		while(!que.isEmpty()) {
			
			int q = que.poll();
			for(int j = 0 ; j < node.length ; j++) {
				if(!check[j] && node[q][j] == 1) {
					count++;
					check[j] = true;
					que.offer(j);
					
				}
			}
		}
		
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] node = new int[n+1][n+1];
		
		for(int i = 0; i < m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			node[a][b] = 1;
			node[b][a] = 1;
		}
		
		boolean[] check = new boolean[n+1];
		
		bfs(node,1,check);
		System.out.println(count);
	}	
}
