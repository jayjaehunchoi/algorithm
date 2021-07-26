import java.util.Scanner;

public class Baekjun {
	

	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int[] xArray = new int[N]; // x값 저장소 
		int[] yArray = new int[N]; // y값 저장소 
		int[] rankList = new int[N]; // 등수 저장소
		
		for(int i = 0; i < N ; i++) { // x, y를 공백으로 구분하여 기입한 값을 x, y저장소에 순서대로 저장
			int x = sc.nextInt();
			int y = sc.nextInt();
			xArray[i] = x;
			yArray[i] = y; 
		}
		for (int i = 0 ; i < N ; i++) { 
			rankList[i] += 1;                                       // 배열은 N의 크기만큼 초기값 0이 저장되어있음. 그래서 1씩 더해줘서 1등부터 시작하는 등수를 만듦.
			for (int j = i+1; j < N ; j++ ) {                       // 모든 수열을 비교하는 경우의 수, 비교는 굉장히 간단했다, 
				if (xArray[i] < xArray[j] && yArray[i] < yArray[j]) { //처음에는 같은 등수를 어떻게 넣으면 좋을까 고민했으나
					rankList[i] += 1;                                   // 결론은 다 비교하다보면 어차피 같은 수가 나올 것이라 판단했다.
				}

				else if (xArray[i] > xArray[j] && yArray[i] > yArray[j]) {
					rankList[j] += 1;
				}
				
			}
		}
		for (int i = 0; i < rankList.length; i++) {                // 원하는 양식대로 출력하기 위해, 공백으로 구분하여 등수 출력.
			System.out.print(rankList[i] + " ");
		}
	}
		
  }
