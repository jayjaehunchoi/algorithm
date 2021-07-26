import java.util.ArrayList;
import java.util.Scanner;

public class Baekjun {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 1 ~ N 까지 만들기 
		//최소의 인원만 쓰면서 Delfile 1회로 모든 국회의원을 짜르려면 
		//국회의원의 명예가 1 ~ N까지 등차 1을 가지는 수열이 되어야 한다.
		ArrayList<Integer> nList = new ArrayList<Integer>();
		for(int i = 1 ; i < N+1; i++ ) {
			nList.add(i);
		}
		
		// 국회의원 명예 입력 리스트
		ArrayList<Integer> honorList = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			honorList.add(sc.nextInt());
		}
		
		//nList와 honorList를 비교하여
		//nList에 honorList의 인자가 포함되어 있으면 nList에서 제거
		//포함되어 있지 않으면 해당 인자는 빈 어레이에 저장
		ArrayList<Integer> blankList = new ArrayList<Integer>();
		for(int i = 0 ; i < honorList.size(); i++) {
			if (nList.contains(honorList.get(i))) {
				nList.remove(nList.indexOf(honorList.get(i)));
			}
			else {
				blankList.add(honorList.get(i));
			}
		}
		
		//nList와 blankList비교하여 blankList의 숫자를 nList의 값으로 바꿔주기
		int result = 0;
		for(int i = 0 ; i < nList.size(); i++) {
			result += blankList.get(i) - nList.get(i);
		}
		
		System.out.println(result);
		
		
	}
}

/*
문제를 이해하기가 어려웠다..
하지만 결국 1회의 Delfile를 통해 모든 국회의원을 자르기 위해서는
그들의 명예 값이 등차가 1인 연속된 숫자 혹은 그 아래가 되어야 한다.
즉, 등차가 1인 연속된 숫자를 만드는 것이 최소 인원을 사용하는 방안이 되는 것이다.
*/


