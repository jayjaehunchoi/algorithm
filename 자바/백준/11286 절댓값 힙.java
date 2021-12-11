import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
      
      // 1. 절댓값 비교, 절댓값 기준 오름차순
      // 2. 만약 절댓값이 같을 경우에는 원래 값 비교 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if(absA == absB) return a - b;
            return absA - absB;
        });
        for(int i = 0 ; i < n ; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pq.isEmpty()){
                    sb.append(0 + "\n"); // 빈 que일 경우 return 0
                }else{
                    sb.append(pq.poll() + "\n"); // 가장 최소 값
                }
            }else {
                pq.add(input);
            }
        }
        System.out.println(sb.toString());
    }

}
