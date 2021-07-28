import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        
        ArrayList<Integer> aList = new ArrayList<Integer>();
        	
        for(int i = 0 ; i < arr.length ; i++) {
        	if(arr[i] % divisor == 0) {
        		aList.add(arr[i]);
        	}	
        }
        
        
        int[] answer = {};
        
        if(aList.isEmpty()) {
        	answer = new int[1];
        	answer[0] = -1;
        	
        	
        }
        
        else {
        	Collections.sort(aList);
        	answer = new int[aList.size()];
        	for(int i = 0 ; i < aList.size(); i++) {
            	answer[i] = aList.get(i);
            }
            
        }
        
        return answer;
    }
}
