import java.util.Scanner;

class Main{
	
	static int n;
	static int[] chess;
	static int count;
	public static void nQueen(int col) {
		
		if(col == n) {
			count++;
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {
			chess[col] = i;
			if(check(col)) {
				nQueen(col+1);
			}
			
		}
	}
	
	public static boolean check(int col) {
		
		
		for(int i = 0 ; i < col; i++) {
			if(chess[col] == chess[i]) {
				return false;
			}
			
			else if(Math.abs(col-i) == Math.abs(chess[col]-chess[i])) {
				return false;
			}
		}
		return true;
	}
	
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	n = sc.nextInt();
    	chess = new int[n];
    	
    	nQueen(0);
    	
    	System.out.println(count);
    }
    	
    	
    
}
