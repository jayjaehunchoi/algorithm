import java.util.ArrayList;

class Solution {
	
	// 재귀를 걸어서 마지막 전항까지 값을 구해줌
  // 첫번째 조건이 마지막 항을 포함하면 1이 더해지기때문에 
  // 마지막 항은 아예 반복에서 제외하고 마지막에 add해줌
	public static int findLower(int[] prices, int n, int m) {
		if(n == prices.length-1) {
			return 1;
		}
		
		if(m==n) {
			return findLower(prices, n+1, m);
		}
		
		if(prices[m] > prices[n]) {
			return 1;
		}
		
		return 1+findLower(prices, n+1, m);
	}
	
    public ArrayList solution(int[] prices) {
        
    	ArrayList<Integer> answer = new ArrayList<Integer>();
    	
    	for(int i = 0 ; i < prices.length-1 ; i++) {
    		
    		answer.add(findLower(prices,i,i));
    		
    	}
    	answer.add(0);
    	
        return answer;
    }
}
