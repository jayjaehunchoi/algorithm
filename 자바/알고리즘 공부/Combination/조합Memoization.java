class Main {

  // n 은 임의의 제한하는 수
  static int[][] dp = new int[n + 1][n + 1];
  
  static int comb(int n, int r) {
    
    // comb의 개수를 구할 떄 이미 계산된 부분이라면 memoization을 통해 해결이 가능하다.
    // 면접에서 개선할 수 있는 방법으로 설명한 내용을 실제로 구현해 봄.
    if(dp[n][r] > 0) {
      return dp[n][r];
    }
    if(r == 0 || n == r) {
      return dp[n][r] = 1;
    }
    
    return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
  }
}
