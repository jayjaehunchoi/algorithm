import java.util.ArrayList;
import java.util.Scanner;

public class Baekjun {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String m = sc.next();
		int N = sc.nextInt();
		
    // 재밌다고 생각한 단어를 각각의 arraylist로 만들어준다.
		ArrayList<String> mList = new ArrayList<String>();
		for(int i = 0; i < m.length(); i++) {
			mList.add(m.substring(i,i+1));
		}
		
    // 이후 최대이면서, 먼저 입력된 녀석을 정답으로 꼽기위해 변수를 설정해줌.
		int maxCost = 0;
		String answer = "";
		
    // m을 바탕으로 만들어진 문자인지 확인하기위해 arraylist를 만들어준다.
    // compareList는 입력한 문자열을 개별로 넣는 arraylist이고
    // blankList는 compareList에 m이 순서대로 들어있는지 확인하고, 비교할 arraylist이다.
		for(int i = 0 ; i < N; i++) {
			ArrayList<String> compareList = new ArrayList<String>();
			ArrayList<String> blankList = new ArrayList<String>();
      
			String w = sc.next();
			int g = sc.nextInt();
      
      // compareList는 입력한 문자열을 개별로 넣는 arraylist
			for(int j = 0; j < w.length(); j++) {
				compareList.add(w.substring(j,j+1));
			}
			
      // cn 은 선택되고 해당 문자열 뒤부터 다시 문자를 빼내기 위해 선언한 변수
			int cn = 0;
			for(int j = 0; j < mList.size(); j++) {
				for(int k = 0; k < compareList.size(); k++) {
					for(int k = cn; k < compareList.size(); k++) {
            if(compareList.get(k).charAt(0) == mList.get(j).charAt(0)) {
              blankList.add(mList.get(j));
              cn = k;
              break;
            }
            
          // 같아졌으면 더 볼 필요 없음. (근데 이건 수정 전에 넣은거라 빼도 될 것 같다.)
					if(blankList.equals(mList)) {
						break;
					}
				}
			} 
			
      // 정답 혹은 no jam 출력하는 조건문.
			if(blankList.equals(mList)) {
				int cost =  g / (w.length() - m.length());
				if(cost > maxCost) {
					maxCost = cost;
					answer = w;
				}
			}
        
      // 정답이 빈칸임과 동시에 문자열이 같지 않은 친구들이 있으면 no jam
      // 만약 정답은 빈칸이다 조건을 빼면, 불상사가 발생한다.
			else if (answer == "" && !blankList.equals(mList)) {
				answer = "no jam";
			}
		}
		
		System.out.println(answer);						
	}
}

					
/*
풀이 시간 약 1시간 (수정하는 과정에서 오래걸림, 어떻게 하면 m 문자열을 바탕으로 만들어진건지 찾아내려고 여러 방법 시도하다가 시간 많이씀..)
문제 해석 약 5분
*/
