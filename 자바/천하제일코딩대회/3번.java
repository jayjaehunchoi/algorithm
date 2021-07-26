import java.util.ArrayList;
import java.util.Scanner;

public class C {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String S = sc.next();
    
		// 이후에 남은 문자열에 문장이 두개인지 하나인지 구분하기 위해.
    int dotCount = 0; 
    
    // 남은 문자열을 하나씩 떼어주려고 만든 arraylist
		ArrayList<String> leftList = new ArrayList<String>();
		
    // 25글자 아래는 이렇게 출력하고 끝
		if (S.length() <= 25) {
			System.out.println(S);
		}
		
    // 25글자 이상은 두가지 조건이 있음.
    // 1번 조건 앞 11, 뒤 11 제외 문자열을 찾는다.
	// 한 문장일 경우 ... 두 문장일 경우 앞 9 ...... 뒤 10 으로 중략한다.
	// 맨뒤에 .이 있는 건 하나의 문장이라는 뜻으로 맨뒤 제외 . 개수를 찾는다.
	// 이 때 . 개수가 0보다 크면 두문장.
		else if( 25 < S.length()) {
			
			for(int i = 12; i < N-11 ; i++) {
				leftList.add(S.substring(i,i+1));
			}
			
			for(int i = 0 ; i < leftList.size()-1; i++) {
				
				// .으로 찾으려니까 카운트가 안된다. 따라서 아스키코드 사용.
				if(leftList.get(i).charAt(0) == (char) 46 ) {
					dotCount++;		
				}	
			}
			
			if (dotCount > 0) {
				System.out.println(S.substring(0,9) + "......" + S.substring(N-10,N));
			}
			
			else {
				System.out.println(S.substring(0,11) + "..." + S.substring(N-11,N));
				
			}			
		}						
	}
}
