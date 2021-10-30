import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	public static int[][] sdoku;
	public static boolean rowCheck(int x, int cur) {
		for(int i = 0 ; i < 9; i++) {
			if(sdoku[x][i] == cur) {
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean colCheck(int y, int cur) {
		for(int i = 0 ; i < 9; i++) {
			if(sdoku[i][y] == cur) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean blockCheck(int x, int y, int cur) {
		int nx = xChecker(x);
		int ny = yChecker(y);
		for(int i = nx ; i <= nx+2; i++) {
			for(int j = ny ; j <= ny+2; j++) {
				if(sdoku[i][j] == cur) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static int xChecker(int x) {
		int nx = 0;
		if(x >= 0 && x <= 2) {
			nx = 0;
		}else if(x >=3 && x <= 5) {
			nx = 3;
		}else {
			nx = 6;
		}
		return nx;
	}
	
	public static int yChecker(int y) {
		int ny = 0;
		if(y >= 0 && y <= 2) {
			ny = 0;
		}else if(y >=3 && y <= 5) {
			ny = 3;
		}else {
			ny = 6;
		}
		return ny;
	}
	
  // 백트래킹
	public static void sudoku(int row, int col) {
    
    // 다음 행으로 이동
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
    
    // 모든 행렬 탐색 완료
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sdoku[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

    // 채워야 할 칸이 있을 때,
		if (sdoku[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
        // 3가지 조건 확인
				if (rowCheck(row, i) && colCheck(col, i) && blockCheck(row, col, i)) {
					sdoku[row][col] = i;
					sudoku(row, col + 1);
				}
			}
      // 조건에 부합하는 것이 없을때, 다시 0으로 처리하고 나가기
			sdoku[row][col] = 0;
			return;
		}
    //다음 열로 이동.
		sudoku(row, col + 1);
 
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sdoku = new int[9][9];
		for(int i = 0 ; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				sdoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
		
		
		
	}
} 
