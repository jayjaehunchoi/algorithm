import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	
  // 맵을 담을 수 있는 리스트를 하나 생성
	List<Map<String, Integer>> maps = new ArrayList<>();
	// 문제 조건상 어차피 최대 10개까지밖에 못오기 때문에 배열 제한 줄 수 있음.
  int[] max = new int[11];
	
  
  //조합 짜는 코드
	void comb(char[] str, int pos, StringBuilder candi) {
		
    // pos가 str의 length와 같아질 때, 재귀를 종료하고 리스트의 맵에 넣어준다
    if(pos >= str.length) {
			int len = candi.length();
			if(len >= 2) {
				int cnt = maps.get(len).getOrDefault(candi.toString(),0) +1;
				maps.get(len).put(candi.toString(), cnt);
				max[len] = Math.max(max[len], cnt);
			}
			return;
		}
		
    // 계속 더해진다
		comb(str,pos+1,candi.append(str[pos]));
		// 더해진값을 제거해준다
    candi.setLength(candi.length() - 1);
		// 본인, 결국 끝까지 본인이다가 자기자신을 출력한다.
    comb(str,pos+1,candi);
		
	}
	
    public String[] solution(String[] orders, int[] course) {
        
    	for(int i = 0 ; i < 11 ; i++) {
    		maps.add(new HashMap<String, Integer>());
    	}
    	
    	for(String str : orders) {
    		char[] arr = str.toCharArray();
    		Arrays.sort(arr);
    		comb(arr,0,new StringBuilder());
     	}
    	
      //두명이상이 주문하고, 길이별 max와 같으면 정답 리스트에 넣어준다.
    	List<String> list = new ArrayList<>();
    	for(int len : course) {
    		for(Map.Entry<String, Integer> ent : maps.get(len).entrySet()) {
    			if(ent.getValue() >= 2 && ent.getValue() == max[len]) {
    				list.add(ent.getKey());
    			}
    		}
    	}
    	Collections.sort(list);
    	
    	String[] answer = new String[list.size()];
    	for(int i = 0 ; i < list.size() ; i++) {
    		answer[i] = list.get(i);
    	}
        return answer;
    }
}
