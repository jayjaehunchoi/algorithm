import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		int count = 0;
		while(b != a) {
			String s = String.valueOf(b);
			if(s.charAt(s.length()-1) == '1') {
				s = s.substring(0, s.length()-1);
				b = Integer.parseInt(s);
			}else if(b%2 == 0){
				b /= 2;
			}else if(b%2 != 0) {
				
				System.out.println(-1);
				return;
			}
			if(b<a) {
				System.out.println(-1);
				return;
			}
			count++;
		}
		System.out.println(count+1);
	}
}
