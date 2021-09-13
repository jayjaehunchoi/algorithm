import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



class Main {
	static Map<Long, Long> dp = new HashMap<Long, Long>();
	static long n;
	static int p;
	static int q;
	static int size;
  
  //처음 풀이는 n/p , n/q 중 큰값까지 배열을 만들어서
  // 그걸 통해 더한값을 출력해줬다.
  // 하지만 그렇게 되면 n이 최대값 나머지가 최소값일때 
  // 메모리 초과가 발생한다 (ArrayList 로 동적할당 해줘도 67퍼쯤 메모리 초과)
  // 질문을 보니 map을 활용하여 문제를 해결할 수 있다길래 map으로 구현해보았다.
  
	public static long dyna(long num) {
		if(num == 0)return 1;
		if(dp.containsKey(num))return dp.get(num);
		
		long a= (long)Math.floor(num/p);
		long b= (long)Math.floor(num/q);
		
		dp.put(num, dyna(a)+dyna(b));
		return dp.get(num);
		
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Long.parseLong(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		System.out.println(dyna(n));
	}
}
