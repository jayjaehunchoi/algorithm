import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         
         int[][][] dp = new int[n+1][2][3];
         
         dp[1][0][0] = 1;
         dp[1][1][0] = 1;
         dp[1][0][1] = 1;
         int answer = 3;
         
         if(n == 1) {
        	 System.out.println(answer);
        	 return;
         }
         
         for(int i = 2; i <= n ;i++) {
        	 dp[i][0][0] = dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2];
        	 dp[i][0][1] = dp[i-1][0][0];
        	 dp[i][0][2] = dp[i-1][0][1];
        	 dp[i][1][0] = answer;
        	 dp[i][1][1] = dp[i-1][1][0];
        	 dp[i][1][2] = dp[i-1][1][1];
        	 answer = 0;
        	 for(int j = 0 ; j < 2; j++) {
        		 for(int k = 0 ; k < 3; k++) {
        			 dp[i][j][k] %= 1000000;
        			 answer += dp[i][j][k];
        		 }
        	 }
        	 answer %= 1000000;
         }
         
        System.out.println(answer);
         
    }
  
}
