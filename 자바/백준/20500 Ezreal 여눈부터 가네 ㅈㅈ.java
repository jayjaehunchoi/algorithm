import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
			System.out.println(0);
			return;
		}
		
     // 정수론 15배수의 특징은?
     // 3의 배수와 , 5의 배수 공통으로 갖고 있어야함
     // 3의 배수는 자릿수의 합이 3배수
     // 5 배수는 끝자리가 0 혹은 5
		long[][] dp = new long[3][n+1];
		// 여기서 끝자리 5 아닌 값 걸러줌
    dp[0][2] = 1;
		dp[1][2] = 1;
		dp[2][2] = 0;
		
      // i자리수일때 나머지 0인 수 만들려면 , 나머지 1인 수에 끝자리 5 더한 값 + 나머지 2인 수에 앞쪽에 1 더한값
		for(int i = 3 ; i < n+1; i++) {
			dp[0][i] = (dp[1][i-1] + dp[2][i-1])%1000000007;
			dp[1][i] = (dp[0][i-1] + dp[2][i-1])%1000000007;
			dp[2][i] = (dp[0][i-1] + dp[1][i-1])%1000000007;
		}
		
		System.out.println(dp[0][n]);
		
	}
}

