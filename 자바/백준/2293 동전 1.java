
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
		
		dp[0] = 1;
		
    // n으로 k만들기 경우의 수는, n-1개로 k 만들기 + n개로 k-동전 만들기 
		for(int i = 0 ; i < n; i++) {
			int coin = coins[i];
			for(int j = 1 ; j < k+1 ; j++) {
				if(j >= coin) {
					dp[j] += dp[j-coin];
				}
				
			}
		}
		System.out.println(dp[k]);
		
	}

}
	

