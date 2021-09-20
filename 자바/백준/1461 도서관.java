import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {
	

    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
        
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         
          //음수, 양수로 나눠 pq구성
         PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
         PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>((a,b) -> b-a);
         
         st =  new StringTokenizer(br.readLine());
         for(int i = 0 ; i < N ; i++) {
        	int k = Integer.parseInt(st.nextToken());
        	
        	if(k < 0)pqMin.add(Math.abs(k));
        	else pq.add(k);
         }
         
        // 최대값 예외 조건 주기 위해 기억
         int mv = 0;
         if(pq.isEmpty()) {
        	 mv = pqMin.peek();
         }else if(pqMin.isEmpty()) {
        	 mv = pq.peek();
         }else {
        	 mv = Math.max(pq.peek(),pqMin.peek());
         }
         
         int ans = 0;
         while(!pq.isEmpty()) {
        	 int tmp = pq.poll();
        	 for(int i = 0 ; i < M-1; i++) {
        		 pq.poll();
        	 }
    		 
        	 ans += tmp*2;
    		 if(pq.isEmpty()) {
    			break; 
    		 }
         }
         
         while(!pqMin.isEmpty()) {
        	 int tmp = pqMin.poll();
        	 for(int i = 0 ; i < M-1; i++) {
        		 pqMin.poll();
        	 }
    		 
        	 ans += tmp*2;
    		 if(pqMin.isEmpty()) {
    			break; 
    		 }
         }
         
         ans -= mv;
         System.out.println(ans);
   }
  
}
