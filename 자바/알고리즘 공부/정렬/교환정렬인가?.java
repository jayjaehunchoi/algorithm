// 한 스타트업에서 알고리즘으로 정렬을 구현해보라라는 테스트를 봤다길래.. 급 구현해봄

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	
	public static void swap(int[] numbers,int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b]= temp;
	}

	public static void main(String[] args){
		
		int [] numbers = {1,5,64,2,3,56,7,9,78,99};
		
		for(int j = 0 ; j < numbers.length ; j++) {
			for(int i = 0 ; i < numbers.length-1; i++) {
				if(numbers[i] > numbers[i+1]) {
					swap(numbers, i, i+1);
				}
			}
		}
		
		for(int i : numbers) {
			System.out.print(i +" ");
		}
		
		
	}
}
