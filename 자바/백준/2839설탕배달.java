// 동적프로그래밍을 통한 풀이만 시간초과 해결 가능

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int n = sc.nextInt();
		
		int bong5 = 0;
		int bong3 = 0;
		int rest = 0;
		
		bong5 = n/5;
		rest =  n%5;
		
		while(true) {
			
			bong3 += rest/3;
			rest %= 3;
			
			if(rest != 0) {
				if(bong5 > 0) {
					bong5--;
					rest += 5;
				}
				else {
					answer = -1;
					System.out.println(answer);
					return;
				}
			}else if(rest == 0) {
				answer = bong5 + bong3;
				System.out.println(answer);
				return;
			}	
		}
  }
}
	

