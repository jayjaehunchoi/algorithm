import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] numbers) {
        
        
        ArrayList<Integer> aList = new ArrayList<Integer>();
        
        for(int i = 0; i < numbers.length-1 ; i++) {
        	
        	for(int j = i+1 ; j < numbers.length; j++) {
        		int a = numbers[i]+numbers[j];
        		if(!aList.contains(a)) {
        			aList.add(a);
        		}
        	}
        }
        
        Collections.sort(aList);
        int[] answer = new int[aList.size()];
        
        for(int i = 0 ; i < aList.size();i++) {
        	answer[i] = aList.get(i);
        }
        
        return answer;
    }
}
