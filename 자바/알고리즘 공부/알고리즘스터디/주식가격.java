import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
  //큐를 사용해서도 q.peek()값과 나머지 값들 차례로 비교해가며
  // 가격이 떨어질 때 or 다 비교했을때까지 count하고 poll로 빼주면서
  // 반복문이 돌아가는 풀이도 있을 것 같다.
  
  //하지만 나는 재귀를 사용해서 문제를 해결했다.
	public static int finding(int[] prices, int x, int y) {
		
    // y가 렝쓰 이상일때 0을 리턴해주면서 재귀를 끝낸다.
    // 이 조건문이 없으면 outofbounds오류가 나올듯?
		if(y >= prices.length) {
			return 0;
		}
		
    // 가격이 떨어지는 그 순간도 count는 1이 증가해야한다.
    // 1로 리턴하며 재귀를 끝낸다.
		if(prices[x] > prices[y]) {
			return 1;
		}
		
		// 위 두 조건에 해당하지 않으면 계속 1씩 증가하며 재귀를 돌린다.
		return 1+ finding(prices,x,y+1);
	}
	
	
	 public ArrayList solution(int[] prices) {
		 
		 ArrayList<Integer> answer = new ArrayList<Integer>();
	
     //모든 수를 재귀함수로 돌려주기 위해
		 for(int i = 0 ; i < prices.length ; i++) {
			 
       //재귀값(카운트) 를 숫자로 입력받아 배열에 담아준다.
			 answer.add(finding(prices, i, i+1));

		 }
    	 return answer;
    }
}

