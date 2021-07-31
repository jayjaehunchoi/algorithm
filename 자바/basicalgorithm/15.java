class Solution {
    public long solution(long n) {
        long answer = 0;
        
      // 제곱근이 정수라면 소수점이 있든 없든 값이 같아야함
        if((long)Math.sqrt(n) == Math.sqrt(n)){
        	return (long)Math.pow((long)Math.sqrt(n)+1, 2);
        }
        
        else {
        	return -1;
        }
    }
}
