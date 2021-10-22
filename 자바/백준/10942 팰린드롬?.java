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
		int[] arr= new int[n+1];
		for(int i = 1 ; i <= n ; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			boolean check = true;
			while(start<end) {
				if(arr[start] == arr[end]) {
					start++;
					end--;
				}else {
					check = false;
					break;
				}
			}
			if(!check) {
				sb.append(0+"\n");
			}else {
				sb.append(1+"\n");
			}
		}
		System.out.println(sb);
	
    }
  
}
