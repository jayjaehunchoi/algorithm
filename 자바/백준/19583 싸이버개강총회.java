import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static int parseToMin(String time) {
		String[] str = time.split(":");
		int h = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		return h*60 + m;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = parseToMin(st.nextToken());
		int e = parseToMin(st.nextToken());
		int q = parseToMin(st.nextToken());
		Map<String, Integer> members = new HashMap<String, Integer>();
		String input = null;
		int cnt = 0;
		while((input = br.readLine()) != null) {
			String[] str = input.split(" ");
			int time = parseToMin(str[0]);
			String id = str[1];
			
			if(time <= s && members.getOrDefault(id, 0) == 0) {
				members.put(id,1);
			}else if(time >= e && time <= q && members.getOrDefault(id, 0) == 1) {
				members.put(id,2);
				cnt++;
			}else if(time > q){
				break;
			}
		}
		System.out.println(cnt);
		
	}
} 
