import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[100001][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        int n = Integer.parseInt(br.readLine());

      // 새로운 줄이 추가될때마다 값이 더해지는 형태
      // 공백은 이전 전체 경우의 수를 모두 합한 값이고, 좌, 우를 나누어 좌측에 배치하는 경우는 이전에 공백 우측인경우 그 반대는 반대로 생각하여 점화식을 짜면 된다.
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        int answer = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
        System.out.println(answer);
    }

}
