import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
    // 최대 dp 경우의수
		int[] days = new int[n+6];
		int[] costs = new int[n+6];
		int[] dp = new int[n+6];
		int max = 0;

		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			days[i] = day;
			costs[i] = cost;
		}
		
    // 덧셈상 만약 최대 일수가 10이라면 11까지 허용
		for(int i = 1; i <= n+1 ; i++) {
			dp[i] = Math.max(dp[i],max);	
			dp[days[i]+i] = Math.max(dp[days[i]+i], costs[i] + dp[i]);
			max = Math.max(dp[i], max);
			
			
		}
		System.out.println(max);
		
	}
} 
