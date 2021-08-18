import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(String s) {
	    int answer = 0;
	    Stack<String> stack = new Stack<String>();
      List<String> aList = new ArrayList<String>();
	    
	    
	    for(int i = 0 ; i < s.length(); i++) {
	    	aList.add(s.substring(i,i+1));
	    }
	    
	      // List를 왼쪽으로 돌리면서 , 올바른 괄호가 되면 pop, 아니면 push하고 
      // 스택이 비면 answer ++;
        for(int j = 0 ; j < s.length(); j++) {
    	    stack.clear();
    	   for(int i = 0 ; i < s.length() ; i++) {
           	String n = aList.get(i);
           	
		       	if(stack.isEmpty()) {
		       		stack.push(n);
		       		continue;
		       	}
		       	if(n.equals(")") && stack.peek().equals("(")) {
		       		stack.pop();
		       	}else if(n.equals("}") && stack.peek().equals("{")) {
		       		stack.pop();
		        }else if(n.equals("]") && stack.peek().equals("[")) {
		      		stack.pop();
		        }else {
		        	stack.push(n);
		        }
    	   }
    	   if(stack.isEmpty()) {
    		   answer++;
    	   }
    	   aList.add(aList.remove(0));
        }

        return answer;
    }
}
