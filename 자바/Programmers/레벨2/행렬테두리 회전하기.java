class Solution {
	
	static int[][] maps;
	
  //가운데 제외 회전 
  // 시계방향 회전이라 하더라도, 변수 변경은 반대로 이뤄져야함
  // 그래야 모든값이 정상적으로 회전가능
	public static int circulation(int[] queries) {
		
		int x1 = queries[0]-1;
		int x2 = queries[2]-1;
		int y1 = queries[1]-1;
		int y2 = queries[3]-1;
		
		int starter = maps[x1][y1];
		int min = starter;
		
		for(int i = x1 ; i < x2 ; i++ ) {
			maps[i][y1] = maps[i+1][y1];
			if(min > maps[i][y1]) min = maps[i][y1];
		}
		for(int i = y1 ; i < y2 ; i++) {
			maps[x2][i] = maps[x2][i+1];
			if(min > maps[x2][i]) min = maps[x2][i];
		}
		for(int i = x2 ; i > x1 ; i--) {
			maps[i][y2] = maps[i-1][y2];
			if(min > maps[i][y2]) min = maps[i][y2];
		}
		for(int i = y2 ; i > y1 ; i--) {
			maps[x1][i] = maps[x1][i-1];
			if(min > maps[x1][i]) min = maps[x1][i];
		}
		
		maps[x1][y1+1] = starter;
		return min;
	}
	
	
    public int[] solution(int rows, int columns, int[][] queries) {
    	
    	int[] answer = new int[queries.length];
    	maps = new int[rows][columns];
    	
    	int num = 1;
    	
    	for(int i = 0 ; i <rows ; i++) {
    		for(int j = 0 ; j < columns ; j++) {
    			maps[i][j] = num;
    			num++;
    		}
    	}
    	
    	for(int i = 0 ; i < queries.length ; i++) {
    		answer[i] = circulation(queries[i]);
    	}

    	
        return answer;
    }
}
