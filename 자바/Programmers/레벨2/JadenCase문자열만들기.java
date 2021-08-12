class Solution {
    public String solution(String s) {
      
    	String answer = "";
      
      // 모든 문자를 소문자로 먼저 만들어준다
    	s = s.toLowerCase();
      //ascii 코드 사용할거다 (a~z 97 ~ 122 / A~Z 65 ~ 90)
        char[] a = s.toCharArray();
        
        for(int i = 0; i < a.length ; i++) {
        	if(i >= 1 && a[i-1] == 32 && a[i] >= 97 && a[i] <= 122) {
        		
        		a[i] = (char)(a[i] - 32);
        		
        	}
        	else if(i == 0 && a[i] >= 97 && a[i] <= 122) {
        		a[i] = (char)(a[i]-32);
        		
        	}
        	
        }
       
        answer = new String(a);
        
        return answer;
    }
}
