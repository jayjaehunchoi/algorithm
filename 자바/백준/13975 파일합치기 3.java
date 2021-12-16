import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            long answer = 0;
            long tempSum = 0;
            for (int i = 0; i < n; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

          // 가장 낮은 것끼리 더하고, 더한 값은 다시 작업큐에 추가
          // 큐가 빌때까지 작업 반복
            while (!pq.isEmpty()) {
                tempSum = pq.poll() + pq.poll();
                answer += tempSum;
                if(pq.isEmpty()) {
                    break;
                }
                pq.add(tempSum);
                tempSum = 0;
            }
            System.out.println(answer);
        }
    }

}
