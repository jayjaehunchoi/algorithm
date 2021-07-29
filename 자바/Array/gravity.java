package chapter1;

import java.util.ArrayList;
import java.util.Scanner;

public class Gravity {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		int T = sc.nextInt();
		
		for(int test_case  = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
      // 최대값을 구하기 위해
			int maxCount = 0;
			
			ArrayList<Integer> boxList = new ArrayList<Integer>();
			
			for(int i = 0 ; i < N ; i++) {
				int height = sc.nextInt();
				boxList.add(height);
			}
			
      // 박스가 있는 칸은 1로 저장
      // 나머지는 알아서 0으로 저장될것이다.
			int[][] arr = new int[N][M];
			for(int i = 0 ; i < arr.length; i++) {
				for(int j = 0 ; j < boxList.get(i); j++) {
					arr[i][j] = 1;
					
				}
				
			}
      
      // 1이 아닌 수를 세서 낙차를 구한다.
			for(int i = 0; i < M; i++) {
				int countzero = 0;
				for(int j = 1 ; j < N ; j++) {
					if(arr[0][i] != 0) {
						if(arr[j][i] != 1) {
							countzero++;
						}
					}
					
				}
				if(countzero > maxCount) {
					maxCount = countzero;
				}
			}
			System.out.println(maxCount);
		}
	}

}
