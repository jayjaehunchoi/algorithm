import java.math.BigInteger;
import java.util.Scanner;


class Main {
	
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger m1 = BigInteger.ONE;
		
		for(int i = 0 ; i < m ; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(n-i)));
			m1 = m1.multiply(new BigInteger(String.valueOf(i+1)));
		}
		BigInteger answer= n1.divide(m1);
		
		System.out.println(answer);
		
		
	}
}
