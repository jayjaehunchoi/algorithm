import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main{


    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String com1 = br.readLine();
    	String com2 = br.readLine();
    	
    	char[] arr1 = new char[com1.length()+1];
    	char[] arr2 = new char[com2.length()+1];
    	int[][] dp = new int[arr2.length][arr1.length];
    	
    	
    	for(int i = 1 ; i <= com1.length(); i++ ) {
    		
    		arr1[i] = com1.charAt(i-1);
    		
    	}
    	for(int i = 1 ; i <= com2.length(); i++ ) {
    		
    		arr2[i] = com2.charAt(i-1);
    		
    	}
    	
      // 내가 그린그림과 똑같이 계산하려다보니 .. ㅋ
      // 자리를 반대로 줬다.
    	for(int i = 1; i <= com2.length(); i++) {
    		for(int j = 1; j<= com1.length(); j++) {
    			
          // 현재 값을 넣기 전의 이전 값 중 최대값이 바로 대각선 아래 값
    			if(arr2[i] == arr1[j]) {
    				dp[i][j] = dp[i - 1][j - 1] + 1;	
    			}
          
          // 다를 경우엔 이전 행 이전 열 중 큰 값, 둘중 최대값이 지금까지의 조합중 최대값이 될테니
    			else {
    				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    			}
    			
    		}
    	}
//    	for(int i = 1 ; i < dp.length; i++) {
//    		System.out.println();
//    		for(int j = 1; j < dp[0].length; j++) {
//    			System.out.print(dp[i][j] + " ");
//    		}
//    	}
    	System.out.println(dp[com2.length()][com1.length()]);
    	
    	
    }

}
