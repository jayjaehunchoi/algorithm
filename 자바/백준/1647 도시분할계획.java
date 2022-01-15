import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] parent;
    static List<Edge> eList;

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int start, int end) {
        start = find(start);
        end = find(end);

        if(start != end) {
            parent[end] = start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        eList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            eList.add(new Edge(start, end, cost));
        }

        Collections.sort(eList);

        int answer = 0;
        int maxCost = 0;

      // 순환하는 경로들 제외
        for (int i = 0; i < eList.size(); i++) {
            Edge e =  eList.get(i);

            if(find(e.start) != find(e.end)) {
                answer += e.cost;
                union(e.start, e.end);

                maxCost = e.cost;
            }
        }

        System.out.println(answer - maxCost);


    }

}
