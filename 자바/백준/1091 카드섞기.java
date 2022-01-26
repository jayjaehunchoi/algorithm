import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int p[] = new int[n]; // 최종 위치
        int s[] = new int[n]; // 섞을 때마다 이동하는 위치
        int cards[] = new int[n]; // 카드 덱

     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            cards[i] = i % 3; // 카드 배열은 0, 1, 2 ~
        }

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int cycledCard[] = cards.clone(); // 최초의 카드 상태로 돌아온다는 것은 반복되는 싸이클이 있다는 뜻
        int answer = 0;
        while (!Arrays.equals(cards, p)) { // 카드가 최종 위치로 도달했는지?
            int temp[] = cards.clone();
            for (int i = 0; i < n; i++) {
                cards[i] = temp[s[i]];
            }
            if (Arrays.equals(cards, cycledCard)) { // 반복 지점이 있는지?
                System.out.println(-1);
                return;
            }

            answer++;
        }
        System.out.println(answer);

    }

}
