
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4 7
6 13
4 8
3 6
5 12
*/

class Main{


    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine(), " ");
      
    	int n = Integer.parseInt(st.nextToken()); // 개수
    	int j = Integer.parseInt(st.nextToken()); // 제한 무게
    	
    	int[][] dp = new int[n+1][j+1];
    	int[] w = new int[n+1]; // 각 물품별 무게
    	int[] v = new int[n+1]; // 각 물품별 가치
    	
    	for(int i = 1; i <= n; i++) { // 단순하게 넣는 순서라고 생각해보자
    		st = new StringTokenizer(br.readLine(), " ");
    		w[i] = Integer.parseInt(st.nextToken()); // 6 > 4 > 3 > 5     
    		v[i] = Integer.parseInt(st.nextToken()); // 13 > 8 > 6 > 12	
    	}
    	
      
    	for(int i = 1; i <= n ; i++ ) {
    		for(int k = 1 ; k <= j ; k++) {
          // 지금 넣는 무게가, 내가 정한 제한 무게보다 무거울때,
          // 무게가 3제한일때  3의 val값을 넣었다. 4를 넣으려하면? 안된다. 현재 무게를 유지하자
    			if(w[i] > k) {
    				dp[i][k] = dp[i-1][k];
    			}
          // 만약 현재 무게에 추가할 수 있다면?
          // 지금 내가 넣어놓은 무게와 새롭게 들어올 무게 + 그 이전에 넣어놨었던 무게를 더한값을 비교해보자
    			else {
    				dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k-w[i]]+v[i]);
    			}
    			
    		}
    	}
    	System.out.println(dp[n][j]);
    }
    	
    	
    
}
