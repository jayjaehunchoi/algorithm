
import java.io.IOException;
import java.util.Arrays;

import java.util.Scanner;

class Main {
	
	static int answer = 0;
	public static int binarySearch(int[] nArr , int needFind) {
		
		int start = 0;
		int end = nArr.length-1;
		
		while (start <= end) {
			
			int mid = (start + end) / 2;

			if(nArr[mid] < needFind) {
				start  = mid+1;
			}
			else if(nArr[mid] > needFind) {
				end = mid-1;
			}
			else {
				return 1;
			}
			
			
		}
		return 0;

	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] nArr = new int[n];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < n ; i++) {
			nArr[i] = sc.nextInt();
		}
		
		Arrays.sort(nArr);
		
		
		int m = sc.nextInt();
		int[] mArr = new int[m];
		
		for(int i = 0 ; i < m ; i++) {
			mArr[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < m ; i++) {
			sb.append(binarySearch(nArr, mArr[i])+"\n");
		}
		System.out.println(sb);
		
	}

}
	

