class Solution {
    public int solution(int n) {
        int answer = 0;
        
      // 가장 큰 약수는 그 수의 절반임.
        for(int i = 1; i <= n/2 ; i++) {
        	if(n % i == 0) {
        		answer += i;
        	}
        }
        // 본인만 더해주면 끝
        return answer+n;
    }
}
