import java.io.*;

class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

      // dp 생성
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;

            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        System.out.println(dp[n]);
        print(n);

    }

  // 주어진 수의 dp로부터 하나씩 작은 수들을 출력
    public static void print(int num) {
        if(num == 0) {
            return;
        }

        System.out.print(num + " ");

        if(num - 1 >= 0 && dp[num - 1] == dp[num] - 1){
            print(num - 1);
        }else if(num % 3 == 0 && dp[num / 3] == dp[num] - 1){
            print(num / 3);
        }else if(num % 2 == 0 && dp[num / 2] == dp[num] - 1){
            print(num / 2);
        }

        return;
    }

}
