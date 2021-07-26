import java.util.ArrayList;
import java.util.Scanner;

public class Baekjun {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int countTwo = 0;
		int countZero = 0;
		int countOne = 0;
		int countEight = 0;
		
		// n 배열 만들기
		String nStr = String.valueOf(N);
		ArrayList<Integer> nList = new ArrayList<Integer>();
		for (int i = 0; i < nStr.length(); i++) {
			nList.add(Integer.parseInt(nStr.substring(i,i+1)));			
		}
		
    // 2018 규칙 만들기 
		for(int i = 0; i < nList.size(); i++) {
			int number = nList.get(i);
			switch (number) {
			
			case 2:
				countTwo++;			
				break;
				
			case 0:
				countZero++;			
				break;
				
			case 1:
				countOne++;			
				break;
				
			case 8:
				countEight++;			
				break;
			
			default:
				System.out.println(0);
				return;
			}
			
		}
		
		// 뽑아낸 규칙으로 조건에 맞게 출력하기
		if (countTwo > 0 && countZero > 0 && countOne > 0 && countEight > 0) {
			if (countTwo == countEight && countTwo == countOne && countTwo == countZero) {
				System.out.println(8);	
			}
			else {
				System.out.println(2);
			}
		}
		else if (countTwo > 0 || countZero > 0 || countOne > 0 || countEight > 0) {
			System.out.println(1);
  		  }		
	}
}

/*
풀이시간 15분
*/

