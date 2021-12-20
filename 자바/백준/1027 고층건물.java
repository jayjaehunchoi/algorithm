import java.io.*;
import java.util.*;

class Main {
    static int[] buildings;
    static int[] counts;
  
  // a건물과 b건물 사이에 건물이 없다는 뜻은, 기울기를 계산했을 때, 이 기울기에 (x,0) ~ (x,y) 가 존재하지 않는다는 뜻,
  // 바로 옆건물은 당연히 서로 볼 수 있고, 그 이후에 기울기가 이전 기울기보다 크면, 어떤 건물도 사이에 존재하지 않는다는 의미
    public static void getCount() {
        for (int i = 0; i < buildings.length - 1; i++) {
            counts[i]++;
            counts[i+1]++;
            double slope = buildings[i+1] - buildings[i];
            for (int j = i+2; j < buildings.length; j++) {
                double nextSlope = (double)(buildings[j] - buildings[i]) / (j-i);
                if(nextSlope <= slope) continue;
                counts[i]++;
                counts[j]++;
                slope = nextSlope;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        buildings = new int[n];
        counts = new int[n];

        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        getCount();

      // 가장 큰 수 
        Arrays.sort(counts);
        System.out.println(counts[n-1]);
    }

}
