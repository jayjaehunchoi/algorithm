import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	
	int idx;
	int wgt;
	
	public Node(int idx, int wgt) {
		this.idx = idx;
		this.wgt = wgt;
	}
	
}
class Main {
	static List<ArrayList<Node>> aList = new ArrayList<>(); // 메모리 문제 해결위해 util패키지 사용하여 
	static boolean[] check;
	static int n;
	static int m;
  
  // 최대중량, 0 중간값을 mid로 두고 , 비교
  // 만약 목표 위치인데, 중간값보다 큰값이 없으면 아래 부분 비교
  // 있으면 미드부터 최대중량 비교 반복()
	public static boolean bfs(int x, int y, int m) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		check[x] = true;
		while(!q.isEmpty()) {
			
			int idx = q.poll();
			
			if(idx == y)return true;
			
			for(int i = 0 ; i < aList.get(idx).size(); i++) {
				if(!check[aList.get(idx).get(i).idx] && m <= aList.get(idx).get(i).wgt) {
					check[aList.get(idx).get(i).idx] = true;
					q.add(aList.get(idx).get(i).idx);
				}
			}
		}
		return false;
				
		
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int lft = 0;
		int rgt = 0;
		int max = 0;
		for(int i = 0 ; i < n+1; i++) {
			aList.add(new ArrayList<Node>());
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int brid =  Integer.parseInt(st.nextToken());
			
			aList.get(s).add(new Node(e,brid));
			aList.get(e).add(new Node(s,brid));
			
			max = Math.max(max, brid);
		}
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		rgt = max;
		
		while(lft <= rgt) {
			
			check = new boolean[n+1];
			int mid = (lft + rgt)/2;
			
			if(bfs(x, y, mid)) {
				lft = mid+1;
			}else {
				rgt = mid-1;
			}
			
		}
		System.out.println(rgt);
	
	}
}

