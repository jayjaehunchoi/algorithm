
import java.util.*;
class Main{
	
	public static int gcd(int a , int b) {
		
		if(b == 0) {
			return a;
		}
		
		int tmp = b;
		b = a%b;
		a = tmp;
		
		return gcd(a,b);
		
		
	}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        System.out.println(gcd(a, b));
        System.out.println(a*b/gcd(a, b));
        
        
        
    }
}
