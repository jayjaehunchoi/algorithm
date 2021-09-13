import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		for(int i = 1 ; i <= n ; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(dp);
		int ans = 0;
		for(int i = 1 ; i <= n ; i++) {
			
			dp[i] = dp[i-1] +  dp[i];
			ans+=dp[i];
		}
		System.out.println(ans);
		
		
	}
}
