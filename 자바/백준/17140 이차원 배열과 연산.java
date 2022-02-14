import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        int compare = Integer.compare(this.value, o.value);
        return compare == 0 ? Integer.compare(this.key, o.key) : compare; // value 오름차순 -> key 오름차순
    }
}
public class Main {
    static int[][] arr;
    static int curR = 3;
    static int curC = 3;

    static void calculateR() {
        for (int i = 1; i <= curR; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            Map<Integer, Integer> tempMap = new HashMap<>();
            for (int j = 1; j <= curC; j++) {
                if (arr[i][j] == 0) continue;
                tempMap.put(arr[i][j], tempMap.getOrDefault(arr[i][j], 0) + 1);
            }

            for(Map.Entry<Integer, Integer> e : tempMap.entrySet()) {
                pq.add(new Node(e.getKey(), e.getValue()));
            }

            int col = 1;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                arr[i][col++] = node.key;
                arr[i][col++] = node.value;
            }
            curC = Math.max(curC, col);

            while (col <= 99) {
                arr[i][col++] = 0;
                arr[i][col++] = 0;
            }
        }
    }

    static void calculateC() {
        for (int i = 1; i <= curC; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            Map<Integer, Integer> tempMap = new HashMap<>();
            for (int j = 1; j <= curR; j++) {
                if (arr[j][i] == 0) continue;
                tempMap.put(arr[j][i], tempMap.getOrDefault(arr[j][i], 0) + 1);
            }

            for(Map.Entry<Integer, Integer> e : tempMap.entrySet()) {
                pq.add(new Node(e.getKey(), e.getValue()));
            }

            int row = 1;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                arr[row++][i] = node.key;
                arr[row++][i] = node.value;
            }
            curR = Math.max(row, curR);

            while (row <= 99) {
                arr[row++][i] = 0;
                arr[row++][i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[101][101];
        for (int i = 1; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= 100; i++) {
            if(arr[r][c] == k) {
                System.out.println(i);
                return;
            }
            if (curC <= curR) {
                calculateR();
            } else {
                calculateC();
            }
        }

        System.out.println(-1);

    }
}
