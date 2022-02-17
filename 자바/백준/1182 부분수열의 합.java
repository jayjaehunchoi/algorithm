import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> aList = new ArrayList<>();
    static int answer = 0;
    static int n, s;

    static void dfs(int idx, int tempSum) {
        if (idx == n) {
            if (tempSum == s) {
                answer++;
            }
            return;
        }

      // 현재 값을 더하는 경우, 더하지 않는 경우 모두 재귀로 탐색
        dfs(idx + 1, tempSum + aList.get(idx));
        dfs(idx + 1, tempSum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            aList.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);
        if (s == 0){
            answer--;
        }
        
        System.out.println(answer);

    }
}
