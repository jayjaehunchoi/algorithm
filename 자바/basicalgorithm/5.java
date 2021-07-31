import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayList<Character> aList = new ArrayList<Character>();
        int countp = 0;
        int county = 0;
        
        
        // 생각해보니 substring하고 charAt 쓰지 말고 걍 charAt쓰면 됐었음..
        for(int i = 0 ; i < s.length(); i++) {
        	aList.add(s.substring(i,i+1).charAt(0));
        	if(aList.get(i) == 112 || aList.get(i) == 80) {
        		countp++;
        	}
        	else if(aList.get(i) == 121 || aList.get(i) == 89) {
        		county++;
        	}
        }
        
        if(countp != county) {
        	answer = false;
        }
        
        
        return answer;
    }
}
