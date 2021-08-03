class Solution {
    public String solution(int n) {
        String answer = "";
        
        int remainder = 0;
      //효율성때문에 사용
      StringBuffer sb = new StringBuffer();
      
      
      // 3진법이기 때문에 3진법과 같은 공식을 사용
      // 하지만 0이아니라 4를 사용해줘야한다.
      // 0을 4로 바꿔줄때는 0,1,2 순이 아닌 1,2,4 순으로 진행되기때문에 몫에서 --해줌.
        while ( n != 0) {
        	remainder = n % 3;
        	n /= 3;
        	
        	if(remainder == 0) {
        		remainder = 4;
        		n--;
        	}
        	
        	sb.append(remainder);
        }
       answer = sb.reverse().toString();

        return answer;
    }
}
