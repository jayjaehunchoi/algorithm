import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
    	 int n = Integer.parseInt(br.readLine());
    	 
    	 PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>((a,b) -> b-a);
    	 PriorityQueue<Integer> minQ = new PriorityQueue<Integer>((a,b) -> a-b);
    	 
    	 for(int i = 0 ; i < n ; i++) {
    		 if(i % 2 ==0) {
    			 maxQ.add(Integer.parseInt(br.readLine()));
    			 
    			 if(!minQ.isEmpty() && minQ.peek() < maxQ.peek()) {
    				 int a = minQ.poll();
    				 int b = maxQ.poll();
    				 minQ.add(b);
    				 maxQ.add(a);
    			 }
    		 }else {
    			 minQ.add(Integer.parseInt(br.readLine()));
    			 
    			 if(minQ.peek() < maxQ.peek()) {
    				 int a = minQ.poll();
    				 int b = maxQ.poll();
    				 minQ.add(b);
    				 maxQ.add(a);
    			 }
    		 }
    		 bw.write(maxQ.peek()+"\n");
    	 }
    	 bw.flush();
    	 bw.close();
    	 br.close();
    	 
   }
  
}
