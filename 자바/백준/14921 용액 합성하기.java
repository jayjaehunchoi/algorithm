import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] solutions = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n - 1;

        int answer = Integer.MAX_VALUE;
      
      // 투 포인터, 절대값으로 값 비교
        while (start < end) {
            int tempVal = solutions[start] + solutions[end];

            if(Math.abs(tempVal) < Math.abs(answer)) {
                answer = tempVal;
            }
            if(tempVal > 0) {
                end--;
            }else {
                start++;
            }
        }

        System.out.println(answer);
    }
}
