import java.util.*;
import java.io.*;

class Node{
	int h;
	int idx;
	
	public Node(int h, int idx) {
		this.h = h;
		this.idx = idx;
	}
}
public class Main{

     public static void main(String []args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int n = Integer.parseInt(br.readLine());
       StringTokenizer st = new StringTokenizer(br.readLine()," ");
       StringBuilder sb = new StringBuilder();
       Stack<Node> stack = new Stack<>();
       for(int i = 0 ; i < n ; i++) {
    	   int tower = Integer.parseInt(st.nextToken());
    	   if(!stack.isEmpty()) {
           
           // 현재 값보다 낮은 타워는, 뒤에서 방문할 일이 절대 없음.
    		   while(true) {
    			   Node node = stack.peek();
    			   if(node.h < tower) {
    				   stack.pop();
    			   }else {
    				   sb.append(node.idx+" ");
    				   stack.push(new Node(tower,i+1));
    				   break;
    			   }
    			   
    			   if(stack.isEmpty()) {
    				   sb.append(0+" ");
    				   stack.push(new Node(tower,i+1));
    				   break;
    			   }
    		   }
    	   }else {
    		   sb.append(0+" ");
    		   stack.push(new Node(tower,i+1));
    	   }
       }
       System.out.println(sb.toString());
     }
}
