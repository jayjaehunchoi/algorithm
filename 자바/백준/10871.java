import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjun {
	 


	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			int comparison = Integer.parseInt(st.nextToken()); // 넥스트 토큰을 변수로 안 잡아주면 다음 nexttoken할때 그 다음으로  넘어가버림 ;;
			if(comparison < X) {
				System.out.print(comparison+" ");
			}
    }
	}
}
