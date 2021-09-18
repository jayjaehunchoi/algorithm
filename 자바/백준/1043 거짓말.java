import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[][] parties; // 파티 그래프
	static boolean[] party; //파티 멤버 현황
  
  // 진실관계 파악
	public static void find(int x) {
		party[x] = true;
		for(int i = 1 ; i < parties[x].length; i++) {
			if(parties[x][i] != 0 && !party[i]) {
				find(i);
			}
		}
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 멤버수
		int m = Integer.parseInt(st.nextToken()); //파티수
		
		st = new StringTokenizer(br.readLine(), " ");
		List<Integer> trueList = new ArrayList<>(); //진실을 아는 자
		int trueMan = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < trueMan; i++) {
			trueList.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer>[] aList = new ArrayList[m]; //파티 별 멤버
		
		for(int i = 0 ; i < m ; i++) {
			aList[i] = new ArrayList<Integer>();
		}
	
		party = new boolean[n+1];
		parties = new int[n+1][n+1];
		
		for(int i = 0 ; i <  m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int mems = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			aList[i].add(val);
			for(int k = 0 ; k < mems-1; k++) {
				int y = Integer.parseInt(st.nextToken());
				parties[val][y] = 1;
				parties[y][val] = 1;
				aList[i].add(y);
				
			}
		}

		for(int i = 0 ; i < trueList.size() ; i++) {
			find(trueList.get(i));
		}
		int ans = m;
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < aList[i].size() ; j++) {
				if(party[aList[i].get(j)]) {
					ans--;
					break;
				}
			}
		
		}
		System.out.println(ans);

    }
}
