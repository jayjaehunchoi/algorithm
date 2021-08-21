// 동적프로그래밍을 통한 풀이만 시간초과 해결 가능

import java.util.Scanner;

class Main {
	
	static int[] dp;

  // 위에서부터 재귀를 돌리면서, 아랫값을 하나씩 찾아간다.
  // 2일때 1이되는값 ... 머요런식으로
	public static int find1(int n) {
		
		if(n==1) {
			return 0;
		}
		if(dp[n] > 0) {
			return dp[n];
		}
		
		int r1 = Integer.MAX_VALUE;
		int r2 = Integer.MAX_VALUE;
		int r3 = Integer.MAX_VALUE;
		
		if(n%2 == 0) {
			r1 = find1(n/2)+1;
		}
		if(n%3 == 0) {
			r2 = find1(n/3)+1;
		}
		r3 = find1(n-1)+1;

		return dp[n] = Math.min(Math.min(r1, r2), r3);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		
		System.out.println(find1(n));
		
	}

}
	

