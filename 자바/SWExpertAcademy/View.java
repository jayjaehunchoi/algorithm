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
쉬운 문제였다.
문제 풀이 약 15~ 30분정도 소요됐다.

그런데 계속 런타임 에러가 나와서 시간을 쏟았는데,
문제 초반에는 테스트 케이스를 입력하라고 말했으면서,, 후반에는 10으로 주어졌다고 되어있더라...
이것때문에 시간만 많이 썼다..';'
*/
