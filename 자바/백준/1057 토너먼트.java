import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static int divide(int num) {
		if(num % 2 != 0) {
			num+=1;
		}
		return num /2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		
		int round = 0;
		
		while(lim != kim) {
			lim = divide(lim);
			kim = divide(kim);
			round++;
		}
		System.out.println(round);
		
	}
} 
