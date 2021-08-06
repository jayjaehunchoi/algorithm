class Solution {
  
  public static int bfs(int[] numbers, int target, int sum, int i){
    if(i == numbers.length){
      if(sum == target){
        return 1;
      }
      else{
        return 0;
      }
      
      int result = 0;
      //엄밀히말하자면 이 두줄에서만 재귀가 돈다. 바로위에 result 0 을선언하든 말든 상관없다.
      result += bfs(numbers, target, sum+numbers[i], i+1);
      result += bfs(numbers, target, sum-numbers[i], i+1);
      
      return result;
      
   public int solution(int[] numbers, int target) {
    	int answer = 0;
      
      answer = bfs(numbers, target, numbers[i], 1) + bfs(numbers, target, -numbers[i], 1);
     
      return answer;
    }
\
}
