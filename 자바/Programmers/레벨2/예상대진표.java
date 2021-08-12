class Solution{
    public int solution(int n, int a, int b) {
    	
    	int answer = 0;
      
      // 동일한 대진표에 들어올때까지
    	while(b!=a) {
    		
        // 간단하게 홀수면 +1, 짝수면 몫그대로
        // 루프 돌린다.
    		if(a % 2 == 1) {
    			a= a/2+1;
    		}else if(a%2 == 0) {
    			a=a/2;
    		}
    		
    		if(b % 2 == 1) {
    			b= b/2+1;
    		}else if(b%2 == 0) {
    			b=b/2;
    		}
    		
    		answer++;
    		
    	}

        return answer;
    }
}
