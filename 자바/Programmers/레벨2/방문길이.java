class Solution {

    public int solution(String dirs) {
    	
    	int answer = 0;
    	
    	int[][] maps = new int[11][11];
    	boolean[][][][] check = new boolean[11][11][11][11];
    	int[] moversX = {-1,1,0,0};
    	int[] moversY = {0,0,1,-1};
    	
      // 4차 배열 이전까지는 누구나 생각할 수 있는 수준인것같다,
      // 나같은 경우에도 새로운 점에만 방문을찍어줬는데, 이 문제는 "길"이 핵심이라 
      // 같은 길을 걸으면 안되는 부분이었다.
      int x = 5;
      int y = 5;

      int nextX = 5;
      int nextY = 5;

      int index = 0 ;
      for(int i = 0 ; i < dirs.length() ; i++) {

        x = nextX;
        y = nextY;

        switch (dirs.charAt(i)) {
        case 'U': 
          index = 0;
          nextX += moversX[0];
          break;
        case 'D':		
          index = 1;
          nextX += moversX[1];	
          break;
        case 'R':
          index = 2;
          nextY += moversY[2];	
          break;
        case 'L':
          index = 3;
          nextY += moversY[3];	
          break;
        }
        
        // 지도 바깥으로 넘어가면 다시 제자리로 돌아와서 반복문 실행
        if(nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10) {
          nextX -= moversX[index];
          nextY -= moversY[index];
          continue;
        }
			// 중복 길
			if(!check[x][y][nextX][nextY] && !check[nextX][nextY][x][y]) {
				check[x][y][nextX][nextY] = true;
				check[nextX][nextY][x][y] = true;
				answer++;
			}
	
		}
		
        return answer;
    }
}
