import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         
         int n = Integer.parseInt(st.nextToken());
         int l = Integer.parseInt(st.nextToken());
         
         int[] arr= new int[n];
         st = new StringTokenizer(br.readLine(), " ");
         for(int i = 0 ; i < arr.length ;i++) {
        	 arr[i] = Integer.parseInt(st.nextToken());
         }
         Arrays.sort(arr);
         boolean check = false;
         double num = 0;
         int cnt = 0;
         for(int i = 0 ; i < n; i++) {
        	 if(!check) {
        		 check = true;
        		 num = (arr[i] - 0.5)+l;
        		 cnt++;
        	 }else {
        		 if(arr[i]+0.5 > num) {
	    			 cnt++;
	    			 num = (arr[i] - 0.5)+l;
        		 }
        	 }
         }
         System.out.println(cnt);
    }
  
}
