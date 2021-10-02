import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;



class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		StringBuilder sb= new StringBuilder();
		//조건에 맞게 반복문 돌려주면 됨.
		sb.append(t);
		while(s.length() < sb.length()) {
			if(t.charAt(t.length()-1) == 'A') {
				sb.setLength(t.length()-1);
			}else {
				sb.setLength(t.length()-1);
				sb.reverse();
			}
			t= sb.toString();
		}
		if(s.equals(sb.toString())) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
     	
    }
  
}
