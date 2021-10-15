import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int idx;
	int end;
	
	public Node(int idx, int end) {
		this.idx = idx; 
		this.end = end;
	}
	
	public int compareTo(Node o) {
		return this.end - o.end;
	}
}

class Time implements Comparable<Time>{
	int start;
	int end;
	
	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int compareTo(Time o) {
		return this.start - o.start;
	}
}

class Main {
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(); // 인덱스값과 종료시간
		PriorityQueue<Time> pqTime = new PriorityQueue<Time>(); // 시작시간과 종료시단
		int[] people = new int[100001];		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			pqTime.add(new Time(start,end));
		}
		
		PriorityQueue<Integer> indexQ = new PriorityQueue<Integer>();
		int idx = 1;
		while(!pqTime.isEmpty()) {
			Time t = pqTime.poll();
			
			while(!pq.isEmpty() && pq.peek().end <= t.start) {
				Node node = pq.poll();
				indexQ.add(node.idx);
			}
			
			if(!indexQ.isEmpty()) {
				int pollValue = indexQ.poll();
                people[pollValue]++;
                pq.offer(new Node(pollValue,t.end));
			}else {
				people[idx]++;
				pq.offer(new Node(idx++, t.end));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		for(int j = 1 ; j <= 100000; j++ ) {
			if(people[j] == 0) {
				break;
			}
			answer++;
			sb.append(people[j]+" ");
		}
		
		System.out.println(answer);
		System.out.println(sb);

    }
  
}
