
import java.util.Scanner;

class Main {
	static boolean[][] chess;
	static int result = Integer.MAX_VALUE;
	
  // 시작점이 정해진 순간부터 8*8 체스판 만들기
  public static void find(int n , int m) {
		int a = n+8;
		int b = m+8;
		
    //color 두개 W = T , B = false
		boolean color = chess[n][m];
		int count = 0;
    
    // 첫값과 똑같지 않으면 개수 추가, 색 변경
		for(int i = n ; i < a ; i++) {
			for(int j = m ; j < b ; j++) {
				if(chess[i][j] != color) {
					count++;
					
				}
				color = !color;
				
			}
      // 라인 변경 시 색 변경
			color = !color;
			
		}
		
		count = Math.min(count, 64-count);
		result = Math.min(result, count);
	}
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		chess = new boolean[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			String a = sc.next();
			
			for(int j = 0 ; j < m ; j++) {
				if(a.charAt(j) == 'W') {
					chess[i][j] = true;
				}else {
					chess[i][j] = false;
				}
			}
		}
		
		for(int i = 0 ; i < n-7 ; i++) {
			for(int j = 0 ; j < m-7 ; j++) {
				find(i, j);
			}
		}
		
		System.out.println(result);
	}
}
