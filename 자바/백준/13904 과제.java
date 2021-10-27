import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int day;
	int cost;
	
	public Node(int day, int cost) {
		this.day = day;
		this.cost = cost;
	}
	
	public int compareTo(Node n) {
		return this.day - n.day;
	}
	
}

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
    // 일자 순 정렬
		PriorityQueue<Node> nodeQ = new PriorityQueue<Node>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodeQ.add(new Node(day, cost));
		}
		
    // 작업 que에 삽입
    // 만약 day보다 크면 poll
		PriorityQueue<Integer> workQ = new PriorityQueue<Integer>();
		while(!nodeQ.isEmpty()) {
			Node node = nodeQ.poll();
			int day = node.day;
			int cost = node.cost;
			workQ.add(cost);
			if(workQ.size() > day)workQ.poll();
			
		}
		int answer = 0;
		while(!workQ.isEmpty()) {
			answer += workQ.poll();
		}
		System.out.println(answer);
		
	}
} 
