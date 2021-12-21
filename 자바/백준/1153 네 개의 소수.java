import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    static int n;
    static List<Integer> aList;
    static boolean[] primeNumbers;

    public static boolean[] findPrimeNumber() {
        boolean[] primes = new boolean[n + 1];
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i*i < primes.length; i++) {
            for (int j = i * i; j <= n; j = j + i) {
                primes[j] = true;
            }
        }
        return primes;
    }

    public static void goldBach(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if(!primeNumbers[i] && !primeNumbers[num - i]) {
                aList.add(i);
                aList.add(num - i);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        primeNumbers = findPrimeNumber();
        aList = new ArrayList<>();
      
      // 가장 작은 소수는 2, 2 4개의 합은 8
      // 8미만의 값은 나올 수가 없음
        if(n < 8) {
            System.out.println(-1);
            return;
        }else {
          
          // 골드 바흐의 추측, 짝수일경우 두 소수를 2라고 가정, 홀수일경우 두 소수를 2, 3으로 가정
          // 나머지 두 수에 대해 합을 찾으면 됨
            if(n % 2 != 0) {
                aList.add(2);
                aList.add(3);
                goldBach(n - 5);

            }else{
                aList.add(2);
                aList.add(2);
                goldBach(n - 4);
            }
        }

        Collections.sort(aList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aList.size(); i++) {
            sb.append(aList.get(i) +" ");
        }

        System.out.println(sb.toString().trim());

    }

}
