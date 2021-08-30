import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int[][] graph;
	static boolean[] isVisited;
	static int[] dp;
	static int INF = 1000000001;
	public static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
		for(int i = 0 ; i < dp.length ; i++) {
			dp[i] = INF;
		}
		dp[start] = 0;
		pq.add(new int[] {dp[start] , start});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int busStart = cur[1];
			
			if(isVisited[busStart]) continue;
			
			isVisited[busStart] = true;

			for(int i = 1 ; i < n+1 ; i++) {
				if(dp[i] > dp[busStart] + graph[busStart][i]) {
					dp[i] = dp[busStart] + graph[busStart][i];
					pq.add(new int[] {dp[i], i});
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new int[1001][1001];
		isVisited = new boolean[1001];
		dp = new int[1001];
		
		for(int i = 0 ; i < 1001; i++) {
			for(int j = 0 ; j < 1001; j++) {
				if(i==j)graph[i][j] = 0;
				else {
					graph[i][j] = INF;
				}
			}
		}
		for(int i = 0 ; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
      // 같은 출발 > 같은 도착이여도 다른 값이 주어질 수 있음
			if(cost < graph[x][y]) {
				graph[x][y] = cost;
			}

//			graph[y][x] = cost;
			
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(dp[end]);
		
		
		
	}

}

	

