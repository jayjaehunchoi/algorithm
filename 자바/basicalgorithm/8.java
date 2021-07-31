class Solution {
    public long[] solution(int x, int n) {
        
    	long[] answer = new long[n];
        
       
        	for(int i = 1 ; i <= n; i++) {
        
                //  곱하면 자료형 int안에 포함 안될 수 있다.
        	answer[i-1] = (long)x*i;
        	}
        
        return answer;
    }
}
