import java.util.ArrayList;
import java.util.Scanner;

public class Baekjun {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
    //N번째 666 연속인 수 찾기
		int N = sc.nextInt();    
		
    //int N 을 통해 disasterList에서 666 연속 수를 찾을 것이다. 이 리스트에 666연속 수 추가.
		ArrayList<Integer> disasterList = new ArrayList<Integer>();
		
    
    // 6이 3연속 나와야하기때문에 사실 665 아래로는 볼 것도 없다.
    // 하지만 그래도 100부터 시작해줬다.
		for (int i = 100; i < 100000; i++) {
      
      // 이후에 3연속 6이 나올때 반복문을 멈춰줄 수 있도록 
      // 수를 세는 변수를 넣어줬다.
      // 이때 매번 새로운 수를 볼 때 마다 리셋해주기 위해 for문 안에 배치했다.
			int count = 0;
      
      // numComp 리스트에는 숫자를 뜯어서 한자리씩 넣겠다.
      // 물론 이 리스트도 매 숫자마다 초기화해야하기 때문에 for문 안에 배치했다.
			ArrayList<Integer> numComp = new ArrayList<Integer>();
      
      // 정수형을 자리마다 떼어내기 위해 먼저 문자열로 변경시켜준다.
			String strI = Integer.toString(i);
      
      
      // 문자열의 길이만큼 반복한다.
			for( int j = 0; j < strI.length(); j++) {
      
        // 각 수를 다시 숫자로 바꿔 numComp리스트에 하나씩 넣어준다.
        // 이때 굳이 안바꾸고 str형끼리 비교해줘도 문제는 없을 듯 하다.
				int numEach = Integer.parseInt(strI.substring(j,j+1));
				numComp.add(numEach);
        
			}
      
      // 리스트 각 주소에 있는 수를 하나씩 꺼내서 6인지 아닌지 확인하는 작업이다.
			for (int k = 0; k < numComp.size(); k++) {
        
				if(numComp.get(k) == 6) { 
					count++;
				}
        
        // 연달아 6이 나오지 않으면 다시 0으로 돌려버리는 코드
				else {                   
					count = 0;
				}
        
        // 연달아 6이 3번 나오면 멈추고 바로 리스트에 더하고 for 문 stop.
				if (count == 3) {       
					disasterList.add(i);
					break;
				}
        
			}
		}
    // 첫번째는 리스트의 0번이기 때문에 N-1 값을 가져온다.
		System.out.println(disasterList.get(N-1));		 
	}
					
  }

/* 
너무 많은 반복문이 돌아간다..
그래도 0.03초대로 컷되긴 하는데, 훨씬 더 좋은 방법이 있을 것같다.
코드도 더 간단하게 바뀔 필요가 있어 보인다...
과연 속도를 개선하려면 어떻게 풀어야할까..
이따 고민해봐야겠다.
*/
