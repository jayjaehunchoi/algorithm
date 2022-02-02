import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
      
      // n의 값이 1보다 작을 경우 1 출력 후 종료
        if(n <= 1) {
            System.out.println(1);
            return;
        }
        int[] tCount = new int[n + 1];
        int[] triangle = new int[n + 1];

      // 삼각형과 정사면체 각 개수
        triangle[1] = 1;
        triangle[2] = 3;
        tCount[1] = 1;
        tCount[2] = 4;

        for (int i = 3; i <= n; i++) {
            triangle[i] = triangle[i - 1] + i;
            tCount[i] = triangle[i] + tCount[i - 1];
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                if(tCount[j] > i) break;
                dp[i] = Math.min(dp[i], dp[i - tCount[j]] + 1);
            }
        }
        System.out.println(dp[n]);


    }
}
