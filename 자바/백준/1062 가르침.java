import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


class Main {
	static int k;
	static Character[] words;
	static boolean[] check;
	static String[] antaWord;
	static List<Character> aList;
	static List<Character> extraList;
	static int max = 0;
	public static void comb(int idx, int count, int target) {
		
		if(count == target) {
			int comp = compare();
			max = Math.max(comp, max);
			return;
		}
		
		for(int i = idx; i < extraList.size(); i++) {
			if(!check[i]) {
				words[count] = extraList.get(i);
				check[i] = true;
				comb(i, count+1, target);
				check[i] = false;
			}
		}
		
	}
	
	public static int compare() {
		List<Character> wordList = Arrays.asList(words);
		int maCnt = 0;
		for(int i = 0 ; i < antaWord.length; i++) {
			int cnt = 0;
			for(int j = 0 ; j < antaWord[i].length(); j++) {
				
				if(wordList.contains(antaWord[i].charAt(j)) || aList.contains(antaWord[i].charAt(j))) {
					cnt++;
				}
				if(cnt == antaWord[i].length()) {
					maCnt++;
				}
			}
		}
		return maCnt;
		
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(k < 5) {
			System.out.println(0);
			return;
		}
		aList = new ArrayList<Character>();
		aList.add('a');
		aList.add('n');
		aList.add('t');
		aList.add('i');
		aList.add('c');
		
		k -= 5;
		words = new Character[k];
		
		antaWord = new String[n];
		extraList = new ArrayList<Character>();
		int same = 0;
		for(int i = 0 ; i < n ; i++) {
			String s = br.readLine();
			if(s.equals("antatica")) {
				same++;
			}
			s = s.substring(4,s.length()-4);
			antaWord[i] = s;
			for(int j = 0 ; j < s.length(); j++) {
				if(!aList.contains(s.charAt(j)) && !extraList.contains(s.charAt(j))  ) {
					extraList.add(s.charAt(j));
				}
			}
		}
		
		check = new boolean[extraList.size()];
		if(k > extraList.size()) {
			k = extraList.size();
		}
		comb(0, 0, k);
		System.out.println(max+same);
	}
}
