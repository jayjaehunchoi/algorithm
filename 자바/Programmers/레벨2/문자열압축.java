import java.util.Stack;

class Solution {
    public int solution(String s) {
    	 int minLength = 1000;

	        //자르는 수
	        int k = 1;
	        
      // 절반까지만 계산해줘도 된다.
	        while(k <= s.length()/2) {
	        	Stack<String> stack = new Stack<String>();
            
	        	int countLength = 0;
	        	String forCount = "";
	        	int num =2;
            
            //여기서부터 썩은코드, 반복문을 통해 계속 팝 푸시 하면서 동일한 알파벳의 숫자를 높여준다.
	        	for(int i = 0 ; i < s.length()-(k-1); i+=k) {
	        		
	        		if(!stack.isEmpty() ) {        			  
	        			if(stack.peek().length() == k && stack.peek().equals(s.substring(i,i+k))) {
     					stack.pop();
     					stack.push(num + s.substring(i,i+k));
     					num++;
	        				}
     				else if(stack.peek().length() > k &&stack.peek().substring(1, stack.peek().length()).equals(s.substring(i,i+k))){
     					stack.pop();
     					stack.push(num + s.substring(i,i+k));
     					num++;
	        				}
                
              // 10을 넘어가면 두자리이기떄문에 위 조건문 반영이 안된다, 따라서 추가해줌
     				else if(num > 10 && stack.peek().substring(2, stack.peek().length()).equals(s.substring(i,i+k))) {
     					stack.pop();
     					stack.push(num + s.substring(i,i+k));
     					num++;
     				}
                
            // 연속된 수가 아닐때는 num 변수를 항상 초기화 시켜준다.
     				else {
         				stack.push(s.substring(i,i+k));
         				num = 2;
     				}	
     			}
     			else {
     				stack.push(s.substring(i,i+k));
     				num = 2;
     			}
	        		
	        		        	
	        	}
	        	if(s.length() % k != 0) {
     			stack.add(s.substring(s.length() - (s.length() % k) ,s.length()));
     		}
	        	
            // 최소값을 
	        	for(int i = 0 ; i < stack.size(); i++) {
	        		forCount += stack.get(i);
	        	}
	        	
	        	
	        	countLength = forCount.length();
	        	if(countLength < minLength) {
	        		minLength = countLength;
	        	}
	        	
	        	k++;
	        }
      
      // s의 길이가 1일 경우 아예 반복문에 들어가지도 않는다.
      // 따라서 추가해줘야함.
	        if(s.length() == 1) {
	        	minLength = 1;
	        }
        
        return minLength;
    }
}
