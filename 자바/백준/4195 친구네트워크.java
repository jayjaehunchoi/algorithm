import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main{
	static int[] parent;
	static int[] level;
	
  // union find
  //find - 부모 노드 탐색
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
  // 부모노드(친구네트워크에 속한다는 뜻)를 찾아서 값 더해주기.
  // 각 parent에 맞는 인덱스에 값이 더해지고 있었음.
	public static int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			level[x] += level[y];
			parent[y] = x;
			
			level[y] = 1;
		}
		return level[x];
	}
	
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       
       int t = Integer.parseInt(br.readLine());
       
       
       for(int i = 0 ; i < t; i++) {
    	   StringBuilder sb = new StringBuilder();
    	   
    	   int f = Integer.parseInt(br.readLine());
    	   
    	   Map<String, Integer> maps = new HashMap<>();
    	   level = new int[f*2];
    	   parent = new int[f*2];
    	   
    	   for(int k = 0 ; k < f*2; k++ ) {
    		   parent[k] = k;
    		   level[k] = 1;
    	   }
    	   int idx = 0;
    	   for(int j = 0 ; j < f; j++) {
    		  String[] input = br.readLine().split(" ");
    		  String fir = input[0];
    		  String sec = input[1];

    		  if(!maps.containsKey(fir)) {
    			  maps.put(fir, idx++);
    		  }
    		  if(!maps.containsKey(sec)) {
    			  maps.put(sec, idx++);
    		  }
    		  if(j == f-1) {
    			  sb.append(union(maps.get(fir), maps.get(sec)));
    		  }else {
    			  sb.append(union(maps.get(fir), maps.get(sec))+ "\n");
    		  }
    		  
 
    	   }
    	  
    	   System.out.println(sb.toString());
    	   
       }
       
    }
}
