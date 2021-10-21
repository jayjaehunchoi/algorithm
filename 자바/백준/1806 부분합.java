import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		int start = 0;
		int end = 0;
		
		int min = Integer.MAX_VALUE;
		int res = arr[0];
		while(true) {
			if(res < s) {
				end++;
				if(end >= n) {
					break;
				}
				res += arr[end];
			}else {
				min = Math.min(end-start+1, min);
				res -= arr[start];
				start++;
				 
			}
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(min);
		
    }
  
}
