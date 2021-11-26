import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] boards;
    static boolean[][] visited;
    static int x;
    static int y;
    static List<Integer> aList = new ArrayList<>();
    static int count = 1;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void fillBoards(int x1, int y1, int x2, int y2){
        for(int i = x1 ; i < x2; i++){
            for(int j = y1; j < y2 ; j++){
                boards[j][i] = 1;
            }
        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= boards.length || ny >= boards[0].length)continue;
            if(boards[nx][ny] == 0 && !visited[nx][ny]){
                count++;
                visited[nx][ny] = true;
                dfs(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        boards = new int[x][y];
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            fillBoards(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        visited = new boolean[x][y];
        int number = 0;
        for(int i = 0 ; i < x; i++){
            for(int j = 0 ; j < y; j++){
                if(boards[i][j] == 0 && !visited[i][j]){
                    number++;
                    dfs(i,j);
                    aList.add(count);
                    count = 1;
                }
            }
        }
        Collections.sort(aList);
        System.out.println(number);
        for (Integer integer : aList) {
            System.out.print(integer+" ");
        }
    }
}
