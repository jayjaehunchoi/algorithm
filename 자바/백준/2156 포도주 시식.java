import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];

        for (int i = 2; i < n + 1; i++) {
            if(i == 2) {
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]); // 2번째의 경우, 연속 두개의 합과 자기 자신 홀로의 값 중 큰 값
            }else if(i == 3) {
                dp[i] = Math.max(Math.max(dp[2], arr[i - 2] + arr[i]), arr[i-1] + arr[i]); // 3번째의 경우 연속 세개를 마실 수 없기 때문에 이전 수 까지의 최대값, 1/3 합, 2/3 합 중 최대 값
            }else {
                dp[i] = Math.max(Math.max(dp[i - 3] + arr[i] + arr[i - 1], dp[i - 2] + arr[i]), dp[i-1]); // 이후 부터는 연속 세개를 제외하고 최대 값
            }
        }

        System.out.println(dp[n]);

    }


}
