import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Main{
	
  
    public static void main(String[] args) throws IOException{
    	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           int n = Integer.parseInt(br.readLine());
           
           Map<Character, Integer> maps = new TreeMap<Character, Integer>();
           String[] words = new String[n];
           List<Character> aList = new ArrayList<Character>();
           
           for(int i = 0 ; i < n ; i++) {
        	   words[i] = br.readLine();
        	   int length = words[i].length()-1;
        	   for(int j = 0 ; j <= words[i].length()-1; j++) {
        		   if(!aList.contains(words[i].charAt(j))) {
        			   aList.add(words[i].charAt(j));
        		   }

        		   maps.put(words[i].charAt(j), (int) (maps.getOrDefault(words[i].charAt(j),0) + Math.pow(10,length--)));
        	   }
           }
           
           int[] values = new int[aList.size()];
           int val = 9;
           for(int i = 0 ; i < maps.size(); i++) {
        	   int max = 0;
        	   char c = 'a';
        	   for(Entry<Character,Integer> e : maps.entrySet()) {
            	   max = Math.max(e.getValue(), max);
            	   if(max == e.getValue()) {
            		   c = e.getKey();
            	   }
               }
        	   maps.replace(c,0);
        	   values[aList.indexOf(c)] = val--;
        	   
           }
           int ans = 0 ;
           
           for(int i = 0 ; i < words.length; i++) {
        	   String s = "";
        	   for(int j = 0 ; j < words[i].length(); j++) {
        		   s+= values[aList.indexOf(words[i].charAt(j))];
        	   }
        	   ans += Integer.parseInt(s);
           }
           
           System.out.println(ans);
           
           
    }
}
