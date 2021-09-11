import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main{
	static int[] vals;
	static boolean[] check;
  
  // 첨엔 걍 반복문으로 , 부모를 찾았는데 시간초과가 났다
  // 두번째는 배열로 했는데 메모리초과가 났다
  // 메모리초과 해결을 위해 List를 사용했다
	static ArrayList<ArrayList<Integer>> aList;
	
	public static void findPar(int x) {
		
		check[x] = true;
		for(int i = 0 ; i < aList.get(x).size(); i++) {
			if(!check[aList.get(x).get(i)]) {
				vals[aList.get(x).get(i)] = x;
				check[aList.get(x).get(i)] = true;
				findPar(aList.get(x).get(i));
			}
		}
	}


    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st ;
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	vals = new int[n+1];;
    	check = new boolean[n+1];
    	
    	
    	aList = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0 ; i < n+1; i++) {
    		aList.add(new ArrayList<Integer>());
    		
    	}
    	
    	for(int i = 0 ; i < n-1 ; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		
    		int par = Integer.parseInt(st.nextToken());
    		int chi = Integer.parseInt(st.nextToken());
    		
    		aList.get(par).add(chi);
    		aList.get(chi).add(par);
    		
    	}
    	findPar(1);
    	
    	for(int i = 2 ; i <= n; i++ ) {
    		sb.append(vals[i] + "\n");
    	}
    	
    	bw.write(sb.toString());
    	bw.flush();
    	br.close();
    	bw.close();
    	
    	
    }

}
