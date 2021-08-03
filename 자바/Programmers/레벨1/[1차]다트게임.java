import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = new int [3];
        Stack<String> darts = new Stack<String>();
     
      
      // 10이라는 숫자를 한 주소에 두기 위해
        for(int i = 0 ; i < dartResult.length() ;i++) {
        	if(!darts.isEmpty()) {
        		if(darts.peek().equals("1")  && dartResult.substring(i,i+1).equals("0")) {
        			darts.pop();
        			darts.push("10");
        		}
        		else {
        			darts.push(dartResult.substring(i,i+1));
        		}
        	}
        	else {
        		darts.push(dartResult.substring(i,i+1));    		
        	}
        }
        
        int n = 0;
        
        for(int i = 0 ; i < darts.size(); i++) {
        	if(darts.get(i).equals("S") || darts.get(i).equals("D")|| darts.get(i).equals("T") ) {
        		if(darts.get(i).equals("S")) {
        			scores[n] = (int)(Math.pow(Integer.parseInt(String.valueOf(darts.get(i-1))),1));
        			
        			n++;
        		}
        		else if(darts.get(i).equals("D")) {
        			scores[n] = (int)(Math.pow(Integer.parseInt(String.valueOf(darts.get(i-1))),2));
        			
        			n++;
        			System.out.println(scores[0]);
        		}
        		else if(darts.get(i).equals("T")) {
        			scores[n] = (int)(Math.pow(Integer.parseInt(String.valueOf(darts.get(i-1))),3));
        			
        			n++;
        		}
        	}
        	
        	if(darts.get(i).equals("*")|| darts.get(i).equals("#")) {
        		if(darts.get(i).equals("*") && i == 2 ) {
        			scores[n-1] *= 2;
        			
        		}
        		else if(darts.get(i).equals("*")) {
        			scores[n-2] *= 2;
        			scores[n-1] *= 2;
        		}
        		else if (darts.get(i).equals("#")) {
        			scores[n-1] *= -1;
        			
        		}
        	}
        }

        for(int m : scores) {
        	answer += m;
        }
        
        return answer;
    }
}
