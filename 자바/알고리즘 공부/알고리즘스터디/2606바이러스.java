import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] node;
	static boolean[] check;
	static int count = 0;

  public static void bfs(int x) {
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(x);
		check[x] = true;

    //더이상 추가될 수가 없을때까지..
		while(!que.isEmpty()) {
			
			int number = que.poll();
			for(int i = 0 ; i < node.length ; i++) {
				if(node[number][i] == 1 && !check[i]) {
					count++;
					que.offer(i);
					bfs(i);
				}
			}

		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
    // 7까지의 숫자가 들어가야하기때문에
    // 배열 크기는 8x8로 설정
    // 체크도 7까지 해주기 때문에 크기 8로 설정
		node = new int[N+1][N+1];
		check = new boolean[N+1];
		
		for(int i = 0; i < M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
    // 상호연결관계 표시
			node[a][b] = 1;
			node[b][a] = 1;
		}
		
		bfs(1);
		System.out.println(count);

	}
}
