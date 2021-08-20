import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0 ; i < s.length(); i++) {
        	
          // 스택이 비면 다시 false로
          if(stack.isEmpty()) {
        		answer = false;
        	}
          // 처음이 ( 이면 추가
        	if(s.charAt(i) == '(') {
        		stack.push(s.charAt(i));
        		answer = true;
        	}else {
            //처음에 ) 들어오면 바로 false
        		if(!answer) {
        			return answer;
        		}
            // () 이렇게 들어오면 pop
        		else {
        			stack.pop();
        		}
        	}
        }
        // 이건 혹시모를 대비책 여기서 거의 무조건 체크되어 넘어감
        if(stack.isEmpty()) {
        	return true;
        }else {
        	return false;
        }

    }
}
