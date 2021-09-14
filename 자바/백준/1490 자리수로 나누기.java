import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 사람들이 안푸는 문제에는 이유가 있다.
// 간단한데 처음에 잘못접근하는 바람에 수정방식으로 가다가 오래걸림 ,, 맞긴맞음 

class Main {
	
	public static int gcd(int x, int y) {
		
		return y == 0? x:gcd(y,x%y);
	}
	
	public static long choidae(long n) {
		String s = String.valueOf(n);
		int choi = 1;
		if(s.length()<2) {
			choi = Integer.valueOf(s.substring(0,1));
			return choi;
		}
		
		if(Integer.valueOf(s.substring(0,1)) * Integer.valueOf(s.substring(1,2)) != 0) {
			choi = Integer.valueOf(s.substring(0,1)) * Integer.valueOf(s.substring(1,2)) / gcd(Integer.valueOf(s.substring(0,1)), Integer.valueOf(s.substring(1,2)) );
		}else {
			if(Integer.valueOf(s.substring(0,1)) == 0) {
				choi = Integer.valueOf(s.substring(1,2));
			}else if(Integer.valueOf(s.substring(1,2)) == 0) {
				choi = Integer.valueOf(s.substring(0,1));
			}
		}
		for(int i = 2 ; i < s.length(); i++) {
			if(Integer.valueOf(s.substring(i,i+1)) != 0 && Integer.valueOf(s.substring(i-1,i)) - Integer.valueOf(s.substring(i,i+1)) != 0) {
				
				int choiso = gcd(choi, Integer.valueOf(s.substring(i,i+1)));
				choi *= (Integer.valueOf(s.substring(i,i+1)));
				choi /= choiso;
			}
		}
		
		return choi;
	}
	
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());
		long div = choidae(n);
		int j = 0;
		while(true) {
			int ten = (int)Math.pow(10, j);
			long val = n*ten;
			
			for(long i = val ; i < ten + val ; i++) {
				if(i%div == 0) {
					System.out.println(i);
					return;
				}
			}
				
			j++;
			
		}	
	}
}

