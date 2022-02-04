import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, Integer> numbers;
    static int k;

  // 새로 추가되는 값으로 인해 k 초과 값이 들어오는 경우 제외
    public static boolean checkNumberUnderK(int curNum) {
        if (numbers.getOrDefault(curNum, 0) == k) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] numArr = new int[n];
        numbers = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int answer = 0;
        numbers.put(numArr[left], 1);

        while (right < n) {
            if(checkNumberUnderK(numArr[right])) {
                numbers.put(numArr[right], numbers.getOrDefault(numArr[right], 0) + 1 );
                answer = Math.max(answer, right - left + 1);
                right++;
            } else {
                if (numbers.getOrDefault(numArr[left], 0) > 0 ) {
                    numbers.put(numArr[left], numbers.get(numArr[left]) - 1 );
                }
                left++;
            }
        }

        System.out.println(answer);



    }
}
