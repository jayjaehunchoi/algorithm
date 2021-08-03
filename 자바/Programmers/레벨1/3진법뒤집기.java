class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        
        
        while(n != 0 ) {
        	str += n%3;
        	n /= 3;
        }
        str = StringBuilder(str).reverse().toString();
        
        for(int i = 0 ; i < str.length(); i++) {
        	answer += Math.pow(3, i) * Integer.parseInt(str.substring(i,i+1));
        }
        
        return answer;
    }
}
