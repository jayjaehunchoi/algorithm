import java.util.Map.Entry;
import java.util.TreeMap;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        // 여기서 먼저 사전순으로 정렬하고 들어간다.
        TreeMap<String, Character> tMap = new TreeMap<String, Character>();
        
        // 비교해야할 n자리의 값을 value/ 딘어를 key에 넣어준다.
        for(int i = 0 ; i < strings.length; i++) {
			tMap.put(strings[i], strings[i].charAt(n));
		}
        // ascii 기준 z 는 122, 최소값 비교할 수있도록 z보다 1 큰 임의의 123수를 넣어준다.
        // 최소값이 될때마다 키를 바꿔 최종적으로 최소값이 나오면 key를 배열에 넣고 해당 value값을 임의의 123 이상 수로 넣어준다.
        for(int i = 0 ; i < strings.length; i++) {
        	int nums = 123;
        	String keys = "";
        	for(Entry<String, Character> m : tMap.entrySet()) {
            	if((int)m.getValue() < nums) {
            		nums = (int)m.getValue();
            		keys = m.getKey();
            		
            	}
            }
        	tMap.replace(keys, (char) 124);
        	answer[i] = keys;
        }

        return answer;
    }
}
