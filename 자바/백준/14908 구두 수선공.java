import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    public int idx;
    public double t;
    public double s;

    public Node(int idx, double t, double s) {
        this.idx = idx;
        this.t = t;
        this.s = s;
    }

    public double calOrder(){
        return t / s;
    }
  
  // t/s 가 작을수록 작업이 늦어질때 벌금 늘어나는 비율이 높다.
    @Override
    public int compareTo(Node o) {
        double thisWork = this.calOrder();
        double oWork = o.calOrder();

        if(thisWork - oWork > 0) {
            return 1;
        }else if(thisWork - oWork == 0) {
            return 0;
        }
        return -1;
    }
}

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
      
      // PriorityQueue를 사용하다가 , Collections.sort로 전환하니 맞았다.
      // 이유를 모르겠다.. 두 정렬에 어떤 차이가 있는지 확인해봐야겠다
        List<Node> pq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double t = Double.parseDouble(st.nextToken());
            double s = Double.parseDouble(st.nextToken());
            pq.add(new Node(i+1, t, s));
        }
        Collections.sort(pq);
        int i = 0;
        while(i != n) {
            sb.append(pq.get(i).idx + " ");
            i++;
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);

    }

}
