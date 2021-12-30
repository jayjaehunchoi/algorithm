import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> maps = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            maps.put(val, maps.getOrDefault(val, 0) + 1);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(st.nextToken());
            maps.put(val, maps.getOrDefault(val, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> e : maps.entrySet()) {
            if(e.getValue() == 1) {
                count++;
            }
        }
        System.out.println(count);

    }

}
