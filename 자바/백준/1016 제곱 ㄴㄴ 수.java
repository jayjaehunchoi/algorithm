import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.valueOf(st.nextToken());
        long max = Long.valueOf(st.nextToken());

        int total = (int) (max - min + 1);
        int sqrt = ((int) Math.sqrt(max));

        boolean[] checks = new boolean[total];

        for (long i = 2; i <= sqrt; i++) {
            long pow = i * i;
            long start = min % pow == 0 ? min / pow : min / pow + 1;

            for (long j = start; j * pow <= max; j++) {
                checks[(int) ((j * pow) - min)] = true;

            }
        }

        int answer = 0;
        for (int i = 0; i < total; i++) {
            if(!checks[i]) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
