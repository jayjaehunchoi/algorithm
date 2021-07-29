
class Solution {
    public int solution(int n) {
        int answer = 0;
        
      // 0부터 숫자가 담기기때문에 n까지 숫자가 담기기 위해서는 n+1로 선언해줘야함.
        boolean [] arr = new boolean[n+1];
        
      // true는 소수가 아니다. (bool 선언했을때 기본이 false이기 때문에 true는 소수가 아니다로 선정)
      // 0과 1은 소수가 아님.
        arr[0] = arr[1] = true;
        
        // 2부터 계산 시작, "false는 소수다"라는 가정하에 시작.
        // 보통 n의 제곱근보다 작거나 같은 수까지 체크하면 모든 경우의 수를 다 보는 것임.
        // 소수인 경우에, 그 제곱부터 n까지 소수의 모든 배수는 소수가 아니다.(true)
        for(int i = 2; i*i <= n; i++) {
        	if(arr[i] == false) {
        		for(int j = i*i ; j <= n; j += i) {
        			arr[j] = true;
        		}
        	}
        	
        }
      //false (소수)인 녀석들 찾아서 더해주기
        for(int i = 1; i <= n ; i++) {
    		if(arr[i] == false) {
    			answer ++;
    		}
    	}
        
        return answer;
    }
}

/*
테스트케이스의 숫자가 적다면 일반 반복문으로도 해결이 가능하겠지만,
효율은 이 에라토스테네스의 체를 따라오지 못한다.
대충 이런 개념으로 소수를 구할 수 있을 것 같다고는 생각했지만 구현하는게 쉽지는 않았다.
이런 케이스가 있다는 것은 꼭 알아둘 것.
*/
