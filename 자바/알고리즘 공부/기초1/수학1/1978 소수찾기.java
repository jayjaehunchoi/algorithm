
import java.util.*;
class Main{
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
       int n= sc.nextInt();
       int cnt = 0;
       boolean[] check = new boolean[1001];

	   check[0] = true;
	   check[1] = true;
	   
       for(int j = 2; j*j <= 1000; j++) {
		   for(int k = j*j ; k <= 1000 ; k += j) {
			  
			   check[k] = true;
		   }
	   }
       
       for(int i = 0 ; i < n ; i++) {
    	   int num = sc.nextInt();
    	   
    	   if(num == 0 || num == 1) {
    		   continue;
    	   }
    	   
    	   if(!check[num]) {
    		   cnt++;
    		   
    	   }
    	   
       }
       System.out.println(cnt);
        		
        
    }
}
