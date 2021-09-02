import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main{
	
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String s = br.readLine();
      
      LinkedList<Character> aList = new LinkedList<Character>();
      
      for(int i = 0 ; i < s.length(); i++) {
    	  aList.add(s.charAt(i));
      }
      ListIterator<Character> ir = aList.listIterator(aList.size());

      int m = Integer.parseInt(br.readLine());
      for(int i = 0 ; i < m ; i++) {
    	  String cur = br.readLine();
    	  char editor = cur.charAt(0);
    	  switch(editor) {
    	  
    	  case 'L':
    		  if(ir.hasPrevious()) {
    			  ir.previous();
    		  }
    		  break;
    	  
    	  case 'D':
    		  if(ir.hasNext()) {
    			 ir.next();
    		  }
    		  break;
    	  
    	  case 'B':
    		  if(ir.hasPrevious()) {
    			  ir.previous();
    			  ir.remove();
    		  }
    		  break;
    	  case 'P' :
    		  ir.add(cur.charAt(2));
    		  break;
    	  }
    	 
      }
      for(char w : aList) {
		  bw.write(w);
	  }
      bw.flush();
      br.close();
      bw.close();
    }
}
