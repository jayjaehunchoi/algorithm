import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> aList = new ArrayList<>();

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            aList.add(Integer.parseInt(st.nextToken()));
        }

        int min = 0;
        int max = n;

      // 가장 큰수를 높이 올려서는 안됨
      // 남아있는 가장 큰 수 중심으로 차이가 가장 작은 경우를 올린다
        for (int i = 0; i < n - 1; i++) {
            int idx = aList.indexOf(max);

            if(idx == 0){
                min += (max - aList.get(idx+1));
            }else if(idx == aList.size() - 1) {
                min += (max - aList.get(idx - 1));
            }else{
                min += Math.min((max - aList.get(idx - 1)), (max - aList.get(idx + 1)));
            }

            aList.remove(idx);
            max--;
        }
        System.out.println(min);

    }

}
