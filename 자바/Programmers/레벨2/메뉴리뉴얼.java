
import java.util.*;
import java.util.Map.Entry;

class Solution {
	
  // 각 메뉴 개수별 맵과 최대값 비교용 두가지
	static List<HashMap<String, Integer>> maps = new ArrayList<HashMap<String,Integer>>();
	static int count = 0;
	static int[] maxes = new int[11];
	
  // 컴비네이션 돌리기
	public static void combination(char[] eachOrder, int idx, StringBuilder sb ) {
		
		if(idx == eachOrder.length) {
			
			if(sb.length() >= 2) {
				int length = sb.length();
				maps.get(length).put(sb.toString(), maps.get(length).getOrDefault(sb.toString(),0)+1);
				count = maps.get(length).get(sb.toString());
				if(maxes[length] < count) {
					maxes[length] = count;
				}
			}
			return;
			
		}
		
		combination(eachOrder,idx +1, sb.append(eachOrder[idx]));
		sb.setLength(sb.length()-1);
		combination(eachOrder, idx+1, sb);
		
	}
	
	
    public String[] solution(String[] orders, int[] course) {
        
    	StringBuilder sb = new StringBuilder();
      
      // maps 세팅해주기
    	for(int i = 0 ; i < 11; i++) {
     	   maps.add(new HashMap<String, Integer>());
        }
    	
    	// 정렬해주고 컴비 돌려준다
    	for(int i = 0 ; i < orders.length ; i++) {
    		char[] eachOrder =  orders[i].toCharArray();
    		Arrays.sort(eachOrder);
    		combination(eachOrder, 0, sb);
    	}
    	
    	//maps세팅 끝
      //maps에서 최대값과 비교하여 최대값과 같은 애들 데리고 나온다,
      // 그런데 최대값이 1인경우도 있다 이는 조건에 부합하지 않아서 2이상조건도 걸어준다.
    	List<String> answerList = new ArrayList<String>();
    	for(int i : course) {
    		for(Entry<String, Integer> map : maps.get(i).entrySet()) {
    			if(map.getValue() == maxes[i] && map.getValue() >= 2 ) {
    				answerList.add(map.getKey());
    			}
    		}
    	}
      
      //리스트 > 배열로 담아주기
    	String[] answer = new String [answerList.size()];
    	Collections.sort(answerList);
    	for(int i = 0 ; i < answerList.size();i++) {
    		answer[i] = answerList.get(i);
    	}
    	

        return answer;
    }
}
