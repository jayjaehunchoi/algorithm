import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
  
  static int[][] node;
	static boolean[] check;
	static String answer = "";
	
  
  //dfs 가장 깊게 파고든 뒤, 반복
	public static void dfs(int x) {
		
		check[x] = true;
		answer += x +" ";
		
		for(int i = 0 ; i < node.length ; i++) {
			if(node[x][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
		
	}
	
  // 넓게 본 뒤 깊게
	public static void bfs(int x) {
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(x);
		answer += x+" ";
		
		check[x] = true;
		
		while(!que.isEmpty()) {
			
			int q = que.poll();
			for(int i = 0 ; i < node.length ; i++) {
				if(node[q][i] == 1 && !check[i]) {
					que.offer(i);
					answer += i+" ";
					check[i] = true;
				}
				
			}
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		node = new int[N+1][N+1];
		check = new boolean[N+1];
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node[a][b] = 1;
			node[b][a] = 1;
		}
		
		
		dfs(V);
		System.out.println(answer);
		Arrays.fill(check, false);
		answer = "";
		bfs(V);
		System.out.println(answer);
		
		
	}
}
