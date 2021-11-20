import java.util.*;
import java.io.*;

public class Main{

     public static void main(String []args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       List<Integer> aList = new ArrayList<Integer>();
       for(int i = 0 ; i < n ; i++) {
    	   int str = Integer.parseInt(st.nextToken());
    	   aList.add(str); 
       }
       
       Collections.sort(aList);
       
       int answer = 0;

       for(int i = 0 ; i < aList.size() ; i++) {
    		  int tmpRes = aList.get(i);
    		  int start = 0;
     		  int end = aList.size()-1;
    		  while(start < end) {
    			  int strVal = aList.get(start);
    			  int endVal = aList.get(end);
    			  
    			  int tmpSum = strVal + endVal;
    			  
    			  if(tmpSum < tmpRes) {
    				  start++;
    			  }else if(tmpSum > tmpRes)  {
    				  end--;
    			  }
            // 두 수의 합으로 목표치와 같게 나오더라도, 현재값이 포함된건지 아닌지 체크
            // start가 현재 수라면 start++ , end가 현재 수라면 end--
            else {
    				  if(start != i && end != i) {
        				  answer++;
        				  break;
    				  }
    				  if(start == i) {
    					  start++;
    				  }else {
        				  end--;
    				  }
    			  }
    		  }
       }
       System.out.println(answer);
  
     }
}
