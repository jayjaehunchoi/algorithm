
import java.util.*;
class Main{
	
  // 이게 진정 실버 1인것인가.. 1시간30분..
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int x = sc.nextInt();
       int y = sc.nextInt();
       
       int answer = 0;
       for(int i = n; i >= 1 ; i--) {
    	   
    	   if( x>=0 && x <= Math.pow(2, i-1)-1) {
    		  
    		   if(y >= 0 && y <= Math.pow(2, i-1)-1) { // 1사분면
    			   answer += 0;

    		   }else { // 2사분면
    			   answer += Math.pow(4, i-1)*1;
    			   y -= Math.pow(2, i-1);
 
    		   }
    	   }else if( Math.pow(2,i-1) <= x) {
    		   if(y >= 0 && y <= Math.pow(2, i-1)-1) { //3사분면
    			   answer += Math.pow(4, i-1)*2;
    			   x -= Math.pow(2, i-1);
    			   
    			   
    		   }else { //4사분면
    			   answer += Math.pow(4, i-1)*3;
    			   x -= Math.pow(2, i-1);
    			   y -= Math.pow(2, i-1);
    		   }
    	   }
    	   
    	   
       }
       System.out.println(answer);
      
        
    }
}
