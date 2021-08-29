import java.util.Scanner;

class Main {
	static int[][] dp = new int[30][30];
	
  // nCr = n-1Cr-1 + n-1Cr
  // 반복 돌리면서아래로 .... r == 0 혹은 n == r 이면 1 넣고
  // dp에 넣어주면서 계속 더해 올라가기 > 최종적으로 값 나옴.
  // 조합 DP
	public static int comb(int n, int r) {
		
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		if(n == r || r == 0) {
			return 1;
		}
		
		return dp[n][r] = comb(n-1, r-1) + comb(n-1,r);
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0 ; i < T ; i++) {
			int r = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(comb(n,r));
		}

	}

}

	

