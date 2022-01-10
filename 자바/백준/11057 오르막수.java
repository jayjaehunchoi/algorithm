import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

      // 각 자리별로 몇개씩 들어올 수 있는지 확인한다.
      // 2자리 수 중 1번째 자리가 0일경우 10개의 숫자가 모두 들어올 수 있다.
      // 이를 공식화 하여 아래처럼 표현 가능하다.
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k] % 10007;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i] % 10007;
        }

        System.out.println(answer % 10007);



    }


}
