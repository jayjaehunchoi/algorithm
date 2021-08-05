class Solution {
	
	  static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;
    
    static int count = 0;
    
  // 상하좌우 비교위한 배열
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public static void dfs(int x, int y, int[][] picture, boolean[][] check) {
    	
      // 방문했으면 재귀 끝
    	if(check[x][y]) {
    		return;
    	}
      //아니면 방문체크
    	check[x][y] = true;
      //내 영역부터 늘리고 시작
    	count++;
    	
      //상하좌우 반복문
    	for(int i = 0 ; i < 4 ; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
        // 이 조건에 맞으면 다시 반복문처음으로
    		if(nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {
    			continue;
    		}
        //체크도 안됐고 숫자도 같으면 재귀 (숫자늘리러)
    		if(picture[nx][ny] == picture[x][y] && !check[nx][ny]) {
    			dfs(nx,ny,picture,check);
    		}
    	}
    }
    
    
    public int[] solution(int m, int n, int[][] picture) {
        
        //staiic 선언후 초기화 해줘야한다.(그래야 채점잘됨 ;;)
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        
        // 체크 불리언 만들어주고
        boolean[][] check = new boolean[m][n];
        
      // 모든 배열검사, 재귀로(재귀는 어차피 한 묶음들만 계산하기떄문에 전체 돌면서 묶음 몇개인지 카운트)
        for(int i = 0 ; i < m; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		if(picture[i][j] != 0 && !check[i][j]) {
        			numberOfArea++;
        			dfs(i,j,picture,check);
        			
        		}
        		
        		if(count > maxSizeOfOneArea) {
        			maxSizeOfOneArea = count;
        		}
        		count = 0;
        		
        	}
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        
        return answer;
    }
}
