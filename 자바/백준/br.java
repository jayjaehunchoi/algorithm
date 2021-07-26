import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjun {
	 


	public static void main(String[] args) throws IOException{ // readline에서 오류가 날 수 있는 상황을 제외 시키기 위해 사용한다고 함...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼에 저장하면서 읽는 것, 스캐너보다 훨씬 빠름.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); // bufferedreader는 문자열 형태로 읽어내기 때문에 정수형으로 변환해준다. 
		
		StringTokenizer st; // 하나의 토큰으로 정렬해놓는 용도라고 생각하면됨.
		
		for(int i = 0 ; i < T; i++) {			
			st = new StringTokenizer(br.readLine()," "); // 입력하는 값을 띄어쓰기로 구분
			bw.write((Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+"\n"); 
      // bw.flush를 통해 한번에 읽어오기 위해, bw.write로 저장해놓기. 그런데 행바꿈을 안하면 오류가 난다.. 왜일까?
		}
		br.close();
		bw.flush();
		bw.close();
		
	}

}
