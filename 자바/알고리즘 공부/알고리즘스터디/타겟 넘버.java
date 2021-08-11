class Solution {
	
	static int answer = 0;
	
  
  // 경우의수가 5*10* .... 쭉늘어가는 두개씩 갈리는 그런 문제라고 볼 수 있다
  // 그럼 나도 두개씩 갈라서 계속 계산해주면 된다.
	public static void findTarget(int[] numbers, int target, int sum, int i ) {
		
		if(i == numbers.length) {
			if(sum == target) {
				answer++;
			}	
			return;
		}
		
		findTarget(numbers, target, sum + numbers[i], i+1);
		findTarget(numbers, target, sum - numbers[i], i+1);
		
	}
	
	
    public int solution(int[] numbers, int target) {
        
        
        findTarget(numbers, target, numbers[0], 1);
        findTarget(numbers, target, -numbers[0], 1);
        
        
        return answer;
    }
}
