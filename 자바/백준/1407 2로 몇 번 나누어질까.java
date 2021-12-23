import java.io.*;
import java.util.*;

class Main {

    public static long getValue(long val) {
        long sum = 0;
        long value = 0;
        long i = 1;

        while(val > 0) {
            if(val % 2 == 0) {
                value = val / 2;
            }else {
                value = val / 2 + 1;
            }

            sum += value * i;
            val -= value;
            i *= 2;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

      // 1, 2, 1, T 형태의 규칙을 가짐
      // 1, 2, 1, T 를 반복하는 규칙을 공식화 하여 end 까지의 합 - start-1까지의 합을 구하면  
        System.out.println(getValue(end) - getValue(start-1));
    }

}
