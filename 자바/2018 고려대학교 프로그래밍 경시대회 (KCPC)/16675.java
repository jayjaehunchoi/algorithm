// 코드를 짜기 전에 하나빼기의 규칙성을 찾는게 매우 중요.
// 규칙성만 안다면 코드를 짜는 것은 쉬웠음.

import java.util.Scanner;

public class Baekjun {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char mL = sc.next().charAt(0);
		char mR = sc.next().charAt(0);
		char tL = sc.next().charAt(0);
		char tR = sc.next().charAt(0);
		
		String result = "";
		
    
		if (mL != mR && tL != tR) {
			result = "?";
		}
    
    // 조건문을 짤때, or 과 and가 있다면.
    // or은 항상 and 뒤에 와야 한다.
    // or 비교연산자는 앞에가 조건에 맞으면 뒤도 보지 않고 true라고 여기기 때문.
    
		else if(mL == 'S' &&  mR == 'S' && tL == 'R' || tR == 'R') {
			result = "TK";
		}
		else if(mL == 'S' ||  mR == 'S' && tL == 'R' && tR == 'R') {
			result = "MS";
		}
    
		else if(mL == 'R' &&  mR == 'R' && tL == 'P' || tR == 'P') {
			result = "TK";
		}
		else if(mL == 'R' ||  mR == 'R' && tL == 'P' && tR == 'P') {
			result = "MS";
		}
    
		else if(mL == 'P' &&  mR == 'P' && tL == 'S' || tR == 'S') {
			result = "TK";
		}
		else if(mL == 'P' ||  mR == 'P' && tL == 'S' && tR == 'S') {
			result = "MS";
		}
		
		System.out.println(result);
	}
}

					
/* 
풀이시간 약 20분
문제 해석 약 15분
코드 작성 5분
*/
