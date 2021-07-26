import java.util.Scanner;

public class A {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String S = sc.next();
		
		for(int i = N-5; i < N; i++) {
			System.out.print(S.substring(i, i+1));
		}
			
	}
}

				
/*
입력
첫 번째 줄에 문자열의 길이 N이 주어진다.
두 번째 줄에는 N글자로 이루어진 문자열 S가 주어진다.
출력
S의 마지막 5글자를 출력한다.
*/

/*
substring을 활용하여 간단하게 해결할 수 있었음.
*/
