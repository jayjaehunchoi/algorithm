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
      ArrayList<Integer> aList = new ArrayList<>();
      int n = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      for(int i = 0 ; i < n ; i++) {
    	  String[] s = br.readLine().split(" ");
    	  String oper = s[0];
    	  
    	  switch(oper) {
    	  case "push" :
    		  aList.add(Integer.parseInt(s[1]));
    		  break;
    		  
    	  case "pop" :
    		  if(!aList.isEmpty()) {
    			  sb.append(aList.remove(0)+"\n");
    		  }else {
    			  sb.append(-1 + "\n");
    		  }
    		  break;
    	  case "size" :
    		  sb.append(aList.size()+ "\n");
    		  break;
    	  case "empty":
    		  if(!aList.isEmpty()) {
    			  sb.append(0 +"\n");
    		  }else {
    			  sb.append(1 + "\n");
    		  }
    		  break;
    		  
    	  case "front":
    		  if(!aList.isEmpty()) {
    			  sb.append(aList.get(0)+"\n");
    		  }else {
    			  sb.append(-1 + "\n");
    		  }
    		  break;
    	  case "back" :
    		  if(!aList.isEmpty()) {
    			  sb.append(aList.get(aList.size()-1)+"\n");
    		  }else {
    			  sb.append(-1 + "\n");
    		  }
    		  break;
    	  }
    	  
      }
      bw.write(sb.toString());
      bw.flush();
      br.close();
      bw.close();
      
      
    }
}
