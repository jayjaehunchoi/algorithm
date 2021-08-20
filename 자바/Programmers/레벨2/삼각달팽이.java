// 알고리즘을 생각해냈지만, 구현력이 너무너무 딸렸다.. 

class Solution {
	
    public int[] solution(int n) {
        
    	int[][] snail = new int[n][n];
    	
    	int x = -1;
    	int y = 0;
    	int number = 1;
    	
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = i ; j < n ; j++) {
    			if(i % 3 == 0) {
    				x++;
    			}else if(i%3 == 1) {
    				y++;
    			}else if(i%3 == 2) {
    				x--;
    				y--;
    			}
    			snail[x][y] = number++;
    		}
    	}
    	
    	
    	int[] answer = new int[n*(n+1)/2];
    	int k = 0;
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			if(snail[i][j]==0) {
    				break;
    			}
    			answer[k] = snail[i][j];
    			k++;
    			
    		}
    	}

        return answer;
    }
}
