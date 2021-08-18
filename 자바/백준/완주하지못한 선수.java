
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> maps = new HashMap<String, Integer>();
        
        for(int i = 0 ; i < participant.length ; i++) {
        	
    		maps.put(participant[i], maps.getOrDefault(participant[i], 0) +1 );

        }
        
        for(int i = 0 ; i < completion.length ; i ++) {
        	
        	if(maps.containsKey(completion[i])) {
        		maps.replace(completion[i],maps.get(completion[i]) - 1);
        	}
        	
        }
        
        for(Entry<String, Integer> e : maps.entrySet()) {
        	if(e.getValue() > 0) {
        		answer = e.getKey();
        	}
        }
        
        
        return answer;
    }
}
