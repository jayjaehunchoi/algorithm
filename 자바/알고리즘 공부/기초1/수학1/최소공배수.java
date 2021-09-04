
import java.util.*;
class Main{
	
	public static long gcd(long a , long b) {
		
		if(b == 0) {
			return a;
		}
		
		long tmp = b;
		b = a%b;
		a = tmp;
		
		return gcd(a,b);
		
		
	}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for(int i= 0 ; i < t ; i++) {
        	 long a = sc.nextInt();
             long b = sc.nextInt();
             
             System.out.println(a*b/gcd(a, b));
        }
        	
    }
}
