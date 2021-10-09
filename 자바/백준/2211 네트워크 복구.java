import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node implements Comparable<Node>{
	
	int x;
	int y;
	int dist;
	
	public Node(int x,int y, int dist) {
		this.x= x;
		this.y = y;
		this.dist =dist;
	}

	@Override
	public int compareTo(Node o) {
		return this.dist - o.dist;
	}

	@Override
	public String toString() {
		return "Node [y=" + y + ", dist=" + dist + "]";
	}
	
	
	
}
class Main {
	static List<Node>[] aList;
	static int[] dp;
	static List<int[]> answerList = new ArrayList<int[]>();
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1,1,0));
		dp[1]=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int idx = node.y;
			int dist = node.dist;
			if(dp[idx] < node.dist)continue;
      // 조건을 막 통과한 네트워크 중 compare 조건을 맞춘 네트워크 정답 리스트에 추가
			if(compare(node.x, idx) && node.x != idx) {
				answerList.add(new int[]{node.x, idx});
			}
			for(int i = 0 ; i < aList[idx].size(); i++) {
				if(dp[aList[idx].get(i).y] > dist + aList[idx].get(i).dist) {
					dp[aList[idx].get(i).y] = dist + aList[idx].get(i).dist;
					pq.add(new Node(idx,aList[idx].get(i).y,dp[aList[idx].get(i).y] ));
				}
			}
		}
	}
	
  // 이미 들어있는 배열인지 비교 (사실 없어도 될것 같긴함)
	public static boolean compare(int idx, int y) {
		
		if(answerList.size() == 0) {
			return true;
		}
		for(int i = 0 ; i < answerList.size(); i++) {
			int cnt = 0;
			if(answerList.get(i)[0] == idx || answerList.get(i)[0] == y) {
				cnt++;
			}
			if(answerList.get(i)[1] == idx || answerList.get(i)[1] == y) {
				cnt++;
			}
			if(cnt == 2) {
				return false;
			}
		}
		return true;
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1];
		aList = new ArrayList[n+1];
		
		Arrays.fill(dp,Integer.MAX_VALUE);
		for(int i = 0 ; i <= n ; i++) {
			aList[i] = new ArrayList<Node>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			aList[x].add(new Node(x,y,dist));
			aList[y].add(new Node(y,x,dist));
		}
		
		dijkstra();
		System.out.println(answerList.size());
		for(int i = 0 ; i < answerList.size(); i++) {
			System.out.println(answerList.get(i)[0] + " " + answerList.get(i)[1] );
		}
    }
  
}
