import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            List<Integer> aList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                aList.add(Integer.parseInt(st.nextToken()));
            }

          // 최초 지점 값 설정
            int comp = aList.get(aList.size() - 1);
            long answer = 0; // 100만에 10만인데다가 빼고 더하는게 있어 int로 충분할 줄 알았는데 계속 틀렸었다. long으로 바꿔주니 해결
          
          // 뒤에서부터 탐색하면서 자기보다 저가일때는 판매한다고 가정
          // 자기와 같으면 무시
          // 자기보다 크면 비교값 고점으로 변경 
            for (int i = aList.size() - 2 ; i >= 0; i--) {
               if(aList.get(i) > comp){
                   comp = aList.get(i);
                   continue;
               }
               answer += (comp - aList.get(i));
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }

}
