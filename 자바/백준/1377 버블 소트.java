import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {

    public int num, idx;

    public Pair(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Pair o) {
        return this.num - o.num;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n+1];

        for (int i = 1; i < n+1; i++) {
            pairs[i] = new Pair(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(pairs, 1, n + 1);

        int max = 0;

      // sort된 횟수를 찾는 내용이다.
      // 즉, 앞으로 가장 많이 이동한 idx를 찾으면 몇 회 sort됐는지 찾을 수 있고, 가장 많이 sort된 해당 index를 출력해주면된다.
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, pairs[i].idx - i);
        }

        System.out.println((max + 1) +"\n");

    }

}
