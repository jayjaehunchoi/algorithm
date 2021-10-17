import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0 ; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			pq.add(n);
		}
		
		int max = 0;
		while(!pq.isEmpty()) {
			int maxW = pq.poll()*k--;
			max = Math.max(maxW, max);
		}
		System.out.println(max);
		
    }
  
}
