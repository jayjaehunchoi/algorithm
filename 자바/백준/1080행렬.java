import java.util.Scanner;

class Main {
	
	// 첨엔 모든 경우의 수를 다 찾으려했다, 그려다 보니 무조건 시간초과가 나오더라
  // 검색해보니, 루프 돌면서 같지 않은 순간에만 변경해주면 최소값 나오더라.
  // 어차피 1에서 시작해서 2로 가나, 2에서시작해서 1로가나 변하는 값을 똑같기 때문에 모든 경우의 수를 찾을 필요는 없었다.
	static int n;
	static int m;
	static String[][] a;
	static String[][] b;
	static int answer = 0;
	
  // 0 > 1 / 1 > 0 으로 뒤집기
	public static void flip(int x , int y) {
		for(int i = x ; i < x+3 ; i++) {
			for(int j = y ; j < y+3 ; j++) {
				if(a[i][j].equals("0")) {
					a[i][j] = "1";
				}
				else {
					a[i][j] = "0";
				}
			}
		}
	}
	
  // -2구간까지 돌면서 다른값이 있으면 뒤집어보기
	public static void change() {
		for( int i=0; i<n-2 ; i++) {
			for ( int j=0; j<m-2 ;j ++) {
				if (!a[i][j].equals(b[i][j])) {
					flip(i,j);
					answer ++;
				}
			}
		}
	}
	
  // 같으면 true 아니면 false
	public static boolean compArr(String[][] a, String[][] b) {
		for(int i = 0 ; i < a.length; i++) {
			for(int j = 0 ; j < a[0].length; j++) {
				if(!a[i][j].equals(b[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		a = new String[n][m];
		b = new String[n][m];
		
		for(int i = 0 ; i < n; i++) {
			a[i] = sc.next().split("");
		}
		for(int i = 0 ; i < n; i++) {
			b[i] = sc.next().split("");
		}

		if ( n < 3 || m < 3) {
			if ( compArr(a,b) ) {
				answer = 0;
			}
			else {
				answer = -1;
			}
		}
		else {
			change();
		}

		if(!compArr(a, b)) {
			answer = -1;
		}
		System.out.println(answer);
		

	}

}

	

