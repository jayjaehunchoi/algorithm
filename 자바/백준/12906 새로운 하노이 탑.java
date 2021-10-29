import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// 하노이 탑 Check용 Node
class Node{
	Stack<Character>[] stacks;
	int times;
	public Node(int times) {
		this.stacks = new Stack[3];
		for(int i = 0 ; i < 3; i++) {
			stacks[i] = new Stack<>();
		}
		this.times = times;
	}
	
  // 방문 체크
	public String compareVisited() {
		String res = "";
		for(Character c : stacks[0]) {
			res += c;
		}
		res += "/";
		for(Character c : stacks[1]) {
			res += c;
		}
		res += "/";
		for(Character c : stacks[2]) {
			res += c;
		}
		return res;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
	
}
class Main {
	public static Queue<Node> que= new LinkedList<>();;
	public static String answer;
	public static Set<String> visited;
	
  // 한 싸이클에서는 poll한 node값 유지
	public static Node copy(Node node) {
		Node newN = new Node(node.times);
		for(int i = 0 ; i < 3; i++) {
			int s = node.stacks[i].size();
			for(int j = 0 ; j < s; j++) {
				newN.stacks[i].add(node.stacks[i].get(j));
			}
		}
		return newN;
	}
	
	public static int bfs() {
		while(!que.isEmpty()) {
			Node node = que.poll();
			if(node.compareVisited().equals(answer)) {
				return node.times;
			}
			
      // 하노이탑 옮길 수 있는 모든 경우의 
			if(!node.stacks[0].isEmpty()) {
				for(int i = 0 ; i < 3; i++) {
					if(i == 0)continue;
					Node copy = copy(node);
					copy.stacks[i].add(copy.stacks[0].pop());
					if(!visited.contains(copy.compareVisited())) {
						visited.add(copy.compareVisited());
						copy.setTimes(node.times+1);
						que.add(copy);	
					}
				}
			}
			if(!node.stacks[1].isEmpty()) {
				for(int i = 0 ; i < 3; i++) {
					if(i == 1)continue;
					Node copy = copy(node);
					copy.stacks[i].add(copy.stacks[1].pop());
					if(!visited.contains(copy.compareVisited())) {
						visited.add(copy.compareVisited());
						copy.setTimes(node.times+1);
						que.add(copy);	
					}
				}
			}
			if(!node.stacks[2].isEmpty()) {
				for(int i = 0 ; i < 3; i++) {
					if(i == 2)continue;
					Node copy = copy(node);
					copy.stacks[i].add(copy.stacks[2].pop());
					if(!visited.contains(copy.compareVisited())) {
						visited.add(copy.compareVisited());
						copy.setTimes(node.times+1);
						que.add(copy);	
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a = 0;
		int b = 0; 
		int c = 0;
		
		
		visited = new HashSet<String>();
		
		Node initNode = new Node(0);
		for(int i = 0 ; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num == 0)continue;
			String pan = st.nextToken();
			for(int j = 0 ; j < num ; j++) {
				Character cha = pan.charAt(j);
				initNode.stacks[i].add(cha);
				if(cha == 'A')a++;
				else if(cha == 'B')b++;
				else c++;
			}
		}
		
    // 정답 노드 만들기
		Node answerNode = new Node(0);
		for(int i = 0 ; i < a; i++) answerNode.stacks[0].add('A');
		for(int i = 0 ; i < b; i++) answerNode.stacks[1].add('B');
		for(int i = 0 ; i < c; i++) answerNode.stacks[2].add('C');
		
		answer = answerNode.compareVisited();
    
    // 최초입력노드부터 bfs 시작
		que.add(initNode);
		visited.add(initNode.compareVisited());
		System.out.println(bfs());
		
	}
} 
