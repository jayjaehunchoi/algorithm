import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info>{
	int time;
	int lim;
	
	public Info(int time, int lim) {
		this.time = time;
		this.lim = lim;
	}

	@Override
	public int compareTo(Info o) {
		return this.lim - o.lim;
	}
	
	
}

class Main {
    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         StringTokenizer st;
         
         Info[] infos = new Info[n];
         for(int i = 0 ; i < n ; i++) {
        	 st = new StringTokenizer(br.readLine(), " ");
        	 int time = Integer.parseInt(st.nextToken());
        	 int lim = Integer.parseInt(st.nextToken());
        	 
        	 infos[i] = new Info(time,lim);
         }
         
         Arrays.sort(infos);
         
         
         int ans = 0;
         int min = 987654321;
         
         for(int i = 0 ; i < n ; i++) {
        	 ans += infos[i].time;
        	 min = Math.min(infos[i].lim - ans, min);
        	 if(min < 0) {
        		 System.out.println(-1);
        		 return;
        	 }
         }
         System.out.println(min);
         
    }
  
}
