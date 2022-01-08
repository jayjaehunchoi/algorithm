import java.io.*;
import java.util.StringTokenizer;

// n장의 카드를 구매하는 방법
// n장짜리 카드를 한 번에 구매하거나, n-i 장의 카드 구매 중 최대 값과 i장의 카드를 구매하는 방법이 있음

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[n]);
    }


}
