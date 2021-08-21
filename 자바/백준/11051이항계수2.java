// 동적프로그래밍을 통한 풀이만 시간초과 해결 가능

import java.util.Scanner;

class Main {
  
  static int[][] binos;
  
  public static int binomial(int n, int k){
    for(int i = 0; i <= n; i++){
      for(int j = 0 ; j <= i && j <= k ; j++){
        if(i == 0 || i == j || j == 0){
          binos[i][j] = 1;
        }else{
          binos[i][j] = (binos[i-1][j] + binos[i-1][j-1])%100007;
        }
      }
    }
    return binos[n][k] % 10007;
  
  }
  
  	public static void main(String[] args){
     
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      int k = sc.nextInt();
      
      binos = new int[n+1][k+1];
      
      System.out.println(binomial(n,k));
    }
}
	

