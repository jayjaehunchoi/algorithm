import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
	static final int M = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(int i = 97 ; i < 123 ; i++) {
			map.put((char) i, i-96);
		}
		
		int n = sc.nextInt();
		String s = sc.next();
		
		long answer = 0;
		
		for(int i = 0 ; i < n ; i++) {
			
      // 사실 여기서 제곱에 M 의 나머지값을 주나 ,아래 static을 주나 뭔 차인지 모르것다 ;;.;
			answer += map.get(s.charAt(i))*pow(31,i);
			
			
		}
		
		System.out.println(answer%M);
		
    }
	
	static long pow(int a , int b) {
		return b == 0 ? 1:a*pow(a,b-1)%M;
	}
}
