import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		int stores = Integer.parseInt(br.readLine());
		
		int[][] storeBoard = new int[stores+1][3];
		for(int i = 0 ; i < stores+1 ; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int dir = Integer.parseInt(st.nextToken());
			 int dist = Integer.parseInt(st.nextToken());
      // 방향별로 좌표 선정
			 switch(dir) {
			 	case 1:
			 		storeBoard[i][0] = 0;
			 		storeBoard[i][1] = dist;
			 		break;
			 	case 2:
			 		storeBoard[i][0] = row;
			 		storeBoard[i][1] = dist;
			 		break;
			 	case 3:
			 		storeBoard[i][0] = dist;
			 		storeBoard[i][1] = 0;
			 		break;
			 	case 4:
			 		storeBoard[i][0] = dist;
			 		storeBoard[i][1] = col;
			 		break;
			 }
			 storeBoard[i][2] = dir;

		}
		
    // 우리 집 좌표와 dir
		int x = storeBoard[stores][0];
		int y = storeBoard[stores][1];
		int compDir = storeBoard[stores][2];
		int res = 0;
		for(int i = 0 ; i < stores ; i++) {
      
      // 맞은편 코드 처리
			if(compDir == 1) {
				if(storeBoard[i][2] == 2) {
					res += Math.min(row + y + storeBoard[i][1], row + (col-y) + (col - storeBoard[i][1]));
					continue;
				}
			}else if(compDir == 2) {
				if(storeBoard[i][2] == 1) {
					res += Math.min(row + y + storeBoard[i][1], row + (col-y) + (col - storeBoard[i][1]));
					continue;
				}
			}else if(compDir == 3) {
				if(storeBoard[i][2] == 4) {
					res += Math.min(col + x + storeBoard[i][0], col + (row-x) + (row - storeBoard[i][0]));
					continue;
				}
			}else if(compDir == 4) {
				if(storeBoard[i][2] == 3) {
					res += Math.min(col + x + storeBoard[i][0], col + (row-x) + (row - storeBoard[i][0]));
					continue;
				}
			}
			
      // 맞은편이 아닐경우
			res += (Math.abs(storeBoard[i][0] - x) + Math.abs(storeBoard[i][1] - y)); 
		}
		System.out.println(res);
		
	}
} 
