import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        
    	String nStr = String.valueOf(n);
    	
    	ArrayList<String> aList = new ArrayList<String>();
    	
    	String hap = new String();
    	
    	for(int i = 0 ; i < nStr.length(); i++) {
    		aList.add(nStr.substring(i, i+1));
    	}
    	
    	Collections.sort(aList);
    	
    	for(int i = nStr.length()-1 ; i > -1 ; i-- ) {
    		hap += aList.get(i);
    	}
    	
   
    	long answer = Long.parseLong(hap);
        return answer;
    }
}
