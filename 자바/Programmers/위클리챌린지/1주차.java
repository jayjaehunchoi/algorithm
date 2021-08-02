class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long totalPrice = 0;
        
        for(int i = 1 ; i <= count; i++) {
        	totalPrice += i;
        }
        totalPrice = totalPrice * price;
        
        if(money >= totalPrice) {
        	answer = 0;
        }
        else {
        	answer = totalPrice - money;
        }
        
        return answer;
    }
}

/*
등비수열의 합 공식을 이용해서 간단하게 해결할 수 있는 문제이다.
*/
