
import java.util.Scanner;

class Main{
	
  // 가장 최소값이 나오려면  먼저 다 더하고, 그다음 다 빼주면 됨.
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);

    	int sum = Integer.MAX_VALUE;
    	String[] subs = sc.nextLine().split("-");
    	
    	for(int i = 0 ; i < subs.length; i++) {
    		int tmp = 0;
    		
    		String[] add = subs[i].split("\\+");
    		
    		for(int j = 0 ;j < add.length; j++) {
    			tmp += Integer.parseInt(add[j]);
    		}
    		
    		if(sum == Integer.MAX_VALUE) {
    			sum = tmp;
    		}else {
    			sum -= tmp;
    		}
    	}
    	
    	System.out.println(sum);
    	
    	
    }
}
