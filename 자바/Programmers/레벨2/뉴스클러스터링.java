import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
    	
    	int gyoCount = 0;
    	double hapCount = 0;
    	
      // 조건에서 대소문자 가리지 않는다고 주었음, 소문자로 모두 변환
    	str1 = str1.toLowerCase();
    	str2 = str2.toLowerCase();

    	//List에 담아서 비교를 간단하게 해주겠음
    	List<String>str1Arr = new ArrayList<String>();
    	List<String>str2Arr = new ArrayList<String>();
      
      //List에 문자열을 2개씩 분철하여 담고, 
      //만약 특수문자나 공백을 포함하면 제거목적으로 각 0, 1로 변경하고 이후 합 구할때 문제없게 하기위해 빼줌
    	for(int i = 0 ; i < str1.length()-1 ; i++) {
    		str1Arr.add(str1.substring(i, i+2));
    		if(str1Arr.get(i).charAt(0) < 97 || str1Arr.get(i).charAt(0) > 122 || str1Arr.get(i).charAt(1) < 97 || str1Arr.get(i).charAt(1) > 122) {
    			str1Arr.remove(i);
    			str1Arr.add("0");
    			hapCount--;
    		}
    	}

    	for(int i = 0 ; i < str2.length()-1 ; i++) {
    		str2Arr.add(str2.substring(i, i+2));
    		if(str2Arr.get(i).charAt(0) < 97 || str2Arr.get(i).charAt(0) > 122 || str2Arr.get(i).charAt(1) < 97 || str2Arr.get(i).charAt(1) > 122) {
    			str2Arr.remove(i);
    			str2Arr.add("1");
    			hapCount--;
    		}
    	}

    	hapCount += (str1Arr.size() + str2Arr.size()); 
    	
      // 중복도 가능, 똑같은거 찾으면 지워주기
    	for(int i = 0 ; i < str1Arr.size() ; i++) {
    		if(str2Arr.contains(str1Arr.get(i))) {
    			gyoCount++;
    			str2Arr.remove(str2Arr.indexOf(str1Arr.get(i)));			
    		}
    	}
      
      // 만약 모든 값이 같으면 65536 출력
    	if(gyoCount == hapCount) {
    		return 65536;
    	}

        int answer = (int)((gyoCount / (hapCount-gyoCount))*65536);
    	
        return answer;
    }
}
