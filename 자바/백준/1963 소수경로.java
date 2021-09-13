import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x;
	int count;
	
	public Node(int x, int count) {
		this.x = x;
		this.count = count;
	}
}

class Main {
	static Map<Integer,String> map;
	static boolean[] visited;
	public static int bfs(int sosu1, int sosu2) {
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(sosu1, 0));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			int key = node.x;
			if(key == sosu2) {
				return node.count;
			}
			
			for(Entry<Integer, String> e : map.entrySet()) {
				if(diffOne(e.getValue(), map.get(key)) == 1 && !visited[e.getKey()]) {
//					System.out.println(e.getValue() + " " + node.count);
					visited[e.getKey()] = true;
					que.add(new Node(e.getKey(), node.count+1));
				}
			}
		}
		return 0;
		
	}
	
	public static int diffOne(String s1, String s2) {
		int cnt = 0 ;
		
		for(int i = 0 ; i < 4; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				cnt++;
			}
		}
		
		return cnt;
		
		
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sosu1 = Integer.parseInt(st.nextToken());
			int sosu2 = Integer.parseInt(st.nextToken());
			
			if(sosu1 == sosu2) {
				sb.append(0+"\n");
				t--;
				continue;
			}
			
			map = new HashMap<Integer, String>();
			boolean[] sosu = new boolean[10000];
			visited = new boolean[10000];
			sosu[0] = true;
			sosu[1] = true;
			for(int i = 2; i*i < sosu.length; i++) {
				for(int j = i*i ; j < sosu.length ; j = j+i) {
					sosu[j] = true;
				}
			}
			
			for(int i = 1000 ; i < sosu.length; i++) {
				if(!sosu[i]) {
					map.put(i,String.valueOf(i));
				}
				
			}
			
			int ans = bfs(sosu1, sosu2);
			if(ans == 0) {
				sb.append("Impossible\n");
			}else {
				sb.append(ans+"\n");
			}
			t--;
		}
		System.out.println(sb.toString());
		
		
		
	}
}
