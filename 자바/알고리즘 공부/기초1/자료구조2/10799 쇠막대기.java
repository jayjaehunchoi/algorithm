import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main{
	// 스택 쓰려고 했는데,,, 안썼다 ㅋㅋㅋ
  // 스택을 사용하지 않아도 규칙만 발견하면 풀 수 있는 문제!
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      String input = br.readLine();
      char[] inputs = input.toCharArray();
      Stack<Character> stack = new Stack<>();
      
      int answer = 0 ;
      int stick = 0;
      int laser = 0;
      
      
      for(int i = 0 ; i < inputs.length; i++) {
    	  if(inputs[i] == '(') {
    		  stack.push(inputs[i]);
    		  stick++;
    	  }else if(!stack.isEmpty() && inputs[i] == ')') {
    		  if(inputs[i-1] == '(') {
    			  stack.pop();
    			  laser++;
    			  stick--;
    			  answer += stick;
    		  }else {
    			  answer++;
    			  stick--;
    		  }
    	  }
    	  
    	  
      }
      System.out.println(answer);
      
    }
}
