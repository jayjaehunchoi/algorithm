
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "";
		while( (s = br.readLine()) != null) {
			int[] cnt = new int[4];
			
			for(int i = 0 ; i < s.length() ; i++) {
				if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
					cnt[0]++;
				}else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
					cnt[1]++;
				}else if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
					cnt[2]++;
				}else {
					cnt[3]++;
				}
			}
			for(int i : cnt) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		
		
		
	}
}
