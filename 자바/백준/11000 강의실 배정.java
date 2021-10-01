import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Node implements Comparable<Node>{
	int s;
	int t;
	
	public Node(int s, int t) {
		this.s = s;
		this.t = t;
	}
	
	public int compareTo(Node o) {
		return this.t - o.t;
	}
}

class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[][] arr =new int[n][2];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[i][0] = s;
			arr[i][1] = t;
		}
		
		Arrays.sort(arr, (a,b) -> a[0] - b[0] );
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i = 0 ; i < n ; i++) {
			if(pq.isEmpty()) {
				pq.add(new Node(arr[i][0] , arr[i][1]));
			}else {
				if(pq.peek().t <= arr[i][0]) {
					pq.poll();
					pq.add(new Node(arr[i][0], arr[i][1]));
				}else {
					pq.add(new Node(arr[i][0], arr[i][1]));
				}
			}
		}
		System.out.println(pq.size());
		
     	
    }
  
}
