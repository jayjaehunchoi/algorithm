import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static boolean[] primeNum = new boolean[4000001];
  
  // 소수 구해서 list에 넣기, 에라토스테네의 체
	public static List<Integer> findPrimeNum() {
		
		List<Integer> aList = new ArrayList<Integer>();
		primeNum[0] = true;
		primeNum[1] = true;
		
		for(int i = 2; i*i < primeNum.length; i++ ) {
			for(int j = i*i ; j < primeNum.length ; j = j+i) {
				primeNum[j] = true;
			}
		}
		
		for(int i= 0 ; i < primeNum.length; i++) {
			if(!primeNum[i]) {
				aList.add(i);
			}
		}
		return aList;
	}
	
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());
		List<Integer> aList = findPrimeNum();
		int res = 0;
		int start = 0;
		int end = 0;
      
     // 투포인터 구현
		while(end < aList.size()) {
			int val = 0;
			if(start == end) {
				val = aList.get(start);
				if(val > n) {
					System.out.println(res);
					return;
				}
			}else {
				
				for(int i = start ; i <= end; i++) {
					val += aList.get(i);
				}
			}	
			if(val < n) {
				end++;
			}else if(val > n) {
				start++;
			}else if(val == n) {
				res++;
				start++;
			}
		}
      // while 조건으로 break 걸릴경우
		System.out.println(res);
		
    }
  
}
