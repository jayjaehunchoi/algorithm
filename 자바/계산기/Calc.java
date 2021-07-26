import java.util.Scanner;

public class calculator {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int m = 0;
		String operator = "";
		double result = 0;
		
		System.out.print("숫자를 입력하세요. : ");
		n = sc.nextInt();
		result += n;
		mainloop :  while (true) {
			System.out.print("연산자를 입력하세요. (+,-,*,/,c)");
			operator = sc.next();
			switch (operator) {
			case "+": 			
				System.out.print("다음 숫자를 입력하세요. : ");
				m = sc.nextInt();
				result = result + m; 
				System.out.println("결과는 " + result );
				break;
				
			case "-": 
				System.out.print("다음 숫자를 입력하세요. : ");
				m = sc.nextInt();
				result = result - m;
				System.out.println("결과는 " + result );
				break;
				
			case "*": 
				System.out.print("다음 숫자를 입력하세요. : ");
				m = sc.nextInt();
				result = result * m;
				System.out.println("결과는 " + result );
				break;
				
			case "/": 
				System.out.print("다음 숫자를 입력하세요. : ");
				m = sc.nextInt();
				result = result / m;
				System.out.println("결과는 " + result );
				break;
			
			case "c": 
				System.out.println("계산기를 종료합니다.");
				break mainloop;			
			}
		}
		
	}
	
}
