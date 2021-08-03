
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


class Solution {
    public int solution(String[][] clothes) {
    	int answer = 1;
        
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();
        ArrayList<Integer> aList = new ArrayList<Integer>();
        
      // 경우의 수들을 만들기 위한 준비
        for(int i = 0 ; i < clothes.length; i++) {
        	if(!hMap.containsKey(clothes[i][1])) {
        		hMap.put(clothes[i][1], 1);
        	}
        	else {
        		hMap.replace(clothes[i][1], hMap.get(clothes[i][1])+1);
        	}

        }
        // 경우의 수 구하는 법
        // 상의 1개, 하의 2개, 양말 3개가 있을때,
        // 경우의 수는 1* (1+1) * (2+1) * (3+1) -1 이다
        // -1은 아예 안고르는 경우.
        for(Integer m : hMap.values()) {
        	aList.add(m);
        }
        Collections.sort(aList);
        
        if(aList.size() > 1) {
        	for(int i : aList) {
        		answer *= i+1;
        	}
        	answer --;
        	
        }
        else if (aList.size() == 1) {
        	answer += aList.get(0) -1 ;
        }
        
        return answer;
    }
}
