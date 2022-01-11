import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
      
      // 경우의 수를 계산해보면 두개 전의 2배와  한개 전을 합한 값을 점화식으로 세울 수 있다.
        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }
        
        System.out.println(dp[n]);

    }
    
}
