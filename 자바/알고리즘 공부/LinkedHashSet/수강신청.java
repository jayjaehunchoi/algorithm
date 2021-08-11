import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
		
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine()," ");
		
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
    // linkedHashSet은 순서 보장에 중복 안된다
		Set<String> set = new LinkedHashSet<>();
		
    // 빠르게 풀다가 여기에 포함하지 않을때로 조건 걸어서 ;;;
    // 계속 틀렸다;; 
		for(int i = 0 ; i < l ; i++) {
			String a = br.readLine();
			if(set.contains(a)) {
				set.remove(a);
				set.add(a);
			}
			else {
				set.add(a);
			}
		}
  
    //메모리때문에 br,bw사용
		Iterator<String> ir = set.iterator();
		
		while(ir.hasNext()){

			bw.write(ir.next());
			bw.newLine();
			if(--k < 1) {
				break;
			}
		}
		bw.close();
		br.close();
		
	}
}
