package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BabyGinGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> numList = new ArrayList<Integer>();
		int isItBaby = 0;
		int order = 0;
		
		for(int i = 0 ; i < 6; i++) {
			int num = sc.nextInt();
			numList.add(num);
		}
		
		Collections.sort(numList);
		
		for(int i = 0 ; i < 4 ; i++) {
			if(numList.get(i) == numList.get(i+1) && numList.get(i) == numList.get(i+2)) {
				isItBaby++;
				order = i;
			}
		}
		for(int i = 0 ; i < 3 ; i++){
      
		numList.remove(order);
    }
		if(numList.size() == 3) {
			int run = 0;
			for(int i = 0; i < 2; i++) {
				if(numList.get(i+1) - numList.get(i) == 1) {
					run++;
				}
			}
			if(run == 2) {
				isItBaby += 1;
			}
		}
		
		if(isItBaby == 2) {
			System.out.println("BabyGin!!");
		}
		else {
			System.out.println("NO!");
		}
	}
}


/* 
완전 검색으로 해결 vs 정렬하여 경우의 수 비교
경우의 수가 적을 때 완전검색,
아니면 정렬
*/
