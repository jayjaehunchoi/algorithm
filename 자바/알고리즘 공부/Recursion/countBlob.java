public class Main {
	
	static int[][] blob = {{1,0,0,0,0,0,0,1},
							{0,1,1,0,0,1,0,0},
							{1,1,0,0,1,0,1,0},
							{0,0,0,0,0,1,0,0},
							{0,1,0,1,0,1,0,0},
							{0,1,0,1,0,1,0,0},
							{1,0,0,0,1,0,0,1},
							{0,1,1,0,0,1,1,1}};
	
	
	static int N = 8;
  
  
  // Blob에서 색칠되어 있는 애들을 통해 recursion을 돈다
  // 만약 색칠 + 방문이면 다른색 색칠
  // 방문 ok > 그 8방 모두 확인 > 그 8방 모두확인 > ... > 최종 count
  public static int countBlob(int x , int y){
    if ( x < 0 || x >= N || y < 0 || y >= N){
      return 0;
    }
    
    else if (blob[x][y] != 1){
      return 0;
    }
    
    else {
      blob[x][y] = 2;
      return 1++ findBlob(x-1, y+1) + findBlob(x, y+1) + findBlob(x+1, y+1) 
					+ findBlob(x+1, y) + findBlob(x+1, y-1) + findBlob(x, y-1)
					+ findBlob(x-1, y-1) + findBlob(x-1, y);
      
    }
  }
  
 	public static void main(String[] args) {
		
		System.out.println(findBlob(4,5));
		
		
	}
