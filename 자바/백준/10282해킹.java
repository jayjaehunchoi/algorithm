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
	int sec;
	
	public int compareTo(Node o) {
		return this.sec - o.sec;
	}
	
	public Node(int idx, int sec) {
		this.idx = idx;
		this.sec = sec;
		
	}
	
}

class Main {
	static List<Node>[] aList;
	static int[] dp;
	static int INF = 987654321;
	
	public static void dijkstra(int c) {
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(c, 0));
		dp[c] = 0;
		Node node = null;
		while(!pq.isEmpty()) {
			
			node = pq.poll();
			int curIdx = node.idx;
			int curSec = node.sec;
			
			if(curSec > dp[curIdx])continue;
			for(int i = 0 ; i< aList[curIdx].size(); i++) {
//				System.out.println(aList[curIdx].get(i).idx + "  " + curIdx);
				if(dp[aList[curIdx].get(i).idx] > curSec + aList[curIdx].get(i).sec) {
					dp[aList[curIdx].get(i).idx] = curSec + aList[curIdx].get(i).sec;
					pq.add(new Node(aList[curIdx].get(i).idx,dp[aList[curIdx].get(i).idx]));
				}
			}
			
			
		}
		
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t != 0 ) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dp = new int[n+1];
			aList = new ArrayList[n+1];
			
			Arrays.fill(dp, INF);
			for(int i = 0 ; i < n+1; i++) {
				aList[i] = new ArrayList<Node>();
			}
			
			for(int i = 0 ; i < d ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				aList[b].add(new Node(a, s));
			}
			
			dijkstra(c);
			int cnt = 0;
			int result = 0;
      // 값이 변했으면 count ++
      // 최대 값은 감염 마지막
			for(int i = 1 ; i <= n ; i++) {
				if(dp[i] != INF) {
					cnt++;
					result = Math.max(dp[i], result);
				}
			}
			System.out.println(cnt + " " + result);
			t--;
			
		}
		
	}
}
