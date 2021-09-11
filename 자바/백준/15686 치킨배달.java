import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
class Chicken{
	
	int x;
	int y;
	
	public Chicken(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
}
class Main{
	static int[][] maps;
	static boolean[] check;
	static List<Chicken> store;
	static Chicken[] left;
	static int min = Integer.MAX_VALUE;
	static int[] dp;
	static int cnt;
  
  // 남길 치킨집 고르기
	public static void comb(int idx, int count , int target) {
		if(count == target) {
			int dist = 0;
			dp = new int[cnt];
			Arrays.fill(dp, Integer.MAX_VALUE);
			for(int i = 0 ; i < left.length; i++) {
				calDist(left[i]);	
			}
			for(int i : dp) {
				dist += i;
			}
			min = Math.min(dist,min);
			return;
		}
		
		for(int i = idx ; i < store.size() ; i++) {
			if(!check[i]) {
				left[count] = store.get(i);
				check[i] = true;
				comb(i, count+1, target);
				check[i] = false;
						
			}
		}
	}
	
  // 남길 치킨집들 중 최소 도시치킨거리 찾기
	public static void calDist(Chicken c) {
		int x = c.x;
		int y = c.y;
		int dis = 0;
		int ord = 0;
		for(int i = 0 ; i < maps.length; i++) {
			for(int j = 0 ; j < maps[0].length; j++) {
				if(maps[i][j] == 1) {
					dp[ord] = Math.min(dp[ord],(Math.abs(x-i)+ Math.abs(y-j)));
					ord++;
				}
			}
		}
	}
	

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine(), " ");
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	
    	maps = new int[n][n];
    	store = new ArrayList<Chicken>();
    	cnt = 0; 
    	for(int i = 0 ; i < n ; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j = 0 ; j < n ; j++) {
    			maps[i][j] = Integer.parseInt(st.nextToken());
    			if(maps[i][j] == 2) {
    				store.add(new Chicken(i,j));
    			}else if(maps[i][j] ==1) {
    				cnt++;
    			}
    		}
    	}
    	check = new boolean[store.size()];
    	left = new Chicken[m];
    	
    	comb(0, 0, m);
    	System.out.println(min);
    	
    }

}
