import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int idx;
	int dist;
	
	public Node( int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node arg0) {
		
		return this.dist-arg0.dist;
	}
}

class Main{
	static List<Node>[] aList;
	static int[] dp;
	static int INF = 100000001;
	public static void dijkstra(int i) {
		PriorityQueue<Node> que = new PriorityQueue<Node>();

		que.add(new Node(i,0));
		dp[i] = 0;
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			int curDis = node.dist;
			int curIdx = node.idx;
			
			if(dp[curIdx] < curDis)continue;
			
			for(int start = 0; start < aList[curIdx].size(); start++ ) {
				
				if(dp[aList[curIdx].get(start).idx] > curDis + aList[curIdx].get(start).dist) {
					dp[aList[curIdx].get(start).idx] = curDis + aList[curIdx].get(start).dist;
					que.add(new Node(aList[curIdx].get(start).idx, dp[aList[curIdx].get(start).idx]));
				}
				
			}
				
			
		}
		
	}
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken()); // 학생 수이자 그래프 크기
    	int m = Integer.parseInt(st.nextToken()); // 단방향 도로 개수
    	int x = Integer.parseInt(st.nextToken()); // 목적지

    	aList = new ArrayList[n+1];
    	for(int i = 0 ; i <=n; i++) {
    		aList[i] = new ArrayList<Node>();
    	}

    	for(int i = 0 ; i < m ; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int distance = Integer.parseInt(st.nextToken());
    		
    		aList[start].add(new Node(end,distance));
    	}
    	
    	int max = 0;
    	dp =  new int[n+1];
    	Arrays.fill(dp, INF);
    	int[] dp2 = new int[n+1];
    	
    	dijkstra(x);
    	dp2 = Arrays.copyOf(dp, n+1);

    	
    	for(int i = 1; i <= n; i++ ) {
    		dp =  new int[n+1];
    		Arrays.fill(dp, INF);
    		
    		dijkstra(i);
    		max= Math.max(dp[x]+dp2[i], max);
    	}
    	System.out.println(max);
    	
    }
    
}
