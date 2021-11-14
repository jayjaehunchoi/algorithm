import java.util.*;
import java.io.*;

public class Main{

     public static void main(String []args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int n = Integer.parseInt(br.readLine());
       StringTokenizer st;
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
       
       for(int i = 0 ; i < n ; i++) {
    	   st = new StringTokenizer(br.readLine()," ");
    	   for(int j = 0 ; j < n ; j++) {
    		   int val = Integer.parseInt(st.nextToken());
    		   pq.add(val);
    	   }
       }
       
       int answer = 0;
       for(int i= 0 ; i < n ; i++) {
    	   answer = pq.poll();
       }
       
       System.out.println(answer);
       
     }
}
