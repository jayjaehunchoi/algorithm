import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	


    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] times = new int[n+1];
		int[] cnts = new int[n+1];
		
		List<Integer>[] aList = new ArrayList[n+1];
		for(int i = 0 ; i <= n ; i++ ) {
			aList[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			times[i+1] = Integer.parseInt(st.nextToken());
			while(true) {
				int prior = Integer.parseInt(st.nextToken());
				if(prior == -1) {
					break;
				}
				cnts[i+1]++;
				aList[prior].add(i+1);
			}
		}
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 1 ; i <= n ; i++) {
			if(cnts[i] == 0) {
				que.add(i);
				dp[i] = times[i];
			}
		}

		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int i = 0; i < aList[cur].size(); i++ ) {
				int next = aList[cur].get(i);
				cnts[next]--;
				dp[next] = Math.max(dp[next], times[next] + dp[cur]);
				
				if(cnts[next] == 0) {
					que.add(next);
				}
			}
		}
		for(int i = 1; i <= n ; i++) {
			System.out.println(dp[i]);
		}

    }
}
