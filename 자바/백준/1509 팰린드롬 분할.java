import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
   static boolean[][] pDrom;
   static int[] dp;

  // 문자열 전체 경우의 수를 돌며 , 팰린드롬인지 아닌지 확인 
   public static void checkPalin(String str) {
       for (int i = 1; i < pDrom.length; i++) {
           for (int j = i; j < pDrom.length; j++) {
                boolean flag = true;

                int start = i - 1;
                int end = j - 1;
                while (start <= end) {
                    if(str.charAt(start++) != str.charAt(end--)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    pDrom[i][j] = true;
                }
           }
       }
   }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();

        pDrom = new boolean[length + 1][length + 1];
        dp = new int[length + 1];
        for (int i = 1; i < length + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        checkPalin(str);

      // j부터 i가 팰린드롬일 경우 현재 dp와 이전까지의 dp 값 + 1을 비교하여 최소값 탐색
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if(pDrom[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        System.out.println(dp[length]);

    }

}
