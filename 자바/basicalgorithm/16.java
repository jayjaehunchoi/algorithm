package com.mycom;

import java.util.ArrayList;


class Solution {
    public boolean solution(String s) {
    	boolean answer = true;
    	
    	
    	ArrayList<Character> numbers = new ArrayList<Character>();
        
    	for(int i = 0; i < 10 ; i ++) {
    		numbers.add(String.valueOf(i).charAt(0));
    	}
            
        ArrayList<Character> aList = new ArrayList<Character>();
            
    	for(int j = 0 ; j < s.length() ; j++) {
    		aList.add(s.substring(j, j+1).charAt(0));
        }
    	
    	for(int i = 0 ; i < aList.size(); i++) {
    		if(numbers.contains(aList.get(i))) {
    			answer = true;
    			
    		}
    		else {
				answer = false;
				break;
			}
    	}
    	
    	if( s.length() !=4 && s.length() !=6 ) {
    		answer = false;
    	}
  
        return answer;

    }
}
