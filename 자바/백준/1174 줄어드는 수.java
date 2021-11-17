import java.util.*;
import java.io.*;

public class Main{

     public static void main(String []args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int n = Integer.parseInt(br.readLine());
       int[] num = {9,8,7,6,5,4,3,2,1,0};
       
       List<Long> aList = new ArrayList<Long>();
       
       for(int i = 1 ; i < (1<<10); i++) {
    	   long sum = 0;
    	   for(int j = 0 ; j < 10 ; j++) {
    		   if((i & (1<<j))>0) {
    			   sum = sum * 10 + num[j];
    		   }
    	   }
    	   aList.add(sum);
       }
       Collections.sort(aList);
       if(n > aList.size()) {
    	   System.out.println(-1);
    	   return;
       }
       System.out.println(aList.get(n-1));
     }
}
