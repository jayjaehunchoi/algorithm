import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] cost = new int[n+1];
			int[] dp = new int[n+1];
			st = new StringTokenizer(br.readLine(), " ");

			for(int i = 1 ; i <= n; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			List<List<Integer>> craft = new ArrayList<>();
			for(int i = 0 ; i <=n; i++) {
				craft.add(new ArrayList<Integer>());
			}
      
      // 위상정렬, 이걸 사용하기전에는 que에 모든 자식노드가 들어가서 예시 답안은 맞지만 8퍼센트에서 메모리 초과가 계속 났다.
			int[] indegree = new int[n+1];
			
			for(int i = 0 ; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int par = Integer.parseInt(st.nextToken());
				int chi = Integer.parseInt(st.nextToken());;

				craft.get(par).add(chi);
        
        // 자식 노드로 등장할 때마다 값 ++ (이 뜻은 모든 부모노드가 다 제작돼야 자식노드로 넘어갈 수 있다는 뜻)
				indegree[chi]++;
			}
			
			Queue<Integer> que = new LinkedList<>();
			
      // 기본값 설정 및, 부모노드 혹은 자식노드로 등장하지 않은 수 추가
			for(int i=1; i<=n; i++) {
	            dp[i] = cost[i];
	 
	            if(indegree[i] == 0)
	                que.add(i);
	        }
			
			while(!que.isEmpty()) {
				int val = que.poll();
				
        // 조건에 맞으면 que에 추가
				for(int chi : craft.get(val)) {
					dp[chi] = Math.max(dp[chi], dp[val]+cost[chi]);
					indegree[chi]--;
					
					if(indegree[chi] == 0) {
						que.add(chi);
					}
				}	
			}
			
			int target = Integer.parseInt(br.readLine());

			sb.append(dp[target]+"\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
    }
  
}
