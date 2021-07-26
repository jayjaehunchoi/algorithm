import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {
	
	
	
	
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 수 배열 만들기
		// 뺄셈으로 증가 감소 수열 알기 위해.
		int N = sc.nextInt();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] numList = new int[N];
		for(int i = 0 ; i < N; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}
		
		// boolean 리스트를 통해 증가면 t 감소면 f
		// 배열에 집어넣기
		// 증가도 감소도 아닐경우 더 볼 필요없이 No 출력 후 종료
		String answer = "";
		boolean[] tFList = new boolean[N];
		for (int i = 1 ; i < N; i++) {
			if((numList[i] - numList[i-1]) > 0) {
				tFList[i-1] = true;
			}
			else if ((numList[i] - numList[i-1]) < 0) {
				tFList[i-1] = false;
			}
			
			else {
				answer = "NO";
				System.out.println(answer);
				return;
			}
		}
		
		// boolean 리스트 값 확인 T or F
		// f > t 면 무조건 NO
		// 그 외의 경우는 무조건 True (위에서 동일한 숫자 나오면 바로 No 하고 출력 후 메소드 종료 시킴)
		int count = 0;
		for (int i = 0 ; i < tFList.length-1; i++) {
			if (tFList[i] == false) {
				if(tFList[i+1] == true) {
					answer = "NO";
					System.out.println(answer);
					return;
				}
			}
			else {
				answer = "YES";
			}
		}
		System.out.println(answer);
		
	}

}


/*
첫 번째 줄에는 수열의 길이 N이 주어진다.
두 번째 줄에는 A1 ... AN 이 공백으로 구분되어 주어진다.
출력
입력으로 주어진 수열 A가 산이면 "YES"를, 산이 아니면 "NO"를 출력한다.
*/
/*
약 20분에서 30분정도 소요됐다.
문제를 이해하는 것은 그렇게 어렵지 않았고,
어떤 방식으로 - > + > - 를 찾아서 No를 출력할지 고민을 많이 했다.
답은 간단하게 
1.증가, 감소 형태를 보이지 않으면 바로 NO 출력
2. 조건문으로 i번째가 false일때 i+1번째가 True이면 No를 주는 것
이라고 생각하여 코드를 그것에 맞춰서 짰다.
*/
