import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Logistics implements Comparable<Logistics>{
	int start;
	int end;
	int weight;
	
	public Logistics(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Logistics o) {
		int res = 0;
		if(this.end - o.end < 0 )res = -1;
		else if(this.end == o.end) {
			if(this.start - o.start < 0) res = -1;
			else if(this.start == o.start) res = 0;
			else res=1;
		}else res = 1;
		return res;
	}
}

// 최대의 효율을 내려면, 중간에 최대한 많이 들려서 내리고 실어야한다 (아닌 경우도 있음)
// 이점을 기반으로 로직을 짜면 , 도착이 빠른순 -> 출발이 빠른순 으로 정렬하여, 각 마을에서 실을 수 있는 최대 한도에서 무게를 제외하는 식으로 로직을 짠다.
class Main {
	
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int towns = Integer.parseInt(st.nextToken());
		int limitedWeight = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Logistics> pq  = new PriorityQueue<Logistics>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Logistics(start, end, weight));
			
		}
		
		int[] townL = new int[towns];
		Arrays.fill(townL, limitedWeight);
		int answer = 0;
		while(!pq.isEmpty()) {
			Logistics l = pq.poll();
			int s = l.start;
			int e = l.end;
			int w = l.weight;
			for(int i = s; i < e; i++) {
				if(townL[i] < w) {
					w = townL[i];
				}
			}
			if(w != 0) {
				for(int i = s; i < e; i++) {
					townL[i] -= w;
				}
				answer += w;
			}

		}
		System.out.println(answer);
    }
  
}
