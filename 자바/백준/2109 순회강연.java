import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Course implements Comparable<Course>{
	
	int p;
	int d;
	
	public Course(int p, int d) {
		this.p = p;
		this.d = d;
	}

	@Override
	public int compareTo(Course o) {
		return this.d - o.d;
	}
	
}
class Main {
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		PriorityQueue<Course> pq = new PriorityQueue<Course>();
		PriorityQueue<Integer> pricePq = new PriorityQueue<Integer>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.add(new Course(p,d));
		}
		
    // 날짜 순 정렬 후 대기 큐에 넣고, 작업 큐에 현재 날짜보다 많은 강좌 (pay) 가 들어와있으면 poll 
		while(!pq.isEmpty()) {
			Course c = pq.poll();
			pricePq.add(c.p);
			if(!pq.isEmpty()) {
				while(c.d == pq.peek().d) {
					pricePq.add(pq.poll().p);
					if(pq.isEmpty())break;
				}
			}
			while(pricePq.size() > c.d) {
				pricePq.poll();
			}
		}
		long answer = 0;
		while(!pricePq.isEmpty()) {
			answer += pricePq.poll();
		}
		System.out.println(answer);

    }
  
}
