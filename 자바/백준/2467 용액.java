import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
	


    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = n-1;
		if(arr[start] >= 0) {
			System.out.println(arr[0] + " " + arr[1]);
			return;
		}else if(arr[end] <= 0) {
			System.out.println(arr[end-1]+" " + arr[end]);
			return;
		}

		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];
		while(start < end) {
			int curVal = arr[start]+arr[end];
			int val = Math.abs(curVal);
			if(val < min)  {
				answer[0] = arr[start];
				answer[1] = arr[end];
				min = val;
			}
			
			if(curVal > 0) end--;
			else if(curVal < 0)start++;
			if(curVal == 0) {
				break;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
    }
  
}
