import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       
    	int answer = 0;
    	int totalWeight = 0;

    	Queue<Integer> waiting = new LinkedList<Integer>();
        Queue<Integer> crossing = new LinkedList<Integer>();
        ArrayList<Integer> crossed = new ArrayList<Integer>();
        
        for(int m : truck_weights) {
        	waiting.add(m);
        }
        
        for(int i = 0 ; i < bridge_length ; i++) {
        	crossing.add(0);
        }
        
        while(crossed.size() < truck_weights.length ) {
        	
        	int exit = crossing.poll();
        	totalWeight -= exit;
        	
        	if(exit != 0) {
        		crossed.add(exit);
        	}
        	
        	if(!waiting.isEmpty()) {
        		if(totalWeight + waiting.peek() <= weight ) {
            		int entering = waiting.poll();
            		crossing.offer(entering);
            		totalWeight += entering;	
            	}
        		else {
        			crossing.offer(0);
        		}
        	}
        	answer++;
        }
        
        
        return answer;
        
    }
}
