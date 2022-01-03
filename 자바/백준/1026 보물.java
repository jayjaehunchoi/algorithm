import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

      
      // 재배치를 통해 곱을 최소화, 즉 최대와 최소가 만나면 된다는 뜻.
      // b는 재배치하지 말라고 하였으나, 어차피 결과는 합으로 나오기 때문에 상관없음
        PriorityQueue<Integer> aQueue = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> bQueue = new PriorityQueue<>((a, b) -> a - b);

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            aQueue.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            bQueue.add(Integer.parseInt(st.nextToken()));
        }


        int answer = 0;
        while (!aQueue.isEmpty()) {
            answer += (aQueue.poll() * bQueue.poll());
        }

        System.out.println(answer);


    }


}
