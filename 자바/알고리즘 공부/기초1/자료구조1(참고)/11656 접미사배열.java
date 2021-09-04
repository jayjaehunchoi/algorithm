
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> aList = new ArrayList<String>();
        for(int i = 0 ; i < s.length() ;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j = i ; j< s.length() ; j++) {
        		sb.append(s.charAt(j));
        	}
        	aList.add(sb.toString());
        }
        Collections.sort(aList);
        for(String i : aList) {
        	System.out.println(i);
        }
        
        
    }
}
