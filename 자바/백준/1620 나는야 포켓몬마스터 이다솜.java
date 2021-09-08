
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String,String> maps = new HashMap<>();
        Map<String,String> maps2 = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String s = sc.next();
        	maps.put(s, String.valueOf(i));
        	maps2.put(String.valueOf(i), s);
        }
        
        for(int i = 0 ; i < m ; i++ ) {
        	String ans = sc.next();
        	if(maps.containsKey(ans)) {
        		System.out.println(maps.get(ans));

        	}else {
        		System.out.println(maps2.get(ans));
        		
        	}
        }
    }
}
