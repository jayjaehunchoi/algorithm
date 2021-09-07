import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class Main{


    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String name= sc.next();
    	StringBuilder sb = new StringBuilder();
    	StringBuilder sb2 = new StringBuilder();
    	
    	
    	Map<Character, Integer> maps = new TreeMap<Character, Integer>();
    	
    	for(int i = 0 ; i < name.length() ; i++) {
    		maps.put(name.charAt(i), maps.getOrDefault(name.charAt(i), 0)+1);
    	}
    	int count = 0;
    	String mid = "";
    	for(Entry<Character, Integer> e : maps.entrySet()) {

    		if(e.getValue() % 2 != 0) {
    			count++;
    			if(count >= 2) {
    				System.out.println("I'm Sorry Hansoo");
        			return;
    			}
    			
    		}
    		
    		
    		for(int i = 0 ; i < e.getValue()/2; i++) {
    			sb.append(e.getKey());
    		}
    		if(e.getValue()%2 == 1) {
    			
    			for(int i = 0 ; i < e.getValue(); i++) {
    				mid += e.getKey()+"";
    			}
    		}
    	}
    	
    	
    	sb2.append(sb);
    	if(!mid.equals("")) {
    		sb.append(mid.charAt(0));
    	}
    	
    	sb.append(sb2.reverse().toString());
    	System.out.println(sb.toString());
    	
    }
}

