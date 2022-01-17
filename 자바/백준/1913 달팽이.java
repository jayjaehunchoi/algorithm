import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] snail = new int[n][n];

        int curVal = n * n;

        int curX = 0;
        int curY = 0;
        int flag = 0;

        int ansX = 0;
        int ansY = 0;
        while (curVal > 0) {
            if(flag == 0) {
                snail[curX++][curY] = curVal--;
                if(curX == n || snail[curX][curY] != 0) {
                    curX--;
                    curY++;
                    flag++;
                }
            }else if(flag == 1) {
                snail[curX][curY++] = curVal--;
                if(curY == n || snail[curX][curY] != 0) {
                    curY--;
                    curX--;
                    flag++;
                }
            }else if(flag == 2) {
                snail[curX--][curY] = curVal--;
                if(curX == -1 || snail[curX][curY] != 0) {
                    curX++;
                    curY--;
                    flag++;
                }
            }else if(flag == 3) {
                snail[curX][curY--] = curVal--;
                if(curY == -1 || snail[curX][curY] != 0) {
                    curY++;
                    curX++;
                    flag = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (snail[i][j] == m) {
                    ansX = i + 1;
                    ansY = j + 1;
                }
                if (j == n - 1) {
                    sb.append(snail[i][j]);
                    continue;
                }
                sb.append(snail[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(ansX + " " + ansY);

        System.out.println(sb);

    }

}
