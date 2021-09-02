import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main{
     //규칙만 잘 걸어주면 되는 문제, 하지만 다른 사람들의 god풀이를 봐버렸다.. (< > 태그 while문 , 일반 단어 뒤집어 출력 메서드 제작 while문)
    // br, bw ,sb로 시간 단축
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      String s = br.readLine();
      List<String> aList = new ArrayList<String>();
      String word = "";
      boolean check = false;
      for(int i = 0 ; i < s.length(); i++) {

    	  if(s.charAt(i) == '>') {
    		  word += '>';
    		  aList.add(word);
    		  check = false;
    		  word = "";
    		  continue;
    	  }else if(s.charAt(i) == '<') {
    		  aList.add(word);
    		  word = "<";
    		  check= true;
    		  continue;
    	  }
    	  else if(s.charAt(i) == 32 && !check) {
    		  aList.add(word);
    		  word = "";
    		  continue;
    	  }else if(i == s.length()-1) {
    		  word += s.charAt(i);
    		  aList.add(word);
    		  continue;
    	  }
    	  word += s.charAt(i);
      }
      
      for(int i = 0 ; i < aList.size() ;i++) {
    	  String w = "";
    	  for(int j = aList.get(i).length()-1 ; j >= 0; j--) {
    		  if(aList.get(i).charAt(j)=='>') {
    			  sb.append(aList.get(i));
    			  break;
    		  }
    		  w += aList.get(i).charAt(j);
    		  if(j == 0) {
    			  if(i < aList.size()-1 && aList.get(i+1).charAt(0) == '<') {
    				  sb.append(w);
    				  
    			  }else {
    				  w += " ";
        			  sb.append(w);
    			  }
    			  
    		  }
    	  }
    	  
      }
      bw.write(sb.toString());
      bw.flush();
      br.close();
      bw.close();
      
      
    }
}
