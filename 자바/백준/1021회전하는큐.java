import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Main {
	
	static Queue<Integer> que = new LinkedList<Integer>();
	static Stack<Integer> stack = new Stack<Integer>();
	static int qCount;
	static int sCount;
	
	public static void queue(List<Integer> aList, int target) {
		qCount = 0;
		que.clear();
		for(int i = 0 ; i < aList.size(); i++) {
			que.add(aList.get(i));
		}
		
		while(que.peek() != target) {
			que.offer(que.poll());
			qCount++;

		}
		que.poll();
		return;

	}
	
	public static void stack(List<Integer> aList, int target) {
		sCount = 0;
		stack.clear();
		for(int i = 0 ; i < aList.size(); i++) {
			stack.add(aList.get(i));
		}
		
		while(stack.peek() != target) {
			stack.add(0, stack.pop());
			sCount++;

		}
		sCount++;
		stack.pop();
		return;
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer = 0;
		List<Integer> aList = new ArrayList<Integer>();
		int[] nums = new int [m];
		
		for(int i = 1 ; i < n+1 ; i++) {
			aList.add(i);
		}
		
		for(int i = 0 ; i < m; i++) {
			nums[i] = sc.nextInt();
			
			queue(aList, nums[i]);
			stack(aList, nums[i]);
	
			aList.clear();
			if(qCount <= sCount) {
				answer += qCount;
				Iterator ir = que.iterator();
				while(ir.hasNext()) {
					aList.add((int)(ir.next()));
				}
			}
			
			else if(qCount > sCount) {
				answer += sCount;
				Iterator ir = stack.iterator();
				while(ir.hasNext()) {
					aList.add((int)(ir.next()));
				}
				
			}

		}
		System.out.println(answer);
	}

}
	

