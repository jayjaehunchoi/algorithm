import java.util.*;
import java.io.*;
class Node{

    int score;
    int min;
    
    public Node(int score, int min){
        this.score = score;
        this.min = min;
    }
    
}

public class Main{

     public static void main(String []args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int n = Integer.parseInt(br.readLine());
       
       
       Stack<Node> stack = new Stack<>();
       StringTokenizer st;
       int answer = 0;
       for(int i = 0 ; i < n ; i++){
           st = new StringTokenizer(br.readLine()," ");
           int hw = Integer.parseInt(st.nextToken());
           if(hw == 1){
               int score = Integer.parseInt(st.nextToken());
               int min = Integer.parseInt(st.nextToken());
               if(min-1 == 0) {
            	   answer += score;
            	   continue;
               }
               stack.push(new Node(score, min-1));
           }else{
               if(!stack.isEmpty()){
                   Node node = stack.pop();
                   int newMin = node.min-1;
                   if(newMin == 0){
                      answer += node.score; 
                   }else{
                       stack.push(new Node(node.score, newMin));
                   }
               }
           }
          
       }
       System.out.println(answer);
       
       
     }
}
