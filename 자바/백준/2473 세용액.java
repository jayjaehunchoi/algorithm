import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		List<Long> aList = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	 	for(int i = 0 ; i < n ; i++) {
	 		aList.add(Long.parseLong(st.nextToken()));
	 	}
	 	
	 	Collections.sort(aList);
	 	long min = Long.MAX_VALUE;
	 	int third = 0;
	 	long[] arr = new long[3];
      
    // 세번째 용액은 고정, 나머지는  start , end로 이분탐색한다.
	 	while(true) {
	 		
		 	int start = third+1;
		 	int end = n-1;
      // 모두 탐색 완료하면, 정답 출력
		 	if(start == end) {
		 		System.out.println(arr[0] +" " + arr[1] + " " + arr[2]);
		 		return;
		 	}
		 	while(start < end) {
		 		long sum = aList.get(start) + aList.get(end) + aList.get(third);
		 		if(min > Math.abs(sum)) {
	 				min = Math.abs(sum);
	 				arr[0] = aList.get(third);
	 				arr[1] = aList.get(start);
	 				arr[2] = aList.get(end);
	 			}
		 		if(sum< 0) {
		 			start++;
		 			
		 		}else if(sum > 0) {
		 			end--;
		 			
		 		}else {
		 			System.out.println(aList.get(third) +"  " + aList.get(start)+" " + aList.get(end));
		 			return;
		 		}
		 	}
		 	third++;
	 	}
    }
  
}
