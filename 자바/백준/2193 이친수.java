import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

      // 0은 연속으로 나올 수 있고, 1 다음으로 나올 수도 있음 -> 따라서 이전 자릿수의 마지막이 0, 1인 경우를 합한 경우가 0번칸에 들어감
      // 1은 연속으로 나올 수 없음, 따라서 이전 자릿수의 마지막이 0인 경우가 그대로 1번 칸에 들어감
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j <= 1; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][0] + dp[i - 1][1];
                }
                if(j == 1) {
                    dp[i][1] = dp[i - 1][0];
                }
            }
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}
