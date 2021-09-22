import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 시간제한이 빡세게 걸려있었으면 무조건 틀렸을거다..
class Main {
    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
    	 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	 int l = Integer.parseInt(st.nextToken());
    	 int r = Integer.parseInt(st.nextToken());
    	 
    	 String rStr = String.valueOf(r);
    	 String lStr = String.format("%0"+rStr.length()+"d", l);
    	 
    	 String ans = "";
    	 for(int i = 0 ; i < rStr.length(); i++) {
    		 if(rStr.charAt(i) == '8' && lStr.charAt(i) == '8') {
    			 ans+=8;
    		 }else {
    			 break;
    		 }
    	 }
    	 
    	 int power = rStr.length() - ans.length();
    	 int compR = 0;
    	 int compL = 0;
    	 if(ans.equals("")) {
    		 compR = r;
        	 compL = l;
    	 }else {
        	 compR = (r - (int)(Integer.parseInt(ans) * Math.pow(10, power)));
        	 compL = (l - (int)(Integer.parseInt(ans) * Math.pow(10, power))); 
    	 }

    	 
    	 int min = 99999999;
    	 for(int i = compL ; i <= compR; i++) {
    		 String s = String.valueOf(i);
    		 int v = 0;
    		 for(int j = 0 ; j < s.length(); j++) {
    			 if(s.charAt(j) == '8') {
    				 v++;
    			 }
    		 }
    		 min = Math.min(v, min);
    		 if(min == 0) {
    			 System.out.println(ans.length());
    			 return;
    		 }
    	 }
    	 System.out.println(ans.length() + min);
    }
  
}
