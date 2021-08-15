import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> wordList = new ArrayList<String>();
        
      //간단하게 list에 담아가면서 비교하는 방법
        for(int i = 0 ; i < words.length ; i++) {
        	if(wordList.contains(words[i])) {
            answer[0] = i%n +1;
            answer[1] = i/n +1;
            return answer;
		    	}
    		
    		if(wordList.size()>=1) {
    			if(wordList.get(wordList.size()-1).charAt(wordList.get(wordList.size()-1).length()-1) != words[i].charAt(0)) {
    				answer[0] = i%n+1;
    				answer[1] = i/n +1;
    				return answer;
    			}
    			
    		}
    		wordList.add(words[i]);
        }
     
        
        answer[0] = 0;
		    answer[1] = 0;

        return answer;
    }
}
