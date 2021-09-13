import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



class Main {
	static long c;
  
  // a^8 = ((a^2)^2)^2
  // a^9 = a*((a^2)^2)^2
	public static long newPow(long a, long b) {
		
		if(b == 1) {
			return a%c;
		}
		long tmp = newPow(a,b/2);
		
		if(b%2 == 1) {
			return (tmp*tmp%c)*a%c;
		}
		return tmp*tmp%c;	
	}
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		
		System.out.println(newPow(a, b));
		
	}
}
