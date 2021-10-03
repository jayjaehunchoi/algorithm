import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
     	int answer= 0;
     	int idx = -1;
      
      
		Queue<Integer> que = new LinkedList<Integer>();
      
      // 음수일경우 곱이 0, 양수인경우 더해주고 부호가 달라지면 break.
		if(arr[0] < 0) {
			for(int i = 0 ; i < n; i++) {
				if(arr[i] > 0) {
					break;
				}
				if(que.isEmpty()) {
					que.add(arr[i]);
				}else {
					if(que.peek() * arr[i] >= 0 ) {
						answer +=que.poll() * arr[i];
					}else {
						answer += que.poll();
						idx= i;
						break;
					}
				}
			}
		}
      // 작업큐에 남은 녀석들 다 비워준다.
		while(!que.isEmpty()) {
			answer += que.poll();
		}
      
      // 양수일경우 , 곱이 합보다 큰경우 곱을, 합이 곱보다 큰경우 합을 더해준다.
		if(arr[n-1] > 0) {
			for(int i = n-1; i > idx; i--) {
				if(arr[i] < 0) {
					break;
				}
				if(que.isEmpty()) {
					que.add(arr[i]);
				}else {
					if(que.peek() * arr[i] > 0)  {
						
						if(que.peek() * arr[i] > que.peek() + arr[i]) {
							answer += que.poll() * arr[i];
						}else {
							answer += que.poll() + arr[i];
						}
						
					}else {
						answer += que.poll();
						idx= i;
						break;
					}
				}
			}
		}
		
      // que가 빌때까지 더해준다.
		while(!que.isEmpty()) {
			answer += que.poll();
		}
		
		System.out.println(answer);
		
    }
  
}
