import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
    	  
    	int answer = 0;
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(0);
	    
	    for(int m : moves) {

	    	
	    	for(int i = 0 ; i < board.length; i++) {
	    		
	    		
	    		if(board[i][m-1] != 0) {
	    		
	    				if(stack.peek() == board[i][m-1]) {
		    				stack.pop();
		    				answer += 2;
		    				board[i][m-1] = 0;
		    				break;
	    				
	    				}
		    			
	    				else {
		    				stack.push(board[i][m-1]);
		    				board[i][m-1] = 0;
		    				break;
	    				}
		    		}
		    	}
	    	}

	    return answer;
    }
}

/*
계속 행안에 있는 값들이 한 줄인걸로 착각하고 왜 오류가 나는지 도저히 이해를 못했다..
근데 알고보니 걍 5x5 배열.. 문제를 잘 읽자.
*/
