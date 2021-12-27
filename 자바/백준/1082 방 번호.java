import java.io.*;
import java.util.*;

class Main {

    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        numbers = new int[n];
        int min = 50;
        int index = -1;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if(min >= numbers[i]) {
                min = numbers[i];
                index = i;
            }
        }

        int money = Integer.parseInt(br.readLine());
      
      // 0 ~ 50까지를 digit으로 표현
        char[] digits = new char[51];
        int cnt = 0;
      
      // 최솟값으로 구매할 수 있는 만큼 최대한 digit에 담기
        while (money >= min) {
            digits[cnt++] = (char) (index + '0');
            money -= min;
        }

      // 각 자리마다 구매할 수 있는 더 큰수가 있다면 구매
      // 만약 값이 0이라면 start ++
        int start = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = n-1; j >= 0; j--) {
                if(numbers[j] <= money + min) {
                    digits[i] = (char) (j + '0');
                    money += min - numbers[j];
                    break;
                }
            }
            if(digits[start] == '0') {
                start++;
                money += min;
            }
        }

      // 모든 수가 0일경우 0 출력
        if(isZero(digits, cnt)) {
            System.out.println(0);
        }else {
            String ans = "";
            for (int i = start; i < cnt; i++) {
                ans += digits[i];
            }
            System.out.println(ans);
        }


    }

    private static boolean isZero(char[] digits, int cnt) {
        for (int i = 0; i < cnt; i++) {
            if(digits[i] != '0'){
                return false;
            }
        }
        return true;
    }

}
