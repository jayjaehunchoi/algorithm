import java.util.Scanner;

public class Baekjun {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
    // N = 연봉
		int N = sc.nextInt();
    
    // 같은수가 반복될 때 마다 스티커의 개수는 하나씩 올라간다.
    // 처음으로 자리의 값이 같아질때는 1, 11, 111 ... 이다.
    // 이를 반복문으로 처리하기 위해 str > int(비교) > str 과정을 만들어 줄 예정이다.
		String standardNumber = "1";
		String plusNumber = "1";
    
    // 필요한 스티커 수를 출력하기 위한 변수이다.
		int stickerNum = 0;
		
    // 앞서 말한 비교를 진행하기위해 반복문을 만들었다.
		for (int i = 0 ; i < 8; i++) {
			standardNumber = standardNumber + plusNumber;
			int stNum = Integer.parseInt(standardNumber);
			if ( N < stNum) {
				stickerNum = i+1;
				System.out.println(stickerNum);
				break;
			}
			standardNumber = String.valueOf(stNum);
		}
	}
}

/*
문제 이해 약 5분?
코드작성시간 약 5분

