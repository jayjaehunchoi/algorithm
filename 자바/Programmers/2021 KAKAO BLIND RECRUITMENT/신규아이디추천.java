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


/*

어려운 문제는 아니었다. 하지만 다른사람들 풀이보니까 정규표현식을 사용하여 훨씬 짧고, 시간, 공간복잡도가 낮은 코드로 완성한 것을 볼 수 있었다.
정규표현식은 특정한 규칙을 가진 문자열을 제대로 입력했는지 검증할 때 주로 사용된다.

Pattern 과 Matcher 클래스가 있다.
ex ) String patterns = "^[0-9]*$" // 0부터 9까지
     String val = "12312412513565"
     Pattern.matches(pattern, val); > bool값으로 보면 true가 나올것이다.
     
이외에도 정규식을 활용한 replaceAll이 있다.

String new_id = ".asdqw...123@$#@!%..ADFWz...zcSSDFx%)(^.";
new_id = new_id.toLowerCase(); // 일단 소문자로 변환
new_id = new_id.replaceAll("[^-_.a-z0-9]",""); // []내의 값을 제외(^이 []처음에 올때를 제외라고 하는 듯)하고 모두 ""로 변환
new_id = new_id.replaceAll("^[.]|[.]$", ""); //처음이 [.] 이거나 끝이 [.]이면 ""으로 변환
new_id = new_id.replaceAll("[.]{2,}", "."); // [.]이 연속 두개 이상인것을 찾아서 .으로 교체

*/



