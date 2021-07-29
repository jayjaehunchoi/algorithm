
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
    	String answer = "";
    	
      // hashmap을 통해 사람이름을 key로 관리하고 수는 (중복이 있기 때문) Value로 관리
    	 HashMap<String, Integer> cache = new HashMap<String, Integer>();
         
         // 중복이 있는지 살펴볼 수 있는 participant hashmap을 만드는 것.
         for(int i = 0 ; i < participant.length; i++) {
       	  if(0 < cache.getOrDefault(participant[i], 0)) {
       		  cache.replace(participant[i], cache.get(participant[i])+1);
       	  }
       	  else {
       		  cache.put(participant[i], 1);
       	  }
          // 여기까지 각 참가자는 Key에 담겨진 상태이고 if 중복이 있다면 그 value는 1 over임 중복 없으면 1.
         }
      
          //이제 completion에 존재하는 동일한 이름을 바탕으로 완주했으면, Value를 -1 해줄 거임.
          // 여기서 중복자가 모두 완주했으면 - 중복자 수만큼 됨.
         for(int i = 0 ; i < completion.length; i++) {
       	  if(0 < cache.get(completion[i])) {
       		  cache.replace(completion[i], cache.get(completion[i])-1);
       	  }
         }
      
        // key와 value가 모두 필요하기때문에 Entry와 Entryset으로 하였음.
        // 0보다 크면 완주를 못했다는 뜻임, 거기의 value값 가져오면 됨.
         for(Map.Entry<String, Integer> item: cache.entrySet()) {
       	  if(0<item.getValue()) {
       		  answer = item.getKey();
       	  }       	 
         }
		return answer;
       }
   }

/*
처음에 ArrayList로풀었으나 효율성 케이스에서 한문제도 맞지 못함.
그러다 HashMap 발견.!
이후 알고리즘 문제 해결할 때, String값의 개수를 비교하는 문제가 나온다면 HashMap사용하기

[[주요 함수]]
HashMap<String, Integer> cache = new HashMap<String, Integer>(); // 해시맵 선언
cache.get(keyname) -> Value가져옴
cache.getOrDefault(keyname, 0) -> keyname이 있으면 그 Value를 가져오고 아니면 우측의 0 가져옴
cache.put(keyname, value) ->  keyname과 value선언
cache.replace(keyname, new value) -> keyname의 value값을 new value로 선언

for(Map.Entry<String, Integer> item: cache.entrySet()) {
    	  if(0<item.getValue()) {
    		  System.out.println(item.getKey());
    	  }
        Entry선언을 해줘야 getKey, getValue가 가능 , 대신 우항도 entrySet선언해주기!
        if cache.values() 라면 좌항은 자료형 + 변수
        if cache.keySet() 라면 좌항은 자료형 + 변수
        
*/        
