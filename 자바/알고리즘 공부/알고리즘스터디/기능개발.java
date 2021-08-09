import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	 public ArrayList solution(int[] progresses, int[] speeds) {
		 
		 ArrayList<Integer> answer = new ArrayList<Integer>();

			Queue<Integer> nque = new LinkedList<Integer>();

			 for(int a: progresses) {
				 nque.add(a);
			 }
			 
     // 어디까지 빠졌는지 개수를 주기 위해.
			 int n = 0 ;
			 
			 while(nque.size() != 0) {
			
				int count = 0;
				nque.clear();
				
				for(int i = n ; i < progresses.length ; i++) {
					 progresses[i] += speeds[i];
					 nque.add(progresses[i]);
				}
				
         // peek가 100이 되는 순간부터 쭉 돌면서 100을 찾아낸다.
				while(nque.peek() >= 100) {
					
					nque.poll();
					count++;
					n++;
					if(nque.size() == 0) {
						break;
					}
					
				}

				if(count > 0 ) {
					answer.add(count);
				}
		 
		
			 }
			 return answer;
	 }
}
