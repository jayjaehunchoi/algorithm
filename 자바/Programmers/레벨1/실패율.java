import java.util.Map.Entry;
import java.util.TreeMap;

class Solution {
    public int[] solution(int N, int[] stages) {
    	int[] answer = new int [N];
       
      // key를 오름차순으로 넣어주기 위해 TreeMap사용
      TreeMap<Integer, Double> hMap = new TreeMap<Integer, Double>();
        
      int num = stages.length;
      int stage = 1;
       
       
        // 각 단계별 반복
        while (stage <= N) {
        	double count = 0 ;
        	double failure = 0 ;
        	for(int i = 0 ; i < stages.length; i++) {
            	if(stages[i] == stage) {
            		count++;
            	}
            }
          // 여기서 분모가 0이 되는 것을 주의해야 한다.
          // 만약 분모가 0이면 계산값이 nan으로 나와 내림차순 비교군에 속하지 못함.
        	failure = count/num;
        	if(num == 0) {
        		failure = 0.0;
        	}
        	hMap.put(stage, failure);
        	num -= count;
        	stage++;
        }
        
      // 내림차순으로 배열에 넣는 작업
        for(int i = 0 ; i < N; i++) {
        	double maxfail = -0.1;
 	        int maxfailkey = 0;
        	for(Entry<Integer, Double> m : hMap.entrySet()) {
        		if(m.getValue() > maxfail) {
        			maxfail = m.getValue();
        			maxfailkey = m.getKey();	
        		}
        	}
        	hMap.remove(maxfailkey);
        	answer[i] = maxfailkey;
        }
        return answer;
    }
}
