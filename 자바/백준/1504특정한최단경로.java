import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int e;
	static int INF = 999999999;
	static int[][] graph = new int [801][801];
	public static int dijkstra(int start, int via) {
		int[] dp = new int[801];	
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
		
		for(int i = 0 ; i <dp.length; i++) {
			dp[i] = INF; 
		}
		dp[start] = 0 ;
		pq.add(new int[] {0, start});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int preP = cur[1];
			
			// 간선 다시 들르기 가능, 하지만 기존 값보다 크면 올 필요 없음
			if(dp[preP] < cur[0]) continue;
			
			for(int i = 1; i < n+1; i++) {
				if(dp[i] > dp[preP] + graph[preP][i]) {
					dp[i] = dp[preP] + graph[preP][i];
					pq.add(new int[] {dp[i], i});
				}
			}
		}
		return dp[via];
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(sc.nextToken());
		e = Integer.parseInt(sc.nextToken());
		
		for(int i = 0 ; i < 801; i++) {
			for(int j = 0 ; j < 801; j++) {
				if(i == j ) graph[i][j] = 0;
				else {
					graph[i][j] = INF;
				}
			}
		}
		for(int i = 0 ; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			if(graph[x][y] > dist) {
				graph[x][y] = dist;
				graph[y][x] = dist;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int via1 = Integer.parseInt(st.nextToken());
		int via2 = Integer.parseInt(st.nextToken());
		
    // 둘 중 최소값 구하면 됨.
		long answer = dijkstra(1, via1) + dijkstra(via1, via2) + dijkstra(via2, n);
		long answer2 = dijkstra(1, via2) + dijkstra(via2, via1) + dijkstra(via1, n);
    
    // 하나라도 INF값이면 들를 수 없다는 뜻.
		if(dijkstra(1, via1) == INF || dijkstra(via1, via2) == INF || dijkstra(via2, n)==INF) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(answer, answer2));
		}
		
	}

}

	

