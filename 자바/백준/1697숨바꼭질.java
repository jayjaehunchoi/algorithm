import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	
	
	static int[] check = new int[1000001];
	static int n;
	static int k;
	
	public static void bfs(int node) {
		
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(node);
		int index = node; 
		int N = 0; 
		check[index] = 1;

		
		while(!que.isEmpty()) {
			
			N = que.poll();

			if (N == k) { 
				System.out.println(check[N]-1);
				return;
				
			} 
			
			if (N-1>=0 && check[N-1] == 0) {
				check[N-1] = check[N]+1; 
				que.add(N-1); 
			} 
			
			if (N+1 <= 100000 && check[N+1] == 0) {
				check[N+1] = check[N]+1; 
				que.add(N+1); 
			} 
			
			if (2*N <= 100000 && check[2*N] == 0) {
				check[2*N] = check[N] + 1; 
				que.add(2*N); 
			}

		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
		n = sc.nextInt();
		k = sc.nextInt();
		
		
		if(n==k) {
			System.out.println(0);
		}
		else {
			bfs(n);	
		}

	}

}
	

