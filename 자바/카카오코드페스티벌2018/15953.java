import java.util.ArrayList;
import java.util.Scanner;

public class Baekjun {
	
  // 2017년 상금은 규칙을 찾기보다는
  // if else를 사용해서 상금을 나눠도 나쁘지 않다고 생각했다.
  // 6개의 조건문이고 간단하게 상금을 구할 수 있기 때문이다.
	static int reward2017;
	
	public static void isRanking(int a) {
		if ( a == 1 ) {
			reward2017 = 500;
		}
		else if( a <= 3 ) {
			reward2017 = 300;
		}
		
		else if( a <= 6 ) {
			reward2017 = 200;
		}
		
		else if( a <= 10 ) {
			reward2017 = 50;
		}
		
		else if( a <= 15 ) {
			reward2017 = 30;
		}
		
		else if( a <= 21 ) {
			reward2017 = 10;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
    // 2018년 상금에 규칙성을 주기위해
    // 간단한 숫자 배열을 만들어주었다.
    int[] numRow = {4, 3, 2, 1, 0};
		
    // 여기서 arraylist를 쓴 이유는, 반복문을 통해 상금이 착착 다음으로 저장될 수 있게끔 만들어야 했기 때문이다.
		ArrayList<Integer> list2018 = new ArrayList<Integer>();
		
    // 2018 상금 테이블을 만드는 과정이다.
    // 2의 9제곱 부터 2의 5제곱까지의 수를 2의 0제곱부터 2의 4제곱까지의 개수로 넣어줘야 했다.
    // 여기서 시간을 많이 쏟았으나, 위의 숫자배열을 통해 돌파구를 찾았다.
		for(int i = 9; i > 4; i--) {
			for(int j = 0; j < (int)(Math.pow(2,numRow[i-5])); j++) {
				list2018.add((int)(Math.pow(2, i)));
			}
		}
    
      // a,b를 T번 입력하면서 상금을 출력하는 코드
      // 2017년 상금은 조건문을 통해 가져왔고, 2018년 상금은 2018상금 arraylist에 저장되어있는 녀석을 가져왔다.
      // 시간을 재어보니 1m/s가 측정되었다.
			for(int i = 0 ; i < T ; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				double e = System.currentTimeMillis();
				System.out.println((reward2017 + list2018.get(b))*10000);
				double s = System.currentTimeMillis();
			}	
		}
								
	}
