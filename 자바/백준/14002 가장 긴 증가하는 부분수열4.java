import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] sequence;
    static int[] dp;

  // 재귀를 이용하여 증가하는 부분수열 탐색
    static int toForward(int cur) {
        if(dp[cur] == 0) {
            dp[cur] = 1;

            for (int i = cur - 1 ; i >= 0; i--) {
                if(sequence[cur] > sequence[i]) {
                    dp[cur] = Math.max(dp[cur], toForward(i) + 1);
                }
            }
        }

        return dp[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sequence = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            toForward(i);
        }

        int max = -1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        sb.append(max + "\n");

        int compare = max;
        Stack<Integer> stack = new Stack<>();
      
      // dp와 비교하여 max값과 같은 순간부터 하나씩 빼가며 해당 인덱스의 값을 스택에 담는다
        for (int i = n - 1; i >= 0; i--) {
            if (compare == dp[i]) {
                stack.push(sequence[i]);
                compare--;
            }
        }

      // 스택에 가장 나중에 들어온 순서대로 빼내어 출력한다.
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());

    }
}
