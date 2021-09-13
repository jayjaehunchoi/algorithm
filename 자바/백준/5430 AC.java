import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
  // 간단한 구현문제였으나
  // List size가 딱 0이 됐을때의 상황을 예상치못했다;;;
  // 그리고 test case로 0과 D가 주어진 상황이 없었다면 이 부분도 예측못했을거다
  // 구현문제는 항상 예외 고민하자
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			
			String p = br.readLine(); //명령 수행 함수
			int n = Integer.parseInt(br.readLine()); // 리스트 개수
			String arr = br.readLine();
			List<Integer> aList = new ArrayList<>();
			boolean checkR = false;
			if(n==0) {
				int cnt = 0;
				for(int i = 0 ; i < p.length() ; i++ ) {
					if(p.charAt(i) == 'D') {
						sb.append("error\n");
						cnt++;
						break;
					}
				}
				if(cnt == 0) {
					sb.append("[]\n");
				}
				continue;
			}
			
			String s = "";
			for(int i = 1 ; i < arr.length(); i++) {
				if(arr.charAt(i) >= 48 && arr.charAt(i) <= 57) {
					s += arr.charAt(i);
				}else {
					aList.add(Integer.parseInt(s));
					s = "";
				}
			}
			int cc = 0;
			for(int i = 0 ; i < p.length(); i++) {
				if(p.charAt(i) == 'R') {
					if(checkR) {
						checkR = false;
					}else {
						checkR = true;
					}
					
				}else {
					if(aList.isEmpty()) {
						sb.append("error\n");
						cc++;
						break;
					}
					if(checkR) {
						aList.remove(aList.size()-1);
					}else {
						aList.remove(0);
					}
				}
			}
			if(!aList.isEmpty()) {
				
				sb.append("[");
				if(checkR) {
					for(int i = aList.size()-1 ; i >= 0; i--) {
						sb.append(aList.get(i));
						if(i != 0) {
							sb.append(",");
						}
					}
				}else {
					for(int i = 0 ; i < aList.size(); i++) {
						sb.append(aList.get(i));
						if(i != aList.size()-1) {
							sb.append(",");
						}
					}
				}
				sb.append("]\n");
			}else {
				if(cc == 0) sb.append("[]\n");
			}
		}
		System.out.println(sb.toString());
		
	}
}
