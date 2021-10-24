import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static Map<Character, Integer> map = new HashMap<Character, Integer>();
	
	public static boolean checkMap() {
		for(Entry<Character, Integer> e : map.entrySet()) {
			if(e.getValue() != 0) {
				return false;
			}
		}
		return true;
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int wLength = Integer.parseInt(st.nextToken());
		int sLength = Integer.parseInt(st.nextToken());
		int answer = 0; 
		
		String w = br.readLine();
		String s = br.readLine();
		
		// 순열 체크
		for(int i = 0 ; i < w.length(); i++) {
			map.put(w.charAt(i),map.getOrDefault(w.charAt(i), 0)+1);
		}
		for(int i = 0 ; i < wLength; i++) {
			if(map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), map.get(s.charAt(i))-1);
			}
		}
		if(checkMap()) {
			answer++;
		}
      
    // 슬라이딩 윈도우 시작
		int start = 1;
		int end = wLength;
		
		while(end < sLength) {
			if(map.containsKey(s.charAt(start-1))){
				map.put(s.charAt(start-1), map.get(s.charAt(start-1))+1);
			}
			if(map.containsKey(s.charAt(end))){
				map.put(s.charAt(end), map.get(s.charAt(end))-1);
			}
			if(checkMap()) {
				answer++;
			}
			start++;
			end++;
		}
		System.out.println(answer);
    }
  
}
