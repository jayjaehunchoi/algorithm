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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[n];
		int[] sushi = new int[d+1];
		for(int i = 0 ; i < n ; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
      
      // 최초로 먹을 수 있는 스시 경우의수
		for(int i = 0 ; i < k; i++) {
      
      // 이미 먹지 않은 종류면 개수 +
			if(sushi[belt[i]] == 0) {
				count++;
			}
      // 이미 먹었다면 먹은 종류에서 +
			sushi[belt[i]]++;
		}
		
		int max = count;
		
		for(int i = 1; i < n ; i++) {
      
			if(max <= count) {
				if(sushi[c] == 0) { // 쿠폰 스시를 먹지 않았다면
					max = count+1;
				}else { // 쿠폰 스시를 이미 먹었다면
					max = count;
				}
			}
				
      // 가운데 스시들은 남기고 end스시 증가, start스시 제거
			int end = (i+k-1)%n;
			if(sushi[belt[end]] == 0) {
				count++;
			}
			sushi[belt[end]]++;
			
			sushi[belt[i-1]]--;
			if(sushi[belt[i-1]] == 0) {
				count--;
			}
			
			
		}
		System.out.println(max);
		
    }
  
}
