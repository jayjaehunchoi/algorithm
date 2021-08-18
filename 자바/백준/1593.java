// 메모리 초과 실패 ;; 순열밖에 풀이가 안떠오르는데, 문자열이 최대 3000개임 ;;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	
	static List<String> gList = new ArrayList<String>();
	static String[] johap;
	static StringBuilder sb = new StringBuilder();
	static  boolean[] check;
	public static void backTracking(String W, int k) {
		
		if(k == W.length()){
			for(String s : johap) {
				sb.append(s);
			}
			gList.add(sb.toString());
			sb.setLength(0);
			return;
		}
		
		for(int i = 0 ; i < W.length(); i++) {
			if(!check[i]) {
				johap[k] = W.substring(i,i+1);
				check[i] = true; 
				backTracking(W, k+1);
				check[i] = false;
			}
		}
	
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int g = Integer.parseInt(st.nextToken());
		int sLength = Integer.parseInt(st.nextToken());
		
		String W = br.readLine();
		String S = br.readLine();

		johap = new String[W.length()];
		check = new boolean [W.length()];
		List<String> sList = new ArrayList<String>();
		
		
		for(int i = 0 ; i < sLength-g ; i++) {
			sList.add(S.substring(i,i+4));
		}
		backTracking(W, 0);

		int answer = 0;
		
		for(int i = 0 ; i < gList.size() ; i++) {
			if(sList.contains(gList.get(i))) {
				answer++;
			}
		}
		System.out.println(answer);
		
    }
}
