// 1번문제

class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().solution("LULLLLLLU"));
	}
    public int solution(String dirs) {
        int answer = 0;
        boolean [][][][] visitedRoad = new boolean[11][11][11][11];
        
        int x = 5;
        int y = 5;
        
        for(int i = 0 ; i < dirs.length(); i++) {
        	char c = dirs.charAt(i);
        	int nx = x;
        	int ny = y;
        	switch (c) {
			case 'U':
				nx -= 1;
				if(nx < 0) {
					nx++;
				}
				break;
			case 'D':
				nx += 1;
				if(nx > 10) {
					nx--;
				}
				break;
			case 'L':
				ny -= 1;
				
				if(ny < 0) {
					ny++;
				}
				break;
			case 'R':
				ny += 1;
				if(ny > 10) {
					ny--;
				}
				break;

			default:
				break;
			}
        	
        	if(!visitedRoad[x][y][nx][ny]) {
        		if(x== nx && y == ny) {
        			
        		}else {
            		answer++;
            		visitedRoad[x][y][nx][ny] = true;
            		visitedRoad[nx][ny][x][y] = true;
        		}

        	}
        	x = nx;
        	y = ny;  	
        }
        return answer;
    }
}


// 2번문제 (네번째 조건에서 오타냄 ㅋㅋ; y자리에 x1 )

class Solution {
	
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
      //2,2,5,4 일경우  가로 위 (2,2 -> 2,4) 세로 오른 (2,4 -> 5,4) , 가로 아래 (5,4 -> 5,2) , 세로 왼 (5,2 -> 2,2)
        // x1,y1 =>> x1,y2 ->> x2,y2 ->> x1,y2 ->> x1,y1
        int[][] map  = new int[rows+1][columns+1]; 
        int val = 1;
        for(int i = 1; i < rows+1; i++) {
        	for(int j = 1; j < columns+1; j++) {
        		map[i][j] = val;
        		val++;
        	}
        }
        int recur = 0;
        while(recur < queries.length) {
        	int x1 = queries[recur][0];
        	int y1 = queries[recur][1];
        	int x2 = queries[recur][2];
        	int y2 = queries[recur][3];
        	
        	int tmp = map[x1][y1];
        	int min = tmp;
        	
        	
        	for(int i = x1 ; i < x2; i++) {
        		map[i][y1] = map[i+1][y1];
        		min = Math.min(map[i][y1], min);
        	}
        	
        	for(int i = y1 ; i < y2; i++) {
        		map[x2][i] = map[x2][i+1];
        		min = Math.min(map[x2][i], min);
        	}
        	
        	for(int i = x2 ; i > x1; i--) {
        		map[i][y2] = map[i-1][y2];
        		min = Math.min(map[i][y2], min);
        	}
        	
        	for(int i = y2 ; i > y1 ; i--) {
        		map[x1][i] = map[x1][i-1];
        		min = Math.min(map[x1][i], min);
        	}
        	
        	map[x1][y1+1] = tmp;
        	answer[recur] = min;
        	recur++;

        	
        }
        
        return answer;
    }
}
