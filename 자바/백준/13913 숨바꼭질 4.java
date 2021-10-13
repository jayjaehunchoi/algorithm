import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Ways{
	int cur;
	int cnt;
	List<Integer> aList = new ArrayList<Integer>();
	
	public Ways(int cur ,int cnt) {
		this.cur = cur;
		this.cnt = cnt;
	}
}
class Main {
	static int[] check = new int[100001];
	static int n;
	static int k;
  
  
	public static void bfs() {
		Queue<Ways> que = new LinkedList<>();
		que.add(new Ways(n, 0));
		check[n] = 1;
		
		while(!que.isEmpty()) {
			Ways way = que.poll();		
			int curVal = way.cur;
			
			if(curVal == k) {
				System.out.println(way.cnt);
				System.out.print(n+" ");
				for(int i = 0 ; i < way.aList.size(); i++) {
					System.out.print(way.aList.get(i) + " ");
				}
				return;
			}
			
			if(curVal-1 >= 0 && check[curVal-1] == 0) {
				Ways w = new Ways(curVal-1, way.cnt+1);
				addList(w, way.aList);
				w.aList.add(curVal-1);
				que.add(w);
				check[curVal-1] = check[curVal]+1;	
			}
			if(curVal+1 <= 100000 && check[curVal+1] == 0) {
				Ways w = new Ways(curVal+1, way.cnt+1);
				addList(w, way.aList);
				w.aList.add(curVal+1);
				que.add(w);
				check[curVal+1] = check[curVal]+1;
			}
			if(curVal*2 <= 100000 && check[curVal*2] == 0) {
				Ways w = new Ways(curVal*2, way.cnt+1);
				addList(w, way.aList);
				w.aList.add(curVal*2);
				que.add(w);
				check[curVal*2] = check[curVal]+1;	
			}
		}
	}
	
  // 리스트 깊은 복사
	public static void addList(Ways w, List<Integer> aList) {
		for(int i = 0 ; i <aList.size(); i++) {
			w.aList.add(aList.get(i));
		}
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
    // n이 더 큰경우에는 -1씩 하는거밖에 답이 없다. 그래서 bfs를 안돌고 바로 출력하게 해줬다.
		if(n > k) {
			System.out.println(n-k);
			for(int i = n ; i >= k; i--) {
				System.out.print(i + " ");
			}
			return;
		}
		
		bfs();
		
    }
  
}
