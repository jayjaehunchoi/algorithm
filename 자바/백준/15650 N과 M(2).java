import java.util.Scanner;

class Main{
	static int[] ans;
	static int[] nums;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void comb(int idx, int count ,int m) {
		if(count == m) {
			for(int i = 0; i < ans.length; i++) {
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx ; i < nums.length; i++) {
			if(!check[i]) {
				ans[count] = nums[i];
				check[i] = true;
				comb(i,count+1 , m);
				check[i] = false;
			}
		}
	}


    public static void main(String[] args){
    
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	
    	ans = new int[m];
    	nums = new int[n];
    	check = new boolean[n];
    	
    	for(int i = 1 ; i <= n; i++ ) {
    		nums[i-1] = i;
    	}
    	
    	comb(0, 0, m);
    	System.out.println(sb.toString());
    	
    }

}
