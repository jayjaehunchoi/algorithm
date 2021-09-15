import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] arr;
	static int[] dp;
	public static void dyna(int n) {
		int max = 0;
    
    // 반복문을 돌며 자신보다 작은값을 찾되, 최대값일때 +1;
		for(int i = n-1; i >= 0 ; i--) {
			if(arr[n] > arr[i]) {
				if(dp[i] > max) {
					max = dp[i];
					dp[n] = dp[i]+1;
//					System.out.println(n + " " + dp[n]);
				}
			}
		}
		if(dp[n] == 0) {
			dp[n] = 1;
		}	
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n];
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		int max = dp[0];
		for(int i = 1; i < n ; i++) {
			dyna(i);
			max = Math.max(max, dp[i]);		
		}
		System.out.println(max);
	}
}
