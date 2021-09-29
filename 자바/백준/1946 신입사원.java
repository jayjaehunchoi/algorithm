import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int res;
	int inter;
	
	public Node(int res, int inter) {
		this.res = res;
		this.inter = inter;
	}

	@Override
	public int compareTo(Node arg0) {
		return this.res-arg0.res;
	}
}
class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> resume = new PriorityQueue<Integer>();
			PriorityQueue<Integer> interview = new PriorityQueue<Integer>();
			
			StringTokenizer st;
			Node[] arr = new Node[n];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int res = Integer.parseInt(st.nextToken());
				int inter = Integer.parseInt(st.nextToken());
				
				arr[i]= new Node(res,inter);
			}
			Arrays.sort(arr);
			int pass = n;
			for(int i = 0 ; i < n ; i++) {
				int cnt = 0;
				int r = arr[i].res;
				int in = arr[i].inter;
				
				resume.add(r);
				interview.add(in);
				
				if(resume.peek() == r) {
					cnt++;
				}
				if(interview.peek() == in) {
					cnt++;
				}
				
				if(cnt == 0) {
					pass--;
				}
				
			}
			System.out.println(pass);
			
		}
    }
  
}
