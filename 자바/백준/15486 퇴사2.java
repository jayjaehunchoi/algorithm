import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Benefit {
    int days;
    int cost;

    public Benefit(int days, int cost) {
        this.days = days;
        this.cost = cost;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Benefit[] benefits = new Benefit[n];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            benefits[i] = new Benefit(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int max = 0;
        for (int i = 0; i < benefits.length; i++) {
            max = Math.max(dp[i], max);
            if(i + benefits[i].days - 1 < n) {
                dp[i + benefits[i].days] = Math.max(dp[i + benefits[i].days], max + benefits[i].cost);

            }
        }

        Arrays.sort(dp);
        System.out.println(dp[n]);
    }
}
