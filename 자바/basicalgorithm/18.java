package com.mycom;


class Solution {
    public int[] solution(long n) {
    	 	
    	String nStr = String.valueOf(n);
    	
    	int[] answer = new int[nStr.length()];
    	String[] preAnswer = new String[nStr.length()];
    	
    	for(int i = 0 ; i < nStr.length(); i++) {
    		preAnswer[i] = nStr.substring(i,i+1);
    	}
    	int j = preAnswer.length -1;
    	for(int i = 0 ; i < nStr.length(); i++) {
    		
    		answer[i] = Integer.parseInt(preAnswer[j]);
    		j -= 1;
    		
    	}
    	
        return answer;
    }
}
