import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) throws IOException {
    
    // 시간초과 및 메모리 초과방지를 위해 bufferedreader와 writer 사용 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
    // Map에 값을 저장하여 동일한 값이 있을때마다 값을 ++해줄거임
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		StringTokenizer st;
			
		int n = Integer.parseInt(br.readLine());
		int [] nList = new int [n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			nList[i] = Integer.parseInt(st.nextToken());	
		}
		
		int m = Integer.parseInt(br.readLine());
		int [] mList = new int [m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < m; i++) {
			mList[i] = Integer.parseInt(st.nextToken());
		}
		
    // 기준이 되는 카드를 map에 넣는다.
		for(int i = 0 ; i < m ; i++) {
			map.put(mList[i], 0);
		}
		
    // 현재 갖고있는 카드가 기준 카드에 있을때, value를 +해주도록 코드를 작성한다.
		for(int i = 0 ; i < n ; i++) {
			if(map.containsKey(nList[i])) {
				map.replace(nList[i], map.get(nList[i])+1);
			}
		}
		
    // 해당 값을 순서대로 공백 넣고 출력 
		for(int i = 0 ; i < m ; i++) {
			bw.append (map.get(mList[i])+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	 }
	}


