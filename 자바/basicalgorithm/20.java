package com.mycom;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
    	
        
    	int[] answer = new int[commands.length];
        
    	for(int i = 0; i < commands.length ; i++) {
    		ArrayList<Integer> aList = new ArrayList<Integer>();
    		for(int j = commands[i][0]-1 ; j <= commands[i][1]-1; j++ ) {
    			aList.add(array[j]);
    		}
    		Collections.sort(aList);
    		answer[i] = aList.get(commands[i][2]-1);
    	}


    	return answer;
    }
}
