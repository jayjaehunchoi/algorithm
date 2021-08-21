// 이것도 동적프로그래밍이라 할 수 있을까?
// 오히려 dfs에 더 가까운 느낌.
import java.util.Scanner;

class Main {
	
	static int count = 0;
	public static int ways(int n) {
		
		if(n==0) {
			count++;
			return 0;
		}
		
		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		
		if(n-1 >= 0) {
			ways(n-1);
		}
		if(n-2 >= 0) {
			ways(n-2);
		}
		if(n-3 >= 0) {
			ways(n-3);
		}

		return count;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			int m = sc.nextInt();
			System.out.println(ways(m));
			count = 0;
		}

	}

}
	

