import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        boolean flag = false;

        while (true) {
            long diff = (long) (Math.pow(right, 2) - Math.pow(left, 2));

          // 차이가 g를 초과하면서 원래 값은 1밖에 차이나지 않는 경우는 더이상 g만큼의 차이가 날 수 없다.
            if(diff > g && right - left == 1) {
                break;
            }

            if(diff >= g) {
                left++;
            } else {
                right++;
            }

            if(diff == g) {
                System.out.println(right);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }

    }
}
