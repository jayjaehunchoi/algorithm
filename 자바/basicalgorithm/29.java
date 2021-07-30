class Solution {
   
	public String solution(String s, int n) {
        
    	String answer = "";
       
    // 아스키 코드를 사용하기위해 각 문자열로 나눠줄 배열을 만듦
    	char[] alpArr = new char[s.length()];
        
    // 배열에 한자리씩 put (이때 꼭 char사용)
        for(int i = 0; i < s.length(); i++) {
        	alpArr[i] = s.substring(i,i+1).charAt(0);
        	}
      
    // 먼저 공백에 대해 조건문을 걸어준다, 그리고 계산
    // 계산 후 대문자는 대문자끼리, 소문자는 소문자끼리 반복으로 돌 수 있도록 조건문을 달아준다. 
        for(int i = 0 ; i < alpArr.length; i++) {
        	
        	if(alpArr[i] == 32) {
        		alpArr[i] = 32;
        	}
        	else {        		
        		alpArr[i] += n;
        	}
        	
        	if(alpArr[i] - n <= 90 && alpArr[i] > 90) {
        		alpArr[i] = (char) (64 + (alpArr[i] - 90));
        	}
        	
        	else if(alpArr[i] - n  <= 122 && alpArr[i] > 122) {
        		alpArr[i] = (char) (96 + (alpArr[i] - 122));
        	}	
        	answer += alpArr[i];
        }
        return answer;
    }
}

/*
간단한 문제였다. 보자마자 아스키코드가 떠올랐고 바로 코드를 치기 시작했다.
처음엔 더하는 수 n의 크기를 고려하지 않고 z > a 로 가는 조건문만 걸었다가,
n이 최대로 커지면 해당 조건문에 문제가 생겨 다시 수정하였다.
*/
