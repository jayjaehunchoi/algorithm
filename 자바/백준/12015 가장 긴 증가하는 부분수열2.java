import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		
		aList.add(Integer.parseInt(st.nextToken()));
		
		for(int i = 1 ; i < n ; i++) {
			int val = Integer.parseInt(st.nextToken());
			if(aList.get(aList.size()-1) < val)aList.add(val);
			else {
				int start = 0;
				int end = aList.size()-1;
				
				while(start < end){
					int mid = (start+end)/2;
					
					if(aList.get(mid) < val)start = mid+1;
					else end = mid;
							
				}
				aList.set(end, val);
			}
		}
		System.out.println(aList.size());
		
	}
}
