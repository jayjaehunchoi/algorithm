
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
      // 자동으로 오름차순 Sort된다.
        PriorityQueue<Integer> foods = new PriorityQueue<Integer>();
        
        for(int e : scoville) {
        	foods.add(e);
        }
        
      // 첫값이 K보다 작을때까지
        while(foods.peek() < K) {
        
          // 이제 더이상계산할 수 없는 상태
          // 한개남았는데 반복문이 더 실행된다는 것은 K보다 작다는 이야기
        	if(foods.size() < 2) {
        		return -1;
        	}
        	
          // 뺀값을 return 해주기 때문에 빼면서 변수에 넣어준다.
        	int s1 = foods.poll();
        	int s2 = foods.poll();
        	
          // 맨 앞 두 변수의 크기를 비교해줘야 함.
        	if(s1 > s2) {
        		int newS = s2 + s1*2;
        		foods.offer(newS);
        		answer++;
        	}
        	else {
        		int newS  = s1 + s2*2;
        		foods.offer(newS);
        		answer++;
        	}
        	
        }
        return answer;
    } 
}
