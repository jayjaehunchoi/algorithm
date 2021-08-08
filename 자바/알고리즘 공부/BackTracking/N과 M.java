import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] answerArr = new int[M];
	static boolean[] check = new boolean[N];
	
  // backtracking먹이면서, T인 녀석들 만들고 , 백트래킹 빠져나오면서 다시 F가 되고 F는 다시 수열로 들어가는(모든 경우의 수)
	public static void backTracking(int k) {
		
		if( k == M) {
			for(int a : answerArr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N ; i++) {
			if(!check[i-1]) {
				answerArr[k] = i;
				check[i-1] = true;
				backTracking(k+1);
				check[i-1] = false;
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		backTracking(0);
		
	}
}
