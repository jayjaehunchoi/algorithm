import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<String> aList = new ArrayList<String>();
		
		
		for(int i = 0 ; i < n ; i++) {
			
			String s = sc.next();
			
			if(!aList.contains(s)) {
				aList.add(s);
			}
			
		}
		String[][] words = new String[aList.size()][2];
		for(int i = 0 ; i < aList.size() ; i++) {
			words[i][1] = String.valueOf(aList.get(i).length());
			words[i][0] = aList.get(i);
    }
    
    // 알파벳순 > 길이순으로 소트해주면 됨
		Arrays.sort(words, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].compareTo(o2[0]);
			}
		});
		
		Arrays.sort(words, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
			}
		});

		
		for(int i = 0 ; i < words.length ;i++) {
			System.out.println(words[i][0]);
		}
		
	}
}
