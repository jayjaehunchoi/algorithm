import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int pls = 0;
        while(true) {
            int tmp = n + pls;
            int count = 0;
            while(tmp > 0) {
              // 나머지가 남을때마다 하나씩 사는 셈.
                if(tmp % 2 != 0){
                    count++;
                }
                tmp /= 2;
            }
            if(count <= k) {
                break;
            }
            pls++;
        }

        System.out.println(pls);
    }
}
