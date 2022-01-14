import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n + 1];
        List<List<Integer>> aList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            aList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            aList.get(parent).add(child);
            indegree[child]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();

      // 어떤 수의 뒤에 나오지 않는 수에 대하여 모두 pq에 추가
        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                pq.add(i);
            }
        }

      // 먼저 앞 학생들을 정답 리스트에 추가한다.
      // 그리고 뒤에 서있는 수가 적은 순서대로 정답 리스트에 추가한다.
        while(!pq.isEmpty()) {
            int val = pq.poll();
            
            if(!answer.contains(val)) {
                answer.add(val);
            }
            for (int i : aList.get(val)) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    pq.add(i);
                }
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }


    }

}
