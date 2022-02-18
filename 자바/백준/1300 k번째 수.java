import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = k;

        while (left < right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i); // mid보다 같거나 작은 수 탐색
            }

            if (count >= k) { // 범위 줄이기
                right = mid;
            } else { // left 높여서 mid 높이기
                left = mid + 1;
            }
        }

        System.out.println(left);

    }
}
