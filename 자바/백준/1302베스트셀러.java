
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < n ; i++) {
			String s = sc.next();
			map.put(s, map.getOrDefault(s,0)+1);
		}
	
		int max = 0;
		List<String> aList = new ArrayList<String>();
		
		for(Entry<String,Integer> m : map.entrySet()) {
			if(m.getValue() > max) {
				max = m.getValue();
				
			}
		}
		
		for(Entry<String,Integer> m : map.entrySet()) {
			if(m.getValue() == max) {
				aList.add(m.getKey());
			}

		}
		
		Collections.sort(aList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
		});

		
		System.out.print(aList.get(0));	
	}

}
	

