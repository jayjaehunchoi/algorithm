import java.util.Scanner;

// 모든 경우의 수 찾아서 공식에만 넣어주면 됨.
class Main {
	static int[] numArr;
	static int[] ansArr;
	static boolean[] check;
	static int max = 0;
	static int sum = 0;
	
	public static void backTracking(int idx) {
		
		if(idx == numArr.length) {
			for(int i = 0 ; i<numArr.length -1; i++ ) {
				sum += Math.abs(ansArr[i]-ansArr[i+1]);
			}
			max = Math.max(max, sum);
			sum = 0;
			return;
		}
		
		for(int i = 0 ; i < numArr.length ; i++) {
			if(!check[i]) {
				ansArr[idx] = numArr[i];
				check[i] = true;
				backTracking(idx+1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		numArr = new int[n];
		ansArr = new int[n];
		check = new boolean[n];
		
		for(int i = 0 ; i < n ; i++) {
			numArr[i] = sc.nextInt();
		}
		
		backTracking(0);
		System.out.println(max);

	}

}
	

