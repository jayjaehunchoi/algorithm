import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        ArrayList<Integer> aList = new ArrayList<Integer>();
        
        aList.add(arr[0]);
        for(int i = 1 ; i < arr.length ; i++) {
        	if(arr[i] != arr[i-1] ) {
        		aList.add(arr[i]);
        	}
        }
        int[] answer = new int [aList.size()];
        for(int i = 0; i < answer.length; i++ ) {
        	answer[i] = aList.get(i);
        }
        return answer;
    }
}
