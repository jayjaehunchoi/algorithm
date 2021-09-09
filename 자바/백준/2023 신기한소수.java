
import java.util.Scanner;

class Main{
	static StringBuilder sb = new StringBuilder();
	static int n;
	
  // 하나씩 추가하면서 소수인지 아닌지 확인하고 append
	public static void dfs(String s , int cnt) {
		
		if(cnt == n) {
			sb.append(s +"\n");
			return;
		}
		
		for(int i = 0 ; i <= 9; i++ ) {
			if(checkSosu(s+i)) {
				dfs(s+i, cnt+1);
			}
		}
		
	}
	
  // 소수 확인
	public static boolean checkSosu(String s) {
		
		if(Integer.parseInt(s) == 0 || Integer.parseInt(s) == 1 )return false;
		for(int i = 2; i*i <= Integer.parseInt(s); i++) {
			if(Integer.parseInt(s) % i == 0) {
				return false;
			}
			
		}
		return true;
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	dfs("", 0);
    	System.out.println(sb.toString());

    }
 
}
