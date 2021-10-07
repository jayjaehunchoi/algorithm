import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		long answer = 0;
    // 누적합 + 1 값보다 큰 값이 다음 index에 오면 해당 값이 첫번째로 비교 못하는 무게이다.  
		for(int i = 0 ; i < n ; i++) {
			if(answer + 1 < arr[i]) {
				break;
			}
			answer += arr[i];
		}
		System.out.println(answer +1);

    }
  
}
