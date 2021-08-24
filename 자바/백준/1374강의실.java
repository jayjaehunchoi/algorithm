
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
	
	int num;
	int s;
	int e;
	
	public Node(int num, int s, int e) {
		this.num = num;
		this.s = s;
		this.e = e;
	}
	
}

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Node> courseInfo = new ArrayList<Node>();
		
		for(int i = 0 ; i < n ; i++) {
			int num = sc.nextInt();
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			courseInfo.add(new Node(num,s,e));
		}
		
		Collections.sort(courseInfo, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
		
				return o1.s - o2.s;
			}
		});
		
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		
		for(int i = 0 ; i < courseInfo.size(); i++) {
			if(!que.isEmpty() && que.peek() <= courseInfo.get(i).s) {
				que.poll();
			}
			
			que.add(courseInfo.get(i).e);
			
		}
		System.out.println(que.size());
		
	}

}
	

