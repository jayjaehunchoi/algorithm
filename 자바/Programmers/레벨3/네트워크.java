class Solution {

  // 방문하지 않았으면서, 본인값과 같지 않고, 값이 1일때 dfs를 돈다.
	public static void dfs(int[][] computers, int x, boolean[] check ) {
		
		check[x] = true;
		
		for(int i = 0 ; i < computers.length ; i++) {
			if(x != i && computers[x][i] == 1 && !check[i]) {
				dfs(computers, i, check);
			}
		}

	}
	
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] check = new boolean[n];
        for(int i = 0 ; i < n ; i ++) {
        	if(!check[i]) {
        		dfs(computers,i,check);
        		answer++;
        	}
        }
        
      
        
        return answer;
    }
}
