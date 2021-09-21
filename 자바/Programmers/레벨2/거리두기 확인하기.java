class Solution {
	
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {-1,1,-1,1};
	
	public static boolean findDaegak(int x, int y, char[][] room) {
		
		for(int i = 0 ; i < 4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)continue;
			if(room[nx][ny] == 'P') {
				if(room[x][ny] != 'X' || room[nx][y] != 'X') {
					return false;
				}

			}
				
		}
		return true;
		
	}
	static int[] dx2 = {-1,1,0,0};
	static int[] dy2 = {0,0,-1,1};
	public static boolean find(int x, int y, char[][] room) {
		
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx2[i];
			int ny = y + dy2[i];
			
			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || room[nx][ny] == 'X')continue;
			if(room[nx][ny] == 'P') {
				return false;
			}
			nx += dx2[i];
			ny += dy2[i];
			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || room[nx][ny] == 'X')continue;
			if(room[nx][ny] == 'P') {
				return false;
			}
		}
		return true;
		
	}
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        char[][] room = new char[5][5];
        int x = 0;
        while(x < places.length){
        	int cnt = 0;
        	int pCnt = 0;
        	for(int i = 0 ; i < 5; i++) {
        		room[i] = places[x][i].toCharArray();
        	}
        	
        	for(int i = 0 ; i < 5; i++) {
        		for(int j = 0 ; j < 5; j++) {
        			if(room[i][j] == 'P') {
        				pCnt++;
        				if(!findDaegak(i, j, room) || !find(i, j, room)) {
        					answer[x] = 0;
        					break;
        				}else {
        					cnt++;
        				}
        			}
        		}
        		
        	}
        	if (cnt == pCnt) {
        		answer[x] = 1;
        	}
        	x++;
        }   
        return answer;
    }
}
