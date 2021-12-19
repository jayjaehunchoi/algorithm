import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

      // 가장 긴 오름차순은 그대로 유지, 아닌 숫자들만 바꿔주면 됨.
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(n-dp[n]);
    }

}
