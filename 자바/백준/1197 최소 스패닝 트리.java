import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 프림알고리즘, 간선 거리 최소로 판단하는 알고리즘
class Node implements Comparable<Node>{
	int target;
	int cost;
	
	public Node(int target, int cost) {
		this.target = target;
		this.cost = cost;
	}
	
	public int compareTo(Node n) {
		return this.cost - n.cost;
	}
	
}

class Main {
	static int v;
	static int e;
	static List<Node>[] nodes;
	public static long prim() {
		boolean[] visited  = new boolean[v+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1,0));
		
		long res = 0;
		int count = 0;
		
    // 항상 방문노드를 확인할 것
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.target])continue;
			res += node.cost;
			visited[node.target] = true;
			count++;
      // 타겟 노드 확인
			for(int i = 0 ; i < nodes[node.target].size(); i++) {
				Node next = nodes[node.target].get(i);
				if(visited[next.target])continue;
				pq.add(next);
			}
		}
		return res;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		nodes = new ArrayList[v+1];
		
		for(int i = 0 ; i <= v; i++ ) {
			nodes[i] = new ArrayList<Node>();
		}
		
		for(int i = 0 ; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes[a].add(new Node(b,c));
			nodes[b].add(new Node(a,c));
		}
		System.out.println(prim());
		
	}
} 
