import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjun {
	
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = sc.nextInt();
		int K = sc.nextInt();
				
		// 사람들의 인형에 대한 선호도 담아놓기.
		ArrayList<Integer> preference = new ArrayList<Integer>();
		StringTokenizer st;		
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0 ; i < N; i++) {			
			preference.add(Integer.parseInt(st.nextToken()));
		}
		
		
		
		
		// 연속된 K개 이상의 수  골라내고 표준편차 구하기
		// 여기서 정말 많이 막혔다.
    // 규칙은 쉽게 찾아냈는데, N보다 작은 연속된 K개를 어떻게 뽑아낼까 고민 많이 했다.
    
		double minPyo = 1;
		while ( K <= N) {
			
			for(int i = 0; i < (N - K)+1; i++) {
				double sum = 0;
				double bun = 0;
				for(int j = i; j < i+K; j++) {
					sum += preference.get(j);				
				}
				double avg = sum/K;
				
				for(int j = i; j < i+K; j++) {
				bun += Math.pow((preference.get(j)-avg),2); 
				}
				
				//표준편차 계산하고 가장 작은 표준편차 pick
				bun = bun/K;
				double pyo = Math.abs(Math.sqrt(bun));
				if(pyo < minPyo) {
					minPyo = pyo;				
				}		
			}
			K= K+1;			
		}								
		System.out.println(minPyo);			
	}
}

					

/*
너무 코드를 장황하게 적은것 같다.
다른 사람들 풀이를 조금 보니, 평균, 표준편차 구하는 메소드를 각각 만들어서 잘 했는데,
아무래도 나는 그건 못만들것 같다 ;;
나도 처음 설계할 때는 그렇게 해결할 생각은 있었으나,
적다보니.. 안될 것 같다고 생각이 들었다.
메소드를 만드는 데 더 익숙해져야겠다.
*/
