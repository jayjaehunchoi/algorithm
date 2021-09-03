import java.util.Scanner;
import java.util.Stack;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = sc.nextInt();
		int[] seq = new int[N];
		
		for(int i = 0; i < N; i++) {
			seq[i] = sc.nextInt();
		}
 
    // 처음에 나는 , 값끼리 비교해서 동일하게 만은 arrayList의 인덱스와 비교하며
    // 해당 인덱스에 값을 넣어주었다.
    // 계속 시간초과가 나서 보니, 인덱스로 비교해주면 되더라..
    // 나는 엄청 무거운 O(N) 시간인거같고 이거는 일반적인 O(N) 시간으로 계산된다.
		for(int i = 0; i < N; i++) {
			
			while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
				seq[stack.pop()] = seq[i];
			}
			
			stack.push(i);
		}
		

		while(!stack.isEmpty()) {
			seq[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(seq[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}
