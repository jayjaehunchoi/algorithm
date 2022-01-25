import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int MOD = 987654321;
    static boolean[] primes = new boolean[1000001];
    static List<Integer> primeNumbers;

    static void getPrimes(int n) {
        for (int i = 2; i * i < primes.length; i++) {
            for (int j = i * 2; j < primes.length; j = j + i) {
                primes[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                primeNumbers.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        primeNumbers = new ArrayList<>();
        getPrimes(n);
        long answer = 1;
        
        // 소수가 가장 많이 들어갈 경우를 탐색한다.
        // while문을 통해 소수의 거듭제곱 확률을 확인한다.
        // n보다 작은 소수는 최소 한 번씩은 들어가고, 거듭제곱을 통해 값을 만들 수 있음.
        for (Integer primeNumber : primeNumbers) {
            long temp = primeNumber;
            while (temp * primeNumber <= n) {
                temp *= primeNumber;
            }
            answer = (answer * temp) % MOD;
        }

        System.out.println(answer);

    }

}
