import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[201][201]; // 이거 왜 k+1. n+1 로 하면 outofIndex나오는지 모르겠다,,,,, 나올 수 가 없을것같은데
		
		for(int i = 1 ; i <= 2 ; i++) {
			for(int j = 0 ; j < 201 ; j++) {
				
				if(i == 1) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = j+1;
				}
			}
		}
		
		if(k <= 2) {
		}else {
			for(int i = 3; i < 201; i++) {
				System.out.println();
				for(int j = 0; j < 201; j++) {
					if(j==0) {
						dp[i][j] = 1;
					}else {
						dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
					}
				}
			}
			
			System.out.println(dp[k][n]);
		}
		
	}
}
