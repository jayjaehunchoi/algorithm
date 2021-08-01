
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] keyPad = {{1,2,3},{4,5,6},{7,8,9},{42,0,35}};
        
        int locationL = keyPad[3][0];
        int locationR = keyPad[3][2];
        
       
        
        for(int n : numbers) {
        	if(n == 1 || n == 4 || n == 7) {
        		locationL = n;
        		answer += "L";
        	}
        	else if (n == 3 || n == 6 || n == 9) {
        		locationR = n;
        		answer += "R";
        	}
        	else if (n == 2 || n == 5 || n == 8 || n == 0) {
        		
    		 	int rowL = 0;
    	        int columnL = 0;
    	        int distanceL = 0;
    	        
    	        int rowR = 0;
    	        int columnR = 0;
    	        int distanceR = 0;
        		
        		for(int i = 0 ; i < keyPad.length; i++) {
        			
        			for(int j = 0 ; j < keyPad[i].length; j++) {
        				
        				if(keyPad[i][j] == n) {
        					rowL += i;
        					columnL += j;
        					
        					rowR += i;
        					columnR += j;
        				}
        				
        				else if(keyPad[i][j] == locationL) {
        					rowL -= i;
        					columnL -= j;
        				}
        				else if(keyPad[i][j] == locationR) {
        					rowR -= i;
        					columnR -= j;
        				}
        			}
        		}
        		distanceL = Math.abs(rowL) + Math.abs(columnL);
        		distanceR = Math.abs(rowR) + Math.abs(columnR);
        		
        		if(distanceL > distanceR) {
        			answer += "R";
        			locationR = n;
        		}
        		
        		else if(distanceL < distanceR) {
        			answer += "L";
        			locationL = n;
        		}
        		
        		else if(distanceL == distanceR && hand.equals("right")) {
        			answer += "R";
        			locationR = n;
        		}
        		
        		else if(distanceL == distanceR && hand.equals("left")) {
        			answer += "L";
        			locationL = n;
        		}
        	}
        }
        
        return answer;
    }
}
