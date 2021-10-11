import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int n,m,k,answer;
	static int[] costs;
	static int[] parents;
	static int[] rank;
  
  // root 노드 찾기
	public static int find(int a) {
		if(parents[a] == a)return a;
		return parents[a] = find(parents[a]);
	}
	
  // root 비교
	public static void unionFind(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rank[rootA] < rank[rootB]) {
			parents[rootA] = rootB;
		}else {
			parents[rootB] = rootA;
			if(rank[rootA] == rank[rootB]) {
				rank[rootA]++;
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		costs = new int[n+1];
		parents = new int[n+1];
		rank = new int[n+1];
		
		for(int i = 1 ; i <= n; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
			parents[i] = i;
		}
		answer = 0;
		
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			
			if(find(f1) != find(f2)) {
				unionFind(f1, f2);
			}
		}

		int[] min =new int[n+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		for(int i = 1; i <= n ; i++) {
			int group = find(i);
			
			min[group] = Math.min(min[group], costs[i]);
		}
		
		for(int i = 1; i <= n; i++) {
			if(min[i] != Integer.MAX_VALUE) {
				answer += min[i];
			}
			if(answer > k) {
				System.out.println("Oh no");
				return;
			}
		}	
		System.out.println(answer);
    }
  
}
