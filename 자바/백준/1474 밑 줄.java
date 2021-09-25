import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빠르게 풀이를 생각해서 빨리 풀 수 있었다.
class Main {
    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	 
    	 int n = Integer.parseInt(st.nextToken());
    	 int m = Integer.parseInt(st.nextToken());
    	 String[] arr= new String[n];
    	 
      // 밑줄을 더해야 할 길이를 찾는다
    	 int len = m;
    	 for(int i = 0 ; i < n ; i++) {
    		 String s = br.readLine();
    		 len -= s.length();
    		 arr[i] = s;
    	 }
    	 
      // 기본적으로 밑줄 몇개가 필요한지 찾는다.
    	 int num = 1;
    	 int dist = n-1;
    	 while(true) {
    		 if(num * dist > len) {
    			 num--;
    			 break;
    		 }
    		 num++;
    	 }
      // 기본 밑줄과 기본 밑줄 +1 몇개가 필요한지 찾는다
    	 int numC = dist;
    	 int numCP = 0;
    	 if((num * dist) != len) {
    		 while(true) {
    			 numC--;
    			 numCP++;
    			 int val = (numC*num)+(numCP*(num+1));
    			 if(val == len) {
    				 break;
    			 }
    		 }
    	 }
      //찾아낸 기본밑줄 개수, 기본밑줄 +1 개수로 단어 사이에 밑줄을 추가해준다.
      //조건으로 준 사전 순서에 맞춰 1. 소문자 앞 2. 소문자가 없다면 가장 마지막대문자(기본 밑줄 +1개의 개수만큼)
    	 String s = "";
    	 for(int i = 0 ; i < n ; i++) {
    		 
    		 if(i == 0) {
    			 s += arr[i];
    		 }else {
    			 if(arr[i].charAt(0) >= 97 && arr[i].charAt(0) <= 122 ) {
    				 if(numCP == 0) {
    					 for(int j = 0 ; j < num; j++) {
    						 s+="_";
    					 }
    					 s += arr[i];
    					 
    				 }else {
    					 for(int j = 0 ; j <= num; j++) {
    						 s+="_";
    					 }
    					 numCP--;
    					 s += arr[i];
    				 }
    			 }else {
    				 if(i == n-numCP && numCP != 0) {
    					 for(int j = 0 ; j <= num; j++) {
    						 s+="_";
    					 }
    					 s += arr[i];
    					 numCP--;
    				 }else {
    					 for(int j = 0 ; j < num; j++) {
    						 s+="_";
    					 }
    					 s += arr[i];

    				 }
    			 }
    		 }
    		 
    		 
    	 }
    	 System.out.println(s);
    }
  
}
