import java.io.*;
import java.util.*;

class Main {
    static List<Character> sList;
    static String t = "";

    public static void addChar(char c) {
        t += c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sList.add(br.readLine().charAt(0));
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            char lChar = sList.get(start);
            char rChar = sList.get(end);

            if (lChar < rChar) {
                addChar(lChar);
                start++;
            }else if(lChar > rChar){
                addChar(rChar);
                end--;
            }else{
              // 앞 뒤 값이 같은 경우 사전 순으로 가장빠른 문자열을 찾아야 하기 때문에
              // 다음 값이 더 작은 쪽을 선택해야한다.
              // 다음 값이 모두 같을 경우 아무거나 선택
                int tempL = start + 1;
                int tempR = end - 1;
                int size = t.length();
                while (tempL <= tempR){
                    if(sList.get(tempL) > sList.get(tempR)) {
                        addChar(rChar);
                        end--;
                        break;
                    }else if(sList.get(tempL) < sList.get(tempR)) {
                        addChar(lChar);
                        start++;
                        break;
                    }else {
                        tempL++;
                        tempR--;
                    }
                }
                if(size == t.length()){
                    addChar(lChar);
                    start++;
                }
            }
        }

      // 80 마다 개행
        if(t.length() >= 80){
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= t.length(); i++) {
                sb.append(t.charAt(i - 1));
                if(i % 80 == 0){
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }else {
            System.out.println(t);
        }

    }

}
