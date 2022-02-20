import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        dp[0] = 1;

      // 홀수는 절대 채울 수 없음
        for (int i = 2; i <= n; i = i + 2) {
            dp[i] = 3 * dp[i - 2]; // 일반적인 경우
            for (int j = 0; j < i - 2; j = j + 2) {
                dp[i] = dp[i] + dp[j] * 2;
            }
        }

        System.out.println(dp[n]);

    }
}
