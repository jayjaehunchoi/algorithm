import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


class Main {
	
	// Priority que를 이용해서 간단히 해결할 수 있는 문제이다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
    
		int n = Integer.parseInt(br.readLine());
	
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(que.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					sb.append(que.poll()+"\n");
				}
			}else {
				que.offer(num);
			}
		}
		System.out.println(sb.toString());
		
	}

}

	

