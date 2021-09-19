import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Jewel implements Comparable<Jewel>{
	int wgt;
	int price;
	
	public Jewel(int wgt, int price) {
		this.wgt = wgt;
		this.price = price;
	}
	
	public int compareTo(Jewel o) {
		return this.wgt - o.wgt;
	}
}


class Main {
	
	


    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Jewel> aList = new ArrayList<Jewel>();
		List<Integer> bList = new ArrayList<>();
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine()," ");
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			aList.add(new Jewel(w,p));
			
		}
		for(int i = 0 ; i < m; i++) {
			bList.add(Integer.parseInt(br.readLine()));
		}
    //둘 다 무게순 오름차순 정렬
		Collections.sort(aList);
		Collections.sort(bList);
    
    // 가격 순으로 내림차순 될 수 있게 (-)를 붙혀서 큐에 넣어줌
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		
		long ans = 0;
		int j = 0;
      
    //최대한 넣을 수 있는 무게까지 찾으면서 그 중 , 가장 큰값(que의 첫번째 값)을 챙겨간다.
    // 다음 무게를 가진 가방은 바톤을 이어받아 작업한다.
		for(int i = 0 ; i < m; i++) {
			while(j < n && aList.get(j).wgt <= bList.get(i)) {
				que.add(aList.get(j).price * -1);
				j++;
			}
			if(!que.isEmpty()) {
				ans += Math.abs(que.poll());
			}
		}
		System.out.println(ans);
			
    }
}
