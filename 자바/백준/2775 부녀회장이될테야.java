import java.util.Scanner;

class Main {
	static int[][] dp = new int[15][15];
	public static void dyna() {
		
		for(int i = 1; i < 15; i++) {
			for(int j = 1 ; j < 15; j++) {
				
				for(int k = 1; k <= j; k++) {
					dp[i][j] += dp[i-1][k]; 
				}
			}
		}	
	}
	
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 1 ; i < 15; i++) {
			dp[0][i] = i;
		}
		dyna();
		while(t-- > 0) {	
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(dp[k][n]);
			
		}

	}
}
