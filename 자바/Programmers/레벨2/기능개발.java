import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	
	public static int findTo100(int x, int y) {
		
		if(x >= 99) {
			return 1;
		}
		
		return 1+ findTo100(x+y, y);
	}
	
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
	        int count = 0;
	        int n = 0;
	        
	        int k = findTo100(progresses[0], speeds[0]) -2;
	        
	        Queue<Integer> pQueue = new LinkedList<Integer>();
	        pQueue.add(1);
	        
	        for(int i = 0 ; i < progresses.length ; i++) {
	        	progresses[i] += speeds[i] * k;
	        }
	        
	        while(pQueue.size() !=0) {
	        	
	        	
	        		for(int i = n ; i < progresses.length; i++) {
	        			progresses[i] += speeds[i];
	        			
	        		}
	        		
	        		if(progresses[n] >= 100) {
	        			pQueue.clear();
	        			for(int i = n ; i < progresses.length ; i++) {
	        				pQueue.add(progresses[i]);
	        			}
	        			
	        			while(pQueue.peek() >= 100) {
	        				
	        				count++;
	        				pQueue.poll();
	        				if(pQueue.size() == 0 ) {
	        					break;
	        				}
	        				
	        			}
	        			
	        			n += count;
	        			answer.add(count);
	        			count = 0;

	        		}
	        		
	        		
	        	}
  
        return answer;
    }
}
