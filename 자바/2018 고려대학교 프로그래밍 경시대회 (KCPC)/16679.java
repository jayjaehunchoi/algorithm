import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjun {
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = sc.nextInt();
		
		// 주사위 눈, 합 입력
		for(int i = 0 ; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// 각 주사위 눈 리스트에 저장 
			// K와 비교할 변수 만들기
			// 바꿀 주사위 찾기(minDice)
			ArrayList<Integer> diceNumberList = new ArrayList<Integer>();
			int diceSum = 0;
			int minDice = 6;
			
			StringTokenizer st;
			st = new StringTokenizer(br.readLine()," ");	
			
			for(int j = 0; j < N; j++) {			
				diceNumberList.add(Integer.parseInt(st.nextToken()));
				diceSum += diceNumberList.get(j);
				if(diceNumberList.get(j) < minDice) {
					minDice = diceNumberList.get(j);
				}			
			}			
      
      // K > diceSum일 경우
      // 6 n제곱 * 최대 확률과 바꿀 값에 1주는 조건문
			int makeCase = 6 - (K - (diceSum - minDice))+1;
			
      if( K > diceSum) {
				int sixN = (int)Math.pow(6, N);	
				double p = (double)(makeCase) / 6 ;
				System.out.println((int)(sixN * p));
					
				for(int j = 0; j < diceNumberList.size(); j++) {
					if(diceNumberList.get(j) == minDice) {
						System.out.print(1 + " ");
					}
					else {
						System.out.print(0 + " ");
					}
				}
			}
      
      // K <= diceSum && (double)((double)minDice/6) > (double)((makeCase) / 6 ;  경우 바꿔서 더 낮을 확률이 높을 때
      // 굳이 안바꾸는 걸로..
      
			else if(K <= diceSum && (double)(minDice)/6 > (double)((makeCase) / 6) && K > (diceSum - minDice)) {
				
				int sixN = (int)Math.pow(6, N);	
				double p = (double)(makeCase) / 6 ;
				System.out.println((int)(sixN * p));
				
				for(int j = 0; j < diceNumberList.size(); j++) {
						System.out.print(0 + " ");
					}
			}
      
      // 그냥 훨씬 넘어버릴때
      // 최소값 하나 암거나 바꿔도 상관 엄슴
			else if(K <= diceSum && K < (diceSum - minDice)) {
			
				int sixN = (int)Math.pow(6, N);	
				System.out.println(sixN);
				
				for(int j = 0; j < diceNumberList.size(); j++) {
					if(diceNumberList.get(j) == minDice) {
						System.out.print(1 + " ");
					}
					else {
						System.out.print(0 + " ");
					}
				
				}
			}
		}
	}
}
		
		
	

/*
풀이시간 약 1시간 20분
어려웠음,.,
문제 해석은 그저 그랬고
코드를 작성하는데 있어서 많은 시간이 걸렸음..
*/
					

