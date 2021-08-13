class Solution {
    public int[] solution(int[][] v) {
    	
      // 개념은 x축이 같으면 y의 합을 구해서 나머지 y와 빼주고~~ 하는식이다
      int[] answer = new int [2];
        int n = 0;
        int xaxis = 0;
        int x = 0;
        
        int yaxis = 0;
        int y = 0;
        
      // 모든 경우의 수를 구하기 위해 반복문을 넣어줬다.
        while( n < 2 ) {

	        for(int i = n ; i < v.length-1; i++ ) {
	        	if(v[n][0] == v[i+1][0]) {
	        		yaxis = v[n][1]+v[i+1][1];
	        		x = v[n][0];
	        	}
	        	if(v[n][1] == v[i+1][1]) {
	        		xaxis = v[n][0] +v[i+1][0];
	        		y = v[n][1]; 
	        	}
	        }
	      
	        n++;
        }
        
        answer[0] = xaxis-x;
        answer[1] = yaxis-y;
        
        return answer;
    }
}
