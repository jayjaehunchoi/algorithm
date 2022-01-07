import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
      
      // 최소값은 -1000
        dp[0] = -1001;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
      
      // 연속합, 본인 자신 중 가장 큰값으로 계속 대체
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

      // 최대 값
        Arrays.sort(dp);
        System.out.println(dp[n]);

    }
}
