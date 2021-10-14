import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 일반적인 그래프 dfs로 풀이하면 시간초과

class Main {
	static int[] teams;
	static int answer;
	static boolean[] check;
	static boolean[] done;
	
	private static void dfs(int v) {
		
    // check도 방문처리했는데, done으로 다시 방문했다는 의미 (다시 본인에게 돌아왔다.)
    if(check[v]) {
			done[v] = true;
			answer++;
		}else {
			check[v] = true;
		}
		
		if(!done[teams[v]]) {
			
			dfs(teams[v]);
		}
		check[v] = false; 
		done[v] = true;
	}
	
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			answer = 0;
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			done = new boolean[n+1];
			teams = new int[n+1];
			check = new boolean[n+1];
			
			for(int i = 1 ; i <= n; i++) {
				int val = Integer.parseInt(st.nextToken());
				teams[i]=val;
			}
			
			for(int i = 1; i <= n ; i++) {
				
				if(!done[i]) {
					dfs(i);
				}
			}
			
			System.out.println(n-answer);
			
			
		}
		
    }
}
