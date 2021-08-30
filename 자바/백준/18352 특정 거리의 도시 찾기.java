import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	
	int dist;
	int idx;
	
	@Override
	public int compareTo(Node o) {
		return this.dist - o.dist;
	}
	
	public Node(int dist, int idx) {
		this.dist = dist;
		this.idx = idx;
	}
}
class Main {
	static int n;
	static int m;
	static int k;
	static int x;
	static int[] dp;
	static List<Node>[] aList;
	public static void dijkstra(int x) {
		
		dp[x] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0,x));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int point = n.idx;
			int dist = n.dist;
//			System.out.println(point +" " + dp[point] + " : " + dist);
			if(dp[point] < dist) continue;
			
			for(int i = 0; i < aList[point].size(); i++) {
//				System.out.println(aList[point].get(i).idx + " 값 = " + dp[aList[point].get(i).idx] );		
//				System.out.println("비교값 = " + (dist + aList[point].get(i).dist));
				
				if(dp[aList[point].get(i).idx] > dist + aList[point].get(i).dist ) {
					dp[aList[point].get(i).idx] = dist + aList[point].get(i).dist;
					pq.add(new Node(dp[aList[point].get(i).idx],aList[point].get(i).idx));
				}
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1];
		aList = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			aList[i] = new ArrayList<Node>();
		} 
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			aList[start].add(new Node(1,end));
		}
		dijkstra(x);
		int answer = 0 ;
		for(int i = 1; i < n+1; i++) {
			if(dp[i] == k) {
				System.out.println(i);
				answer++;
			}
		}
		if(answer == 0) {
			System.out.println(-1);
		}
	}

}

	

