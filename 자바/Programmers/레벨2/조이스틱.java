import java.util.Arrays;

//tc 4,7 번 절대 해결안됨 ;;;; 

class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("AABAAAAAAABBB"));
	}
    public int solution(String name) {
        int answer = 0;
        
        char[] chars = name.toCharArray();
        char[] vals = new char[chars.length];
        Arrays.fill(vals, 'A');
        boolean right = true;
        int idx = 0;
        
        while(true) {
        	
        	int mins = Math.min(chars[idx] - 'A' , 'Z'-chars[idx] + 1);
        	answer += mins;
        	vals[idx] = chars[idx];
        	if(right) {
        		idx++;
        	}else {
        		idx--;
        	}
        	System.out.println(mins + " " + answer + " " + makeString(vals));
        	if(idx < 0 || idx == chars.length || makeString(vals).equals(name)) {
        		return answer;
        	}
        	if(idx < 0 || idx == chars.length || chars[idx] != 'A') {
        		answer++;
        	}
        	
        	if(chars[idx] == 'A') {
        		if(!right) {
        			int a = checkCheckRight(chars, idx);
        			int b = checkCheckLeft(chars, idx);
        			//System.out.println(b + " " + idx);
        			
        			if(a < b) {

            			idx = a - (chars.length - idx);
            			answer += a;
            			right = true;
            		}else {
            			idx = idx-b;
            			answer += b;
            		}
        			System.out.println(idx + " " + a + "  " + b);
        		}else {
        			int a = checkRight(chars, idx);
            		int b = checkLeft(chars, idx);
            		if(a <= b) {
            			idx += a-1;
            			answer += a;
            		}else {
            			idx = chars.length-(b-idx)-1;
            			right = false;
            			answer += b;
            		}
        		}
        		
        	}

        	

        }
    }
    
    public String makeString(char[] chars) {
    	String s = "";
    	for(int i = 0 ; i < chars.length; i++) {
    		s += chars[i];
    	}
    	return s;
    }
    
    public int checkRight(char[] chars, int idx) {
    	int i = idx;
    	while(chars[idx] == 'A') {
    		idx++;
    		if(idx == chars.length) {
    			return -1;
    		}
    	}
    	return idx-i+1;
    }
    
    public int checkLeft(char[] chars, int idx) {
    	int val = idx;
    	int i = chars.length-1;
    	while(chars[i] =='A') {
    		i--;
    		val++;
    	}
    	return val;
    }
    
    public int checkCheckLeft(char[] chars, int idx) {
    	int i = idx;
    	while(chars[i] =='A') {
    		i--;
    	}
    	return idx - i;
    }
    
    public int checkCheckRight(char[] chars, int idx) {
    	int val = chars.length - idx;
    	int i = 0;
    	while(chars[i] =='A') {
    		i++;
    		val++;
    	}
    	return val;
    }
}
