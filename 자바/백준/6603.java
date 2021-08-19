import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
	
  // combination 구하기
  // 방문 체크 + index를 설정하여 이미 지나친건 다시 안하게끔 만들어줘야 한다.
	public static void comb(int[] arr, boolean[] check, int index , int start, int target) {
		
		if(start == target) {
			for(int i = 0 ; i < arr.length; i++) {
				if(check[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}

		for(int i = index ; i < arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				comb(arr, check , i ,start+1, target);
				check[i] = false;
			}
		}
		
	}

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		while(true) {

			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st.nextToken());
			
			if(k == 0) {
				return;
			}
			
			int[] arr = new int[k];
			boolean[] check = new boolean[k];
			for(int i = 0 ; i < k ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(arr, check, 0, 0, 6);
			System.out.println();
		}
	
	}
}
