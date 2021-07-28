import java.util.ArrayList;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String xStr = String.valueOf(x);
        ArrayList<Integer> aList = new ArrayList<Integer>();
        
        int sum = 0;
        for(int i = 0 ; i < xStr.length(); i++) {
        	aList.add(Integer.parseInt(xStr.substring(i,i+1)));
        	sum += aList.get(i);
        }
        
        if(x % sum == 0) {
        	answer = true;
        }
        else {
			answer = false;
		}
        return answer;
    }
}
