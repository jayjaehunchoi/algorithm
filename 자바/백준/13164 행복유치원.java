import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int left;
    int right;
    int subs;

    public Node(int left, int right, int subs){
        this.left = left;
        this.right = right;
        this.subs = subs;
    }

    @Override
    public int compareTo(Node o) {
        return this.subs - o.subs;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[300001];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Integer> aList = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            aList.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0 ; i < n-1; i++){
            int left = aList.get(i);
            int right = aList.get(i+1);
            int subs = right - left;
            pq.add(new Node(i,i+1,subs));
        }


        int answer = 0;
      // 만약 5, 4일경우 한 조만 합치고 나머지는 개인별로 0으로 두면됨
        for(int i = 0 ; i < n-k; i++){
            answer += pq.poll().subs;
        }
        System.out.println(answer);
    }
}
