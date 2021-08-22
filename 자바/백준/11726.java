
import java.util.Scanner;

class Main {
	
  // 규칙성이 있는 문제임
	public static int tiling(int[] dp, int k ) {
		
		for(int i = 3 ; i <= k ; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
	
		return dp[k]%10007;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		System.out.println(tiling(dp,n));
		
	}

}
	

