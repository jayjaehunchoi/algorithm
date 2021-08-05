import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  
    public String[] solution(String[] record) {
      
      // 너무 비효율적이지만 떠오르지 않았다.. list두개와 map하나..
	ArrayList<String> names = new ArrayList<String>();
	    
     	ArrayList<String> answerBef = new ArrayList<String>();
	      /// 해시맵을 통해 id값에따라 변경되는 이름을 조정해준다.
        HashMap<String, String> hMap = new HashMap<String, String>();
	        
	        int count = 0;
	        for(int i = 0 ; i < record.length; i++) {
	        	String[] s = record[i].split(" ");
	        	
            //Enter과 Leave를 다른 문자열로 치환해주는 작업
	        	if(s[0].equals("Enter")) answerBef.add("님이 들어왔습니다.");
	        	else if (s[0].equals("Leave")) answerBef.add("님이 나갔습니다.");
	        	
            //나갔습니다는 따로 이름이 나오지 않아 이를 제외하고 Map에 넣어준다.
	        	if(!hMap.containsKey(s[1]) && !s[0].equals("Leave") ) {
	        		hMap.put(s[1], s[2]);
	        		
	        	}
	        	else if(!s[0].equals("Leave") ){
	        		hMap.replace(s[1], s[2]);
	        		
	        	}
            
            // Change도 고려해준다, 따로 표시되지 않기때문에 answer에서 제외된다.
	        	if(!s[0].equals("Change")) {
	        		names.add(s[1]);
	        		
	        	}
	        	else if(s[0].equals("Change")) {
	        		count++;
	        	}
	        	
	        }
      
      // 여기서 이름 배열, 맵, Enter Leave 배열을 합쳐준다. 
	        String[] answer = new String [record.length - count];
	       for(int i = 0; i < record.length - count ; i++) {
	    	   answer[i] = hMap.get(names.get(i)) + answerBef.get(i);
	       }
	       
        return answer;
    }
}




