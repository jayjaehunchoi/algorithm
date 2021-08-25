

import java.util.Scanner;

class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coins = new int[n];
		int[] dp = new int [100001];
		for(int i = 0 ; i < n ; i++) {
			coins[i] = sc.nextInt();
		}
		for(int i = 0 ; i < 10002; i++) {
			dp[i] = 10001;
		}
		dp[0] = 0;
		
		
		for(int i = 0 ; i < n; i++) {
			int coin = coins[i];
			for(int j = 1 ; j < k+1 ; j++) {
				if(j >= coin ) {
					dp[j] = Math.min(dp[j], dp[j-coin]+1);
				}
				
			}
		}
		
		if(dp[k] == 10001) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[k]);
		}

	}

}
	

