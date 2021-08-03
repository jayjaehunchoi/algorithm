import java.util.TreeMap;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
	    
	// 혹시몰라서 일단 순서대로 key배열하려고..
        TreeMap<Integer, Integer> tMap = new TreeMap<Integer, Integer>();
        
	    // 먼저 잃어버린 친구들을 map에 넣어준다.
        for(int i = 0 ; i < lost.length ; i++) {
        	tMap.put(lost[i],1);
        }
        
	 // 여벌도 있으면서 잃어버린 친구들을 먼저 제외해준다, 
	 //이때 reserve에서는 이후 계산에 방해되지 않게 -1로 선언
        for(int i = 0 ; i < reserve.length; i++) {
        	if(tMap.containsKey(reserve[i])) {
        		tMap.replace(reserve[i], 0);
        		reserve[i] = -1;
        	}
        }
        
	
	    // +1번 -1번 을 빌려주는 작업
        for(int i = 0 ; i < reserve.length; i++) {
        	
    		if(tMap.containsKey(reserve[i]-1) && tMap.get(reserve[i]-1) == 1 ) {
        		tMap.replace(reserve[i]-1, 0);
        	}
        	
        	else if(tMap.containsKey(reserve[i]+1) && tMap.get(reserve[i]+1) == 1 ) {
        		tMap.replace(reserve[i]+1, 0);
        	}
        }
        
	    // 남아있는 Value만 n에서 빼면 정답
        for(int m : tMap.values()) {
        	answer -= m;
        }
        
        
        return answer;
    }
}
