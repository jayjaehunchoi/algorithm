package com.mycom;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		
		int TC = sc.nextInt();
		String result = "";
			
		for(int i = 0; i < TC; i++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			char [][] tiles = new char[N][M];
			
			// 타일 제작
      // arraylist에 하나하나 넣어서 저장하여 이후 모든 타일이 고장나지 않았을 경우
      // YES 출력하고자 함.
      
			ArrayList<Character> aList = new ArrayList<Character>();
      
			for(int row = 0; row < N ; row++) {
				String tile = sc.next();
				for(int column = 0; column < M; column++) {
					tiles[row][column] = tile.charAt(column);
					aList.add(tiles[row][column]);
				}
			}
			
      // arraylist에 하나하나 넣어서 저장하여 이후 모든 타일이 고장나지 않았을 경우
      // YES 출력
			if(!aList.contains('#')) {
				result = "YES";
			}
			
      // arraylist에 하나하나 넣어서 저장하여 모든 조건문을 수행해도 고장난 타일이 있는 케이스 제거하기 위해
      // arrayList 생성
			ArrayList<Character> bList = new ArrayList<Character>();
			for(int row = 0; row < N ; row++) {

				for(int column = 0; column < M; column++) {
					
					if(tiles[row][column] == '#') {
						if(row+1 <= N-1 && column+1 <= M-1 && tiles[row+1][column] == '#' && tiles[row][column+1] == '#' && tiles[row+1][column+1] == '#') {
							result = "YES";
							tiles[row][column] = '.';
							tiles[row+1][column] = '.';
							tiles[row][column+1] = '.';
							tiles[row+1][column+1] = '.';
						}
						else if(row+1 > N-1 || column+1 > M-1){
							result = "NO";
						}
						else {
							result = "NO";
						}
					}
					bList.add(tiles[row][column]);
				}
			}
			if(bList.contains('#')) {
				result = "NO";
			}
			System.out.println("#"+(i+1) +" "+ result);						
		}		
	}
}
