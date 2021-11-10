import java.util.*;
import java.io.*;

public class Main{

     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[500001];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
       // 등수 계산
        for(int i = 0 ; i < n ; i++){
            int val = Integer.parseInt(br.readLine());
            if(val > n){
                pq.add(val);
                continue;
            }
            if(arr[val] == 0){
                arr[val] = val;
            }else{
                pq.add(val);
            }
        }
        long answer = 0;
        for(int i = 1; i < n+1; i++){
            if(arr[i] == 0){
                int val = pq.poll();
                answer += Math.abs(val-i);
                arr[i] = val;
            }
        }
        System.out.println(answer);
     }
}
