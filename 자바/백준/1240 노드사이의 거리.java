import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 간단한 dfs 문제였다.
// 하지만 만약 dfs로 풀지 말라고 했다면? 최대 1000개의 노드라 고민은 좀 했을거같다

class Node{
	
	int srt;
	int dist;
	
	public Node(int srt, int dist) {
		this.srt = srt;
		this.dist = dist;
	}
}
class Main {
	static int[][] nodes;
	static boolean[] visited;
	static int dis;
	public static void dfs(Node node, int end) {
		
		if(node.srt == end) {
			dis = node.dist;
			return;
		}
		visited[node.srt] = true;
		
		for(int i = 1; i < nodes.length; i++) {
			if(!visited[i] && nodes[node.srt][i] != 0) {
				dfs(new Node(i,node.dist+nodes[node.srt][i]), end);
			}
		}
		
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		nodes = new int[n+1][n+1];
		
		for(int i =  0 ; i < n-1 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			nodes[a][b] = dist;
			nodes[b][a] = dist;
		}
		StringBuilder sb = new StringBuilder();
		while(m-->0) {
			visited = new boolean[n+1];
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			dis = 0;
			dfs(new Node(start,0), end);
			sb.append(dis+"\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
}
