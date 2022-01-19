import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Star를 만들어 크루스칼 알고리즘에 이용하기 위함
class Star {
    double x;
    double y;

    public Star(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

// 임의로 지정한 Star의 위치와 그 사이의 가중치를 계산하여 담는 클래스
class Edge implements Comparable<Edge> {
    int x;
    int y;
    double weight;

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }

    public Edge(int x, int y, double weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}

public class Main {
    static int[] parent;

  // 가중치 계산
    static double getWeight(Star s1, Star s2) {
        return Math.sqrt(Math.pow(s2.x - s1.x, 2) + Math.pow(s2.y - s1.y, 2));
    }

  // 크루스칼 알고리즘 부모 노드 찾기
    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

  // 이미  노드는 다시 계산하지 않는다. (최소값 순으로 정렬되어있기 때문)
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return false;
        parent[a] = b;
        return true;
    } 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        Star[] stars = new Star[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stars[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            parent[i] = i;
        }

        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                pq.add(new Edge(i, j, getWeight(stars[i], stars[j])));
            }
        }

        int count = 0;
        double answer = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if(union(e.x, e.y)) {
                answer += e.weight;
                if (++count == n -1) break; // 간선이 모두 연결되었다면 더이상 계산을 하지 않고 멈춘다.
            }
        }

        System.out.printf("%.2f", answer);


    }

}
