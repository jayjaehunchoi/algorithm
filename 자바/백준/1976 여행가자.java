import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	static int[][] cities;
	static boolean[] check;
	static boolean yes;
	public static void find(int start, int end) {
		
		if(start == end) {
			yes = true;
			return;
		}
		
		check[start] = true;
		
		for(int i = 0 ; i < cities.length ; i++) {
			if(cities[start][i] == 1 && !check[i]) {
				find(i, end);
			}
		}
		
	}

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	
    	cities = new int[n][n];
    	
    	int[] ways = new int[m];
    	
    	StringTokenizer st;
    	
    	for(int i = 0 ; i < n ; i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		for(int j = 0 ; j < n ; j++) {
    			cities[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine()," ");
    	for(int i = 0 ; i < m ; i++) {
    		ways[i] = Integer.parseInt(st.nextToken())-1;
    	}

    	for(int i = 0 ; i < m-1; i++) {
    		
    		check= new boolean[n];
    		find(ways[i], ways[i+1]);
    		if(!yes) {
    			System.out.println("NO");
    			return;
    		}
    		yes = false;
    	}
    	System.out.println("YES");
    }
}

/*
5
5
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
5 3 2 3 4
*/
