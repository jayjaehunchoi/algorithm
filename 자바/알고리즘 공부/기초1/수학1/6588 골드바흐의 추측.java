
import java.util.*;
class Main{
	static boolean[] check;
	
	static int[] nums; 
	 
	public static void findMax(int target) {
		int start = 0;
		int end = target;
		while(true) {
			if(!check[start] && !check[end] &&start + end == target) {
				nums[0] = start;
				nums[1] = end;
				return;
			}
			start++;
			end--;
		}
	}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       
      
       check = new boolean[1000001];

	   check[0] = true;
	   check[1] = true;
	   
       for(int j = 2; j*j <= 1000000; j++) {
		   for(int k = j*j ; k <= 1000000 ; k += j) {
			  
			   check[k] = true;
		   }
	   }
       for(int i = 0 ; i <= 1000000; i++) {
    	   if(!check[i] && i%2 == 0) {
    		   check[i] = true;
    	   }
       }
       
       while(true) {
    	   int n = sc.nextInt();
    	   if(n == 0) {
    		   return;
    	   }
    	   nums = new int[2];
    	   
    	   findMax(n);
    	   System.out.println(n +" = " + nums[0] + " + " + nums[1] );
       }
       
        		
        
    }
}
