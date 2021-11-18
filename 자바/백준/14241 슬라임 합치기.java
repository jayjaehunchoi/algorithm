import java.util.*;
import java.io.*;

public class Main{

     public static void main(String []args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
       for(int i = 0 ; i < n ; i++) {
    	   pq.add(Integer.parseInt(st.nextToken()));
       }
       
       int answer = 0;
       while(true) {
    	   int val = pq.poll();
    	   
    	   if(pq.isEmpty()) {
    		   System.out.println(answer);
    		   return;
    	   }
    	   
    	   int comp = pq.poll();
    	   pq.add(val + comp);
    	   answer += val * comp;
       }
       
     }
}
