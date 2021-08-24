
import java.util.Scanner;

class Main {
	
		
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] stairs = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			stairs[i] = sc.nextInt();
		}
		
		dp[0] = 0;
		dp[1] = stairs[1];
		
		if(n == 1) {
			System.out.println(dp[1]);
			return;
		}
		
		dp[2] = stairs[1] + stairs[2]; 
		
    // 조건에 부합하는 최대값을 계속 찾아가며 더해주면 됨.
		for(int i = 3; i < stairs.length; i++) {
			
			dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
			
			
		}
		System.out.println(dp[n]);
	}

}
	

