import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	int start;
	int end;
	
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Node o) {
		return this.start - o.start;
	}
	
}

public class Main{

     public static void main(String []args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       
       StringTokenizer st;
       PriorityQueue<Node> pq = new PriorityQueue<Node>();
       
       for(int i = 0 ; i < n ; i++) {
    	   st = new StringTokenizer(br.readLine(), " ");
    	   int str = Integer.parseInt(st.nextToken());
    	   int end = Integer.parseInt(st.nextToken());
    	   
    	  pq.add(new Node(str,end));
       }
       
       int answer = 0;
       int maxEnd = -1000000000;
       
       // 시작점 기준 정렬
       // 끝점끼리 비교해나가면서 값 더하기.
       while(!pq.isEmpty()) {
    	   Node node = pq.poll();
    	   if(maxEnd > node.start) {
    		   if(maxEnd <= node.end) {
    			   answer += node.end - maxEnd;
    		   }
    	   }else {
    		   answer += node.end - node.start;
    	   }
    	   maxEnd = Math.max(node.end, maxEnd);
       }
       System.out.println(answer);
       
     }
}
