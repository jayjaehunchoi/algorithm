import java.util.*;

class Solution {
	  int position ;
  
  // u가 올바른 괄호인지, 균형잡힌 괄호인지 찾는작업
  // position이라는 변수로, 위치 +1 을하여 substring을 주기 편하게 활용
	  boolean isCorrect(String str) {
		boolean ret = true;
		int left = 0;
		int right = 0;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0 ; i < str.length(); i++) {
			
			if(str.charAt(i) == '(') {
				left++;
				stack.push('(');
			}
      else {
				right++;
				
        if(stack.isEmpty()) {
					ret = false;
				}
        else {
					stack.pop();
				}
			}
			if(left == right) {
				position = i+1;
				return ret;
			}
		}
		return true;
	}
	
	
    public String solution(String p) {
    	
    	if(p.isEmpty()) return p;
    	
    	boolean correct = isCorrect(p);
    	String u = p.substring(0, position);
    	String v = p.substring(position,p.length());
    	
      //u가 올바른 괄호 문자열이면, u + 재귀 v
      //(다시 u ,v 로 나눠지고 ~~~ 언젠가 v는 빈문자열이 되어 첫줄에서 return 됨)
    	if(correct) {
    		return u + solution(v);
    	}
      
      //u가 균형잡힌 괄호열일 경우
        String answer = "(" + solution(v) + ")";
        for(int i = 1; i < u.length()-1; i++) {
        	if(u.charAt(i) == '(') {
        		answer += ")";
        	}else {
        		answer +="(";
        	}
        }
        
        return answer;
    }
}
