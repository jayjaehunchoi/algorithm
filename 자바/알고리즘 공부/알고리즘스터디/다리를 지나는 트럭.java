import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	
        int answer = 0;
      
      // 대기열, 지나는 트럭, 지나간 트럭으로 관리.
        Queue<Integer> crossing = new LinkedList<Integer>();
        Queue<Integer> waiting = new LinkedList<Integer>();
        ArrayList<Integer> crossed = new ArrayList<Integer>();
        
      // 빈 다리를 0으로 선언해줌
        for(int i = 0 ; i < bridge_length; i++) {
        	crossing.add(0);
        }
        
        for(int i = 0 ; i < truck_weights.length ; i++) {
        	waiting.add(truck_weights[i]);
        }
        
        // 지나간 트럭의 대수가 모든 트럭수와 같아질때까지
        while(crossed.size() != truck_weights.length ) {
       
          // 지나는 중인 트럭들의 무게와, 지나간 트럭 변수 생성
        	int crossing_weights = 0;
        	int crossedTruck = 0;
        	
          // 트럭이 움직이는 것을 poll로 표현
        	crossedTruck = crossing.poll();
        	
          // 다리위에 있는 트럭들의 무게
        	for(int i : crossing) {
        		crossing_weights += i;
        	}
          // 대기열이 0이 아니라면
        	if(!waiting.isEmpty()) {
          
            // 현재 다리의 무게와 새로 들어올 트럭의 무게 비교 작으면 트럭넣고
            // 크면 빈다리를 넣어준다.
            // 어떤 방법이든 트럭이 움직인 것이기때문에 1을 추가해준다.    
	        	if(crossing_weights + waiting.peek() <= weight ) {
	        		
	        		crossing.offer(waiting.poll());
	        		answer++;
	        		
	        	}
 
	        	else if(crossing_weights + waiting.peek() > weight ){
	        		        		
	        		crossing.offer(0);
	        		answer++;

	        	}
        	}
        	
          // 대기열이 0이더라도 다리위에는 남은 트럭이 움직인다
          // 굳이 0은 안추가해줘도 되지만 컨셉에 맞게..
        	else {   		
        		crossing.offer(0);
        		answer++;
        	}
        	
          // 빠져나간 녀석이 빈다리가 아니라 트럭이라면
          // 지나간 트럭 리스트에 추가해준다.
          // 모두다 지나가면 반복문이 멈춘다.
          if(crossedTruck > 0) {
        		crossed.add(crossedTruck);
        		
        	}
        	
        }
        
        return answer;
    }
}


