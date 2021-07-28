package com.mycom;

import java.util.ArrayList;

class Solution {
    public String solution(String phone_number) {
    	String answer = "";
    	
    	ArrayList<String> aList = new ArrayList<String>();
    	for(int i = 0; i < phone_number.length(); i++) {
    		if (i < phone_number.length() - 4) {
    			aList.add("*");
    		}
    		else {
    			aList.add(phone_number.substring(i,i+1));
    		}
    		answer += aList.get(i);
    	}
    	
    	
    	
        return answer;
    }
}
