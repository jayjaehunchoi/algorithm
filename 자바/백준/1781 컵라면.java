import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node implements Comparable<Node>{
	int dL;
	int cup;
	
	public Node(int dL, int cup) {
		this.dL = dL;
		this.cup = cup;
	}
	
	public int compareTo(Node o) {
		int res;
		if(this.dL - o.dL < 0)res = -1;
		else if(this.dL == o.dL) {
			if(this.cup - o.cup < 0)res = 1;
			else if(this.cup == o.cup) res = 0;
			else res = -1;
		}else res = 1;
		return res;
	}
}
class Main {
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
      
      // 제한 시간 순 정렬
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dL = Integer.parseInt(st.nextToken());
			int cup = Integer.parseInt(st.nextToken());
			pq.add(new Node(dL,cup));
		}
		long answer = 0;
		
		// 제한 시간보다 많은 작업이 cupQ에 들어있으면 cupQ에서 가장 작은 값 제거.
		PriorityQueue<Integer> cupQ = new PriorityQueue<Integer>();
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dL = node.dL;
			int cup = node.cup;
			cupQ.add(cup);
			while(cupQ.size() > dL)cupQ.poll();
			//System.out.println(cupQ);
		}
		while(!cupQ.isEmpty()) {
			answer += cupQ.poll();
		}
		
		System.out.println(answer);

    }
  
}
