class Solution {
    public int solution(String s) {
        int answer = 0;
       
        String[] numStr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i = 0 ; i < numStr.length; i++) {
        	s = s.replaceAll(numStr[i], String.valueOf(i));
        }
     
        return Integer.parseInt(s);
    }
}

/* 
방금 막 replaceAll을 기반으로 문제 해결한 것을 본 덕분에 바로 replaceAll을 떠올릴 수 있었다.
*/
