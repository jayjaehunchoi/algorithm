import java.util.ArrayList;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String low_id = new_id.toLowerCase();
        ArrayList<Character> idList = new ArrayList<Character>();
        
        //step 2
        stepTwo(low_id, idList);
        
        
        //step 3
        ArrayList<Character> idListExceptDot = new ArrayList<Character>();
        
        idListExceptDot.add(idList.get(0));
        
        
        for(int i = 1 ; i < idList.size(); i++) {
        	if(idList.get(i-1) == 46 && idList.get(i) == 46 ) {
        		continue;
        	}
        	else {
        		idListExceptDot.add(idList.get(i));
        	}
        }
        
        //step 4
        if(idListExceptDot.get(0) == 46) {
         	idListExceptDot.remove(0);
    	 }
       
    	 if(idListExceptDot.size() >= 1) {
    		 if(idListExceptDot.get(idListExceptDot.size()-1) == 46) {
              	idListExceptDot.remove(idListExceptDot.size()-1);
              } 
    	 }
        
        //step 5 , 6
        if(idListExceptDot.isEmpty()) {
        	idListExceptDot.add('a');
        }
        else if (idListExceptDot.size() >= 16) {
        	int a = idListExceptDot.size();
        	for(int i = 15; i < a; i++) {
        		idListExceptDot.remove(15);
        	}
        	 if(idListExceptDot.get(14) == 46) {
        		 idListExceptDot.remove(14);
        	 }
        }
       
        
        //step 7
        if(idListExceptDot.size() <= 2) {
        	int a = idListExceptDot.size();
        	while(idListExceptDot.size() != 3) {
        		idListExceptDot.add(idListExceptDot.get(a-1));
        	}
        	for(int i = 0 ; i < idListExceptDot.size(); i++) {
        		answer += idListExceptDot.get(i);
        	}	
        }
        else {
        	for(int i = 0 ; i < idListExceptDot.size(); i++) {
        		answer += idListExceptDot.get(i);
        	}	
        }
  
        return answer;
    }
    
    private static ArrayList stepTwo (String low_id, ArrayList idList) {
    	
    	for(int i = 0 ; i < low_id.length(); i++) {
        	
        	char eachId = low_id.substring(i,i+1).charAt(0);
        	
        	if(eachId >= 48 && eachId <= 57 ) {
        		idList.add(eachId);
        	}
        	
        	else if(eachId >=97 && eachId <=122) {
        		idList.add(eachId);
        	}
        	else if(eachId == 45 || eachId == 46 || eachId == 95) {
        		idList.add(eachId);
        	}
        }
    	return idList;
    }
}
