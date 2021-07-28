package com.mycom;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		
		
		
		for(int test_case = 1; test_case <= T; test_case++){
			int structNum = sc.nextInt();
			int view = 0;
			int total = 0;
			
			int[] structList = new int[structNum];
			
			
			for(int i = 0; i < structNum; i++) {
				structList[i] = sc.nextInt();
			}
			
			for(int i = 2 ; i < structList.length-1; i++) {
				int [] neighborStruct = new int[4];
				
				if(structList[i] > structList[i-2] && structList[i] > structList[i-1] && structList[i] > structList[i+1] && structList[i] > structList[i+2]) {
					
					
					neighborStruct[0] = structList[i-2];
					neighborStruct[1] = structList[i-1];
					neighborStruct[2] = structList[i+1];
					neighborStruct[3] = structList[i+2];
					
					Arrays.sort(neighborStruct);
					
					view = structList[i] - neighborStruct[3];
					total += view;
					
					
				}
			}
			
		System.out.println("#"+ test_case + " " + total);	
		}
		
	}
}

/*
쉬운 문제였다, 그런데 이클립스에서는 잘 실행되는데,
제출하려니 계속 런타임에러가 나는 상황...
일단 문의를 넣어놨다.
*/
