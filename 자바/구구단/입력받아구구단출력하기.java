import java.util.Scanner;

public class GuGu {
 
	int number;
	public GuGu(int numbers) {
		this.number = numbers;
	}
	
	public int mul_num(int muls) {
		return number * muls;	
	}
	
	public int[] all() {
		int [] result = new int[9];
		for (int i = 0; i < result.length; i++ ) {
			result[i] = mul_num(i+1);
		}
		return result;		
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int [] result = all();
		for (int i = 0; i <result.length; i++ ) {
			sb.append(result[i]);
			if (i != 8) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력값으로 곱셈하기.
		System.out.print("1~9사이의 정수를 입력하세요 : ");
		int n = sc.nextInt();
		System.out.print("곱할 정수를 입력하세요 : ");
		int m = sc.nextInt();
		
		GuGu gugudan = new GuGu(n);
		System.out.println(gugudan.mul_num(m));
		
		// 구구단 2단부터 9단까지 출력하기. 
		System.out.println();
		System.out.println("구구단 2단부터 9단까지 출력합니다.");
		for (int i = 2; i < 10; i++) {
			GuGu guTonine = new GuGu(i);
			System.out.println(guTonine);
		}
	}
}
