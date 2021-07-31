import static java.lang.Math.min;

import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int [2];
        int min = Math.min(n, m);
    	int max = Math.max(n, m);
    	
    	ArrayList<Integer> aList = new ArrayList<Integer>();
    	
        if(max % min == 0) {
        	answer[0] = min;
        	answer[1] = max;
        }
        
        else {
        	for(int i = 1 ; i < min; i++) {
        		if(max % i ==0 && min % i == 0) {
        			answer[0] = i;
        		}
        	answer[1] = min * max / answer[0];
        	}
        
        
        }
        return answer;
    }
}
