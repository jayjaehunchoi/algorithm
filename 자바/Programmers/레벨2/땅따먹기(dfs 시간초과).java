//dfs 땅따먹기 풀이 , 행이 너무 많아지면 , 시간초과난다
// 검색해보니 DP 로 문제를 해결해야 한다고 한다.
// 하지만 nqueen과 유사한 dfs라 나중에 두고두고 보려고 코드 저장

class Solution {
	static int[] counting;
	static int count = 0;
	static int max = 0;
	
	public static void dfs(int[][] land, int x, int k) {
		
		if(x == land.length) {
			for(int i : counting) {
				count += i;
			}
			
			if(max < count) {
				max = count;
			}
			count=0;
			return;
		}
		
		for(int i = 0 ; i < land[0].length ; i++) {
			if(i != k) {
				counting[x] = land[x][i];
				dfs(land,x+1,i);
			}
		}
	}
	
	int solution(int[][] land) {
        counting = new int[land.length];
        
        for(int i = 0 ; i < land[0].length; i++) {
        	counting[0] = land[0][i];
        	dfs(land,1,i);
        }
        
        return max;
    }
}
