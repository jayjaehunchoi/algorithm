
import java.io.IOException;
import java.util.Scanner;

class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] printPrice = new int [n][n];
		
		for(int i = 0 ; i < n ; i++) {
			
			printPrice[i][0] = sc.nextInt();
			printPrice[i][1] = sc.nextInt();
			printPrice[i][2] = sc.nextInt();
				
			
		}
		
    // 복잡하게 조건이 쓰여있지만 다음 집은 동일한 색상 사용하여 색칠하는 것이 불가하다는게 요다.
    // 그럼 이전값 + 다음값 except 같은 열 해주고 min값만 계속 더해주면 결국 마지막 세값이 생길 것이다.
    // 그때도 거기의 최소값을 구해주면 정답 찾기 완료!
		for(int i = 1 ; i < n ; i++) {
			printPrice[i][0] += Math.min(printPrice[i-1][1],printPrice[i-1][2]);
			printPrice[i][1] += Math.min(printPrice[i-1][0],printPrice[i-1][2]);
			printPrice[i][2] += Math.min(printPrice[i-1][1],printPrice[i-1][0]);
		}
		
		System.out.println(Math.min(Math.min(printPrice[n-1][0], printPrice[n-1][1]),printPrice[n-1][2]));
	}

}
	

