import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int n,m;
	static int[] indegree;
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		indegree = new int[n+1];
		List<List<Integer>> aList = new ArrayList<List<Integer>>();
		for(int i = 0 ; i < n+1; i++) {
			aList.add(new ArrayList<Integer>());
		}
		
		// 위상정렬
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			aList.get(parent).add(child);
			indegree[child]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		List<Integer> answers = new ArrayList<Integer>();
		for(int i =1 ; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				pq.add(i);
			}
		}
    // 자식노드인 마지막 순간 que에 add해준다. 
		while(!pq.isEmpty()) {
			int val = pq.poll();
			if(!answers.contains(val)) {
				answers.add(val);
			}
			for(int j : aList.get(val)) {
				indegree[j]--;
				if(indegree[j]==0) {
					pq.add(j);
				}
				
			}
		}
		for(int i = 0 ; i < answers.size(); i++) {
			System.out.print(answers.get(i)+" ");
		}
		
    }
  
}
