import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        
        List<Integer> enterList = new ArrayList<Integer>();
        int leaveIdx = 0;
        for(int i = 0 ; i < enter.length; i++) {
        	if(enterList.isEmpty()) {
        		enterList.add(enter[i]);
        	}else {
        		calCount(answer, enterList);
        		newCount(answer, enter[i], enterList);
        		enterList.add(enter[i]);
        	}
        	while(enterList.contains(leave[leaveIdx])) {
        		enterList.remove(enterList.indexOf(leave[leaveIdx]));
        		leaveIdx++;
        		if(leaveIdx == leave.length) {
        			break;
        		}
        		
        	}
        }
        return answer;
    }
    
  // 기존 방에 있는 인원들 count
    public void calCount(int[] answer, List<Integer> enterList) {
    	for(int i = 0 ; i < enterList.size() ; i++) {
    		answer[enterList.get(i)-1] += 1;
    	}
    }
   // 새로 들어온 member count 
    public void newCount(int[] answer, int enter, List<Integer> enterList) {
    	int size = enterList.size();
    	answer[enter-1] = size;
    }
}

