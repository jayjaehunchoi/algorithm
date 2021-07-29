// 7번 테스트케이스 실패


import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	

	public static void main(String[] args) {
		 	int answer = 0;
	        int count = 0;
	        
	        int[] reserve = {3,4,5};
	        int[] lost = {2,3,4};
	        int n = 5;
	        HashMap<Integer, Integer> loster = new HashMap<Integer, Integer>();
	        
	        for(int i = 0 ; i < lost.length ; i++) {
	        	loster.put(lost[i], 1);
	        }
	              
	        for(int i = 0 ; i < reserve.length ; i++) {
	        	
	        	
	        	if(loster.containsKey(reserve[i])) {
		        	if (0 < loster.get(reserve[i])) {
		        		loster.replace(reserve[i], 0);
		         	}
	        	}
	        	
	        	else if(loster.containsKey(reserve[i]-1) && 0 != loster.get(reserve[i]-1)) {
		        	if (0 < loster.get(reserve[i]-1)) {
		        		loster.replace(reserve[i]-1, 0);
		        	}	        	
	        	}
		 	
	        	else if(loster.containsKey(reserve[i]+1) && 0 != loster.get(reserve[i]+1)) {
		        	if (0 < loster.get(reserve[i]+1)) {
		        		loster.replace(reserve[i]+1, 0);
		        	}
	        	}
	        }
	        
	        for(Entry<Integer, Integer> comP : loster.entrySet()) {
	        	if(0 == comP.getValue()) {
	        		
	        		count++;
	        	
	        	}
	        }
	      
	        System.out.println(n- (lost.length-count));
      
    }
}
