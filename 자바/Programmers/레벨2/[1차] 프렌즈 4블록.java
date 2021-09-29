class Solution {
//	public static void main(String[] args) {
//		Solution s = new Solution();
//		int m = 4;
//		int n = 5; 
//		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
//		
//		System.out.println(s.solution(m, n, board));
//	}
	char[][] boardCheck;
	char[][] boardErase;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        boardCheck = new char[m][n];
        boardErase = new char[m][n];
        
        for(int i = 0 ; i < board.length; i++) {
        	boardCheck[i] = board[i].toCharArray();
        	boardErase[i] = board[i].toCharArray();
        }
        while(true) {
        	int val = check4(m, n);
        	if(val == 0) {
        		for(int i = 0 ; i < m ; i++) {
        			for(int j = 0 ; j < n ; j++) {
        				if(boardCheck[i][j] == '0') {
        					answer++;
        				}
        			}
        		}
        		return answer;
        	}
        	downCheck(m, n);
        	eraseToCheck(m, n);
        }
    }
    
    int[] dx = {1,0,1};
    int[] dy = {0,1,1};
    
    public int check4(int m , int n) {
    	int change = 0;
    	for(int i = 0; i < m ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			int check = 0;
    			if(boardCheck[i][j] != '0') {
    				loop1 : for(int k = 0 ; k < 3; k++) {
        				int nx = i+ dx[k];
        				int ny = j + dy[k];
        				if(nx >= m || ny >= n)break loop1;
        				if(boardCheck[nx][ny] == boardCheck[i][j]) {
        					check++;
        				}else {
        					break loop1;
        				}
        			}
        			if(check == 3) {
        				change++;
        				boardErase[i][j] = '0';
        				for(int k = 0 ; k < 3; k++) {
        					int nx = i+ dx[k];
            				int ny = j + dy[k];
            				boardErase[nx][ny] = '0';
        				}
        			}
    			}
    		}
    	}
    	return change;
    }
    
    public void eraseToCheck(int m, int n) {
    	for(int i = 0; i < m ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			boardCheck[i][j] = boardErase[i][j];
    		}
    	}
    }
    int ex = 1;
    public void downCheck(int m, int n) {
    	for(int i = m-1; i >= 0 ; i--) {
    		for(int j = 0 ; j < n ; j++) {
    			if(boardErase[i][j] != '0') {
    				int nx = i+ex;
    				if(nx >= m)continue;
    				if(boardErase[nx][j] == '0') {
    					while(boardErase[nx][j] == '0') {
    						nx += ex;
    						if( nx >= m) {
    							break;
    						}
    					}
    					boardErase[nx-1][j] = boardErase[i][j];
    					boardErase[i][j] = '0';
    					
    				}
    			}
    		}
    	}
    }
}
