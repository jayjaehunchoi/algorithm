
import java.util.Scanner;

class Main {
	
  // Integer library사용해도 되려나? 
  // 암튼 여느 진법변환처럼 풀면된다
  
	static StringBuilder sb= new StringBuilder();
	public static String toBin(long n) {
		
		while(n != 0) {
			
			sb.append(n%2);
			n /= 2;
			
		}
		
		return sb.reverse().toString();
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		String s = toBin(n);
		System.out.println(s);
		
	}

}
	

