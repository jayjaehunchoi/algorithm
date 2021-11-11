import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] cities;
	static boolean[] check;
	static int n;
	static int min = Integer.MAX_VALUE;
	static int first;
	public static void dfs(int x, int cost) {

    // 모두 방문하고 첫 출발지점으로 되돌아 갈 수 있다면 가능한 길
		if(visitAll()) {
			if(cities[x][first] != 0) {
				min = Math.min(cost+cities[x][first],min);
				return;
			}
		}
		for(int i = 0; i < n; i++) {
			if(!check[i] && cities[x][i] != 0) {
				check[i] = true;
				dfs(i,cost+cities[x][i]);
				check[i] = false;
			}
		}
	}
	
	public static boolean visitAll() {
		for(int i = 0 ; i < check.length; i++) {
			if(!check[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		cities = new int[n][n];

		for(int i = 0 ; i < n ; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 for(int j = 0 ; j < n ; j++) {
				 cities[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		
    // 브루트 
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(cities[i][j] != 0) {
					check = new boolean[n];
					check[i] = true;
					check[j] = true;
					first = i;
					dfs(j, cities[i][j]);
				}
			}
		}
		System.out.println(min);
		
	}
} 
