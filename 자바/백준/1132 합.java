import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Node{
	char c;
	long num;
	
	public Node(char c , long num) {
		this.c = c;
		this.num = num;
	}
	@Override
	public String toString() {
		return "Node [" + c + ", " + num + "]";
	}

}

class Main {
	static Map<Character, Long> map = new HashMap<Character, Long>();
	public static void putMap(String s) {
		int length = s.length()-1;
		for(int i = length ; i >= 0 ; i--) {
			Character c = s.charAt(i);
			int powNum = length-i;
			map.put(c, (Long) (map.getOrDefault(c, (long) 0)+ (long)Math.pow(10, powNum)));
		}
		
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long answer = 0;
		List<Character> fChar = new ArrayList<Character>();
		for(int i = 0 ; i < n  ; i++) {
			String s = br.readLine();
			fChar.add(s.charAt(0));
			putMap(s);
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return Long.compare(o1.num, o2.num);
			}
		});
		for(Entry<Character, Long> e : map.entrySet()) {
			pq.add(new Node(e.getKey(),e.getValue()));
		}
		int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
		
		// 시작점을 0부터 잡으면 안됨! 알파벳의 갯수에 맞게 자릿수 
		int i = arr.length - map.size();
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			char c= node.c;
			long num = node.num;
      // if 첫자리 0 이면 적당히 변경
			if(arr[i] == 0 && fChar.contains(c)) {
				int tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
			}
			answer += num* arr[i++];
			
			
		}
		System.out.println(answer);
		
    }
  
}
