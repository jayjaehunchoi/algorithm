import java.io.*;
import java.util.*;

class Main {

    static List<Integer> fList = new ArrayList<>();

    public static void setFibonacci(){
        fList.add(1);
        fList.add(1);

        int i = 2;
        while(fList.get(fList.size() - 1) <= 1000000000) {
            fList.add(fList.get(i - 2) + fList.get(i - 1));
            i++;
        }

        if (fList.get(fList.size() - 1) > 1000000000) {
            fList.remove(fList.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        setFibonacci();

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> aList = new ArrayList<>();

          // 매번 최선의 선택을 해준다.
          // 증명에 따르면 피보나치로 매번 최선의 선택을 해서 빼주면 결국 0을 만들어 낼 수 있다.
            for (int i = fList.size() - 1; i >= 0; i--) {
                if(n - fList.get(i) >= 0) {
                    n -= fList.get(i);
                    aList.add(fList.get(i));
                }

                if(n == 0) {
                    break;
                }
            }

            Collections.sort(aList);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < aList.size(); i++) {
                sb.append(aList.get(i) + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }

}
