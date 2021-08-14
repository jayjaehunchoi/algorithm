import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
       Arrays.sort(people);
       
       int k = 0;
       
      // 항상 가장 작은 녀석과 최대한 큰녀석을 빼줘야 적은 보트를 쓸 수 있음
       for(int i = people.length-1 ; k <= i ; i--) {
    	   if(people[k] + people[i] <= limit)  k++;
    	   answer++;
       }
        
        return answer;
    }
}
