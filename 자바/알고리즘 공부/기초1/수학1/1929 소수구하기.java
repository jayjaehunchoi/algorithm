
import java.util.*;
class Main{
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
       int n= sc.nextInt();
       int m = sc.nextInt();
       int cnt = 0;
       boolean[] check = new boolean[10000001];

	   check[0] = true;
	   check[1] = true;
	   
       for(int j = 2; j*j <= 1000000; j++) {
		   for(int k = j*j ; k <= 1000000 ; k += j) {
			  
			   check[k] = true;
		   }
	   }
       
       for(int i = n ; i <= m ; i++) {
    	   
    	   
    	   if(i == 0 || i == 1) {
    		   continue;
    	   }
    	   
    	   if(!check[i]) {
    		   System.out.println(i);
    		   
    	   }
    	   
       }
       
        		
        
    }
}
