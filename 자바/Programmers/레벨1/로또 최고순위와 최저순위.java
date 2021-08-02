import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
       
      // 최저 순위, 최고 순위 개수 카운트
        int count = 0;
        int maxcount = 0;
      
      // 갖고있는 번호와 당첨번호를 함께 넣어 저장할 map
        HashMap<Integer, Integer> winnerMap = new HashMap<Integer, Integer>();
      
        winnerMap.put(0, 0);
        
        for(int i = 0 ; i < win_nums.length ; i++) {
        	winnerMap.put(win_nums[i], 1);
        }
        
        for(int i = 0 ; i < lottos.length ; i++ ) {
        	if(winnerMap.containsKey(lottos[i])) {
        		winnerMap.replace(lottos[i], winnerMap.get(lottos[i])+1);
        	}
        	else {
        		winnerMap.put(lottos[i], 0);
        	}
        }
        
      // 값이 1이상이면서 키가 0이 아닌 놈들은 먼저 카운트
        for(Map.Entry<Integer, Integer> map : winnerMap.entrySet()) {
        	if(map.getValue() > 1 && map.getKey() != 0) {
        		count++;
        		maxcount++;
        	}
        // 최대값은 0이 모두 당첨일때, 최소값은 0이 모두 미당첨일때
        	if(map.getKey() == 0) {
        		maxcount += map.getValue();
        	}
        }
        
      // 등수로 표현해야 하니 계산식을 만들어줌.
        int[] answer = new int[2];
     
      // 0, 1개만 정답이면 6등 그래서, 0을 1로 치환
        if(maxcount == 0) {
        	maxcount = 1;
        }
        
        if(count == 0) {
        	count = 1;
        }
        
        answer[0] = 7 - maxcount;
        answer[1] = 7 - count;

        return answer;
    }
}

/*
문제해결시간 20분 조금 안걸림.
*/
