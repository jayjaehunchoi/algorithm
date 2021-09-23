import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static boolean isPrime(int score) {
		if(score == 0 || score == 1) return false;
		for(int i = 2; i*i <=score ; i++) {
			if(score % i == 0)return false;
		}
		return true;
		
	}
    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         double aGoal = Integer.parseInt(br.readLine());
         double bGoal = Integer.parseInt(br.readLine());
         
         double aNo = (100 - aGoal)/100;
         double bNo = (100 - bGoal)/100;
         
         double a = aGoal/100;
         double b = bGoal/100;

         double[][][] dp = new double[19][19][19];
        
         dp[0][0][0] = 1.0;
         for(int i = 1; i <= 18; i++) {
        	for(int j = 0 ; j <= i  ; j++) {
        		for(int k = 0 ; k <= i; k++) {
        			if(j>0)dp[i][j][k] += dp[i-1][j-1][k] * a * bNo;
        			if(k>0)dp[i][j][k] += dp[i-1][j][k-1] * aNo * b;
        			if(j>0 && k>0) dp[i][j][k] += dp[i-1][j-1][k-1] * a * b;
        			dp[i][j][k] += dp[i-1][j][k] * aNo * bNo;
        		}
        	}
         }
         
         double ans = 0;
         for(int i = 0 ; i <= 18; i++) {
        	 for(int j = 0 ; j <= 18; j++) {
        		 if(isPrime(i) || isPrime(j))ans += dp[18][i][j];
        	 }
         }
         
         System.out.printf("%.16f", ans);
    }
  
}
