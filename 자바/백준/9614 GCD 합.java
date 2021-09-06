

import java.util.Scanner;

class Main{
	static long[] arr;
	static boolean[] check;
	static long[] twoNum = new long[2];
	static long sum;
	
	public static long gcd(long x, long y) {
		
		if(y == 0) {
			return x;
		}
		long tmp = x;
		x = y;
		y = tmp%y;
		
		return gcd(x,y);
	}
	
	public static void comb(int idx, int count, int target) {
		if(count == target) {
			
			sum += gcd(twoNum[0], twoNum[1]);
			return;
		}
		
		for(int i = idx ; i < arr.length; i++) {
			if(!check[i]) {
				twoNum[count] = arr[i];
				check[i] = true;
				comb(i, count+1, target);
				check[i] = false;
			}
		}
	}
	
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	
    	int t= sc.nextInt();
    	
    	for(int i = 0 ; i < t; i++) {
    		
    		int n = sc.nextInt();
    		arr = new long[n];
    		check = new boolean[n];
    		sum = 0;
    		
    		for(int j = 0 ; j < n ; j++) {
    			arr[j] = sc.nextInt();
    		}
    		comb(0, 0, 2);
    		
    		System.out.println(sum);

    	}
    	
    }
}
