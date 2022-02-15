import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[][] boards;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y, int count, int sum) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, count + 1, sum + boards[nx][ny]);
            visited[nx][ny] = false;
        }
    }

  // ㅜ 모양에 대한 내용 추가 (dfs)로 커버가 안됨
    static void checkSpecialShape(int x, int y) {
        if (x + 2 < n && y + 1 < m) {
            answer = Math.max(answer, boards[x][y] + boards[x + 2][y] + boards[x + 1][y] + boards[x + 1][y + 1]);
        }

        if (x + 2 < n && y > 0) {
            answer = Math.max(answer, boards[x][y] + boards[x + 2][y] + boards[x + 1][y] + boards[x + 1][y - 1]);
        }

        if (x + 1 < n && y + 2 < m) {
            answer = Math.max(answer, boards[x][y] + boards[x][y + 1] + boards[x][y + 2] + boards[x + 1][y + 1]);
        }

        if (x > 0 && y + 2 < m) {
            answer = Math.max(answer, boards[x][y] + boards[x][y + 1] + boards[x][y + 2] + boards[x - 1][y + 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boards = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, boards[i][j]);
                visited[i][j] = false;
                checkSpecialShape(i, j);
            }
        }

        System.out.println(answer);

    }
}
