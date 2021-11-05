import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int[][] guitars = new int[7][p+1];
    
    // stack 6개
		Stack<Integer>[] stack = new Stack[7];
		
		for(int i = 0 ; i < 7; i++) {
			stack[i] = new Stack<Integer>();
		}
		int cnt = 0;
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int line = Integer.parseInt(st.nextToken());
			int frat =  Integer.parseInt(st.nextToken());
			
      // line별로 따로 관리
			if(stack[line].isEmpty()) {
				stack[line].push(frat);
				cnt++;
			}else {
				while(stack[line].peek() > frat) {
					stack[line].pop();
					cnt++;
					if(stack[line].isEmpty()) {
						break;
					}
				}
				if(stack[line].isEmpty()||stack[line].peek() < frat) {
					stack[line].push(frat);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
} 
