import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] numbers;
    static Integer[] toRightDp;
    static Integer[] toLeftDp;

  // 순방향으로 증가하는 수열인지 탐색
    static int forward(int curIndex) {
        if (toRightDp[curIndex] == null) { //이미 해당 인덱스에 값이 존재하면 더이상 재귀 돌릴 필요 없음 (안그러면 무한재귀)
            toRightDp[curIndex] = 1;

            for (int i = curIndex - 1; i >= 0; i--) {
              
              // 자기 이전수부터 0까지 탐색하면서 현재 인덱스의 수보다 작은 수가 있다면 증가, 재귀 실행
                if(numbers[curIndex] > numbers[i]) {
                    toRightDp[curIndex] = Math.max(toRightDp[curIndex], forward(i) +1);
                }
            }
        }
        return toRightDp[curIndex];
    }

  // 역방향으로 증가하는 수열인지 탐색
    static int reverse(int curIndex) {
        if (toLeftDp[curIndex] == null) {
            toLeftDp[curIndex] = 1;

          // 위 forward 메서드와 동일함
            for (int i = curIndex + 1; i < toLeftDp.length; i++) {
                if (numbers[curIndex] > numbers[i]) {
                    toLeftDp[curIndex] = Math.max(toLeftDp[curIndex], reverse(i) + 1);
                }
            }
        }

        return toLeftDp[curIndex];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        toRightDp = new Integer[n];
        toLeftDp = new Integer[n];
        for (int i = 0; i < n; i++) {
            forward(i);
            reverse(i);
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(toLeftDp[i] + toRightDp[i], max);
        }

        System.out.println(max - 1); // 숫자 하나가 겹치기 때문에 해당 작업 진행

    }
}
