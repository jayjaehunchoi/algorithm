import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] sumba = new int[100001];
	static int n;
	static int k;
	static int cnt;
	static int time;
	static int min = Integer.MAX_VALUE;
	public static void findDong() {
		Queue<Integer> que= new LinkedList<Integer>();
		que.add(n);
		while(!que.isEmpty()) {
			int val = que.poll();
			if(sumba[k] != 0) {
				min = Math.min(min, sumba[k]);
			}
			
			if(val-1 >= 0 &&(sumba[val-1] == 0 || sumba[val-1] == sumba[val] +1)) {
				que.add(val-1);
				sumba[val-1] = sumba[val]+1;
				if(val-1 == k) {
					cnt++;
				}
			}
			if(val+1 <= 100000 &&(sumba[val+1] == 0 || sumba[val+1] == sumba[val] +1)) {
				que.add(val+1);
				sumba[val+1] = sumba[val]+1;
				if(val+1 == k) {
					cnt++;
				}
			}
			if(val*2 <= 100000 &&(sumba[val*2] == 0 || sumba[val*2] == sumba[val] +1)) {
				que.add(val*2);
				sumba[val*2] = sumba[val]+1;
				if(val*2 == k) {
					cnt++;
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	 	
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n == k) {
			System.out.println(0);
			System.out.println(1);
			
		}else {
			findDong();
			System.out.println(min);
			System.out.println(cnt);
		}
    }
  
}
