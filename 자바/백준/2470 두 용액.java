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
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	 	List<Integer> aList = new ArrayList<>();
     	
     	for(int i = 0 ; i < n; i++) {
     		aList.add(Integer.parseInt(st.nextToken()));
     		
     	}
     	Collections.sort(aList);
     	
     	int left = 0;
     	int right = aList.size()-1;
     	
     	int min = Integer.MAX_VALUE;
     	int[] arr= new int[2];
     	
      // 두 수의 합이 0보다 크다는 것은 , 양수가 줄어들어야 0에 가까워진다는 뜻이고,
      // 두 수의 합이 0보다 작다는 것은 , 음수가 커져야 0에 가까워진다는 뜻이다.  
     	while(left < right) {
     		if(aList.get(left) + aList.get(right) > 0) {
     			min = Math.min(min, Math.abs(aList.get(left) + aList.get(right)));
     			if(min == Math.abs(aList.get(left) + aList.get(right))) {
     				arr[0] = aList.get(left);
     				arr[1] = aList.get(right);
     			}
     			right--;
     		}else if(aList.get(left) + aList.get(right) < 0) {
     			min = Math.min(min, Math.abs(aList.get(left) + aList.get(right)));
     			if(min == Math.abs(aList.get(left) + aList.get(right))) {
     				arr[0] = aList.get(left);
     				arr[1] = aList.get(right);
     			}
     			left++;
     		}else {
     			System.out.println(aList.get(left) + " " + aList.get(right));
     			return;
     		}
     	}
     	
     	System.out.println(arr[0] + " " + arr[1]);
     	
    }
  
}
