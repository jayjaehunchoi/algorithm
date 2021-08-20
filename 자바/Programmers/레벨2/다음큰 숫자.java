class Solution {
	
  // 내 풀이는 아니지만 문제를 푼뒤 다른 정답을 보니
  // 이풀이가 너무 간단해서 가져와봄
  // Integer 클래스의 bitcount 라는 메서드가 있음
   
	public static int counting(int n) {
		
		int a = Integer.bitCount(n);
		int compare = n+1;
		
		while(true) {
			if(Integer.bitCount(compare)== a)break;
			compare++;
		}
		
		return compare;
		
	}
	
    public int solution(int n) {
        int answer = 0;
        
        
        return counting(n);
    }
}
