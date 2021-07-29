import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int minSum = 0;
        int hap = 0;
      
      // ex ) 정렬하여 3까지 더하면 3부서를 지원하는 최소값, 4까지 더하면 4부서를 지원하는 최소값
      // if 3까지 더한값 < 예산 < 4까지 더한값 이면 정답은 3!
      // 그래서 처음부터 배열을 순서대로 만들고 시작함.
        Arrays.sort(d);
        
        // budget보다 작을때 까지 계속 반복.
        // 그런데 끝까지 다 더해도 budget보다 작을 수 있으니 이점 유의.
        while (minSum < budget){
        	minSum = 0;
        	for(int i = 0 ; i <= hap; i++ ) {
        		minSum += d[i];
        	}
        	if (minSum <= budget) {
        		answer++;
        		hap++;
        	}
        	else {
        		return answer;
        	}
        	if (answer == d.length) {
        		break;
        	}
        }
        return answer;
        
    }
}

/*
코드를 짜는 것은 쉬웟지만 런타임 에러를 해결하는것이 조금 
*/
