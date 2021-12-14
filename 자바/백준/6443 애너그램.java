import java.io.*;
import java.util.*;

class Main {

  // 사전상 다음에 올 수 있는 순열을 찾는다.
    public static boolean nextPermutation(char[] cArr) {
        int i = cArr.length - 1;

        while(i > 0 && cArr[i] <= cArr[i-1]) {
            i--;
        }

        if(i <= 0) {
            return false;
        }

        int j = cArr.length - 1;

        while (cArr[i-1] >= cArr[j]) {
            j--;
        }
        swap(cArr, i, j);

        j = cArr.length - 1;
        while (i < j) {
            char temp = cArr[j];
            cArr[j] = cArr[i];
            cArr[i] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void swap(char[] cArr, int i, int j) {
        char temp = cArr[j];
        cArr[j] = cArr[i-1];
        cArr[i-1] = temp;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            char[] cArr = new char[str.length()];
            for (int j = 0; j < str.length(); j++) {
                cArr[j] = str.charAt(j);
            }

            Arrays.sort(cArr);

            for (int j = 0; j < cArr.length; j++) {
                sb.append(cArr[j]);
            }
            sb.append("\n");

            while (nextPermutation(cArr)) {
                for (int j = 0; j < cArr.length; j++) {
                    sb.append(cArr[j]);
                }
                sb.append("\n");
            }


        }
        System.out.println(sb.toString());
    }

}
