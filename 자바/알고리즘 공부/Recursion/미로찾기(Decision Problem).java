public class Main{
 
  static int N = 4;
  static int M = 6;
  static int maze[][] = {{1,0,1,1,1,1},{1,0,1,0,1,0},{1,0,1,0,1,1},{1,1,1,0,1,1}}
  
  
  // 탈출 가능하면 true를 내보내는 메서드
  // 이걸로 최소값 계산은 못한다..
  // else 조건문에서 계속해서 루프가 돈다.
  public static boolean findMaze(int x, int y){
    if( x < 0 || y < 0 || x >= N || y >= M || maze[x][y] != 1){
      return false;
    }
    else if(x == N && y == M){
      maze[x][y] = 3;
      return true;
    }
    else { 
      maze[x][y] = 3;
      if(findMaze(x-1,y) || findMaze(x,y+1) || findMaze(x+1,y) || findMaze(x,y-1)){
        return true;
      }
      
      maze[x][y] = 2;
      return false;
    }
    
    public static void main(Strings[] args){
      findMaze(0,0);
    }
  }
      
