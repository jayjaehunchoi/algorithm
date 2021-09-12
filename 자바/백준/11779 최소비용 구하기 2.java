import java.util.*;
import java.io.*;


// 최소경로가 여러개일때 어떻게 해야하는지 도저히 감이안와서
// 질문을 보니 스페셜 저지(최소경로 아무거나 출력 가능)가 있는 문제였다
class Node implements Comparable<Node>{
	
	int idx;
	int cost;
	int wayCount;
	List<Integer> ways = new ArrayList<>();
	public Node(int idx, int cost, int wayCount) {
		this.idx = idx;
		this.cost = cost;
		this.wayCount = wayCount;
	}
	
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
}
class Main {
	static int dp[];
	static List<Node>[] aList;
	static final int INF = 1000000001;
	public static Node dijkstra(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(); // 최소경로 구하는 용도
		PriorityQueue<Node> pq2 = new PriorityQueue<Node>(); // 도착했을때 최소 경로를 가진 노드 출력용
		pq.add(new Node(x, 0, 1));
		dp[x] = 0;
		Node node = null;
		while(!pq.isEmpty()) {
			
			node = pq.poll();
			
			int curCost = node.cost;
			int curIdx = node.idx;
			
			if(curCost>dp[curIdx])continue;
			if(curIdx == y) {
				pq2.add(node);
			}
			for(int i = 0; i < aList[curIdx].size(); i++) {

				if(dp[aList[curIdx].get(i).idx] > curCost +aList[curIdx].get(i).cost) {
					dp[aList[curIdx].get(i).idx] = curCost + aList[curIdx].get(i).cost;
					Node n = new Node(aList[curIdx].get(i).idx, dp[aList[curIdx].get(i).idx], node.wayCount+1);
					n.ways.addAll(node.ways);
					n.ways.add(aList[curIdx].get(i).idx);
					pq.add(n);
				}
			}
			
		}
		return pq2.poll();
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m  = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];
		aList = new ArrayList[n+1];
		
		Arrays.fill(dp, INF);
		for(int i = 0 ; i < n+1 ; i++) {
			aList[i] = new ArrayList<Node>();
		}

		for(int i = 0 ; i < m ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int eachCost = Integer.parseInt(st.nextToken());
			aList[start].add(new Node(end, eachCost, 1));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int srt = Integer.parseInt(st.nextToken());
		int drt = Integer.parseInt(st.nextToken());
		Node node= dijkstra(srt, drt);
		System.out.println(dp[drt]);
		System.out.println(node.wayCount);
		System.out.print(srt+" ");
		for(int i : node.ways) {
			System.out.print(i+" ");
		}
	}
}
