import java.util.Scanner;

public class Test02 {
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if (N < 0) {
			System.out.println("정수를 입력해주세요.");
			return;
		}
		
		int result = 0;
		int maxNum = 0;
		for (int i = 1 ; i < N; i++) {
			int count = 0;
			for (int j = 1 ; j < i+1; j++) {
				if (i % j == 0) {
					count += 1;
				}
			}
			if (result <count) {
				result = count;
				maxNum = i;
			}
		}
		System.out.println(maxNum);
		

	}

}

/*
약수를 구하는 방법에 대해 고민해보았다. 1부터 입력된 수와 앞 반복문 변수 값까지 반복문을 돌려서 약수를 찾을 수 있었다.
약수가 가장 많은 수를 찾을 때는 최대값을 변수에 넣어서 최종적으로 들어간 최대값의 위치를 출력해주었다.
*/
