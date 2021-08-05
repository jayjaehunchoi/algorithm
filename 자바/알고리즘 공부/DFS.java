class Solution {
  
  static int numberOfArea;
  static int maxSizeOfOneArea;
  
  static int count++;
  
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  
  public static void dfs(int x, int y, int[][]picture, boolean[][] check){
    
    if(!check[x][y]){
      return;
    }
    check[x][y] = true;
    count++;
    
    for(int i = 0; i <4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      
      if(nx < 0 || nx >= pictures.length || ny < 0 || ny >= pictures[0].length) continue;
      if(picture[nx][ny] == picture[x][y] && !check[nx][ny]{
        dfs(nx,ny,picture,check);
      }
  
  public int[] solution(int m, int n, int[][] picture) {
  
        numberOfArea =0;
        maxSizeOfOneArea=0;
    
        int[] answer = new int[2];
        
        boolean check = new boolean[m][n];
        
    for(int i = 0 ; i < m; i++){
      for(int j = 0 ; j < n ; j++){
        
        numberOfArea++;
        dfs(i,j,picture,check)
        
      if(count > maxSizeOfOneArea) {
        maxSizeOfOneArea = count;
      }
      
      count = 0;
      }
    }
        
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
      
  }

  
}
