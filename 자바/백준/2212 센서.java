import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      // 중복값 제거 겸, 순차 배열만들기
		Set<Integer> set = new TreeSet<>();
		for(int i = 0 ; i < n ; i++) {
			int sensor = Integer.parseInt(st.nextToken());
			set.add(sensor);
		}
		List<Integer> aList = new ArrayList<Integer>();
		Iterator<Integer> ir = set.iterator();
      
      // 중복없이 순서대로 배치
		while(ir.hasNext()) {
			aList.add(ir.next());
		}
		
      // 각 센서 별 차이 값 체크
		int[] dist = new int[n-1];
		for(int i = 1 ; i< aList.size(); i++) {
			dist[i-1] = aList.get(i)- aList.get(i-1);
			
		}
      // 차이 오름차순 배열
		Arrays.sort(dist);
		int ans = 0;
      
      // 2로 나뉘면 최대거리 하나 빼고, 3으로 나뉘면 최대거리 두개 빼고 .... n으로 나뉘면 최대거리 n-1 개 빼고 합
		for(int i = 0 ; i < dist.length- (k-1) ; i++) {
			ans += dist[i];
		}
		System.out.println(ans);

    }
  
}
