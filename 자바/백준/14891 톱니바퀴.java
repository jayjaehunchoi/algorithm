import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 순수 구현문제
// 일반적인 상식상 톱니바퀴가 아닌 , 문제에서 주는 조건을 잘 읽자

class Main {
	static List<Integer>[] aList = new ArrayList[4]; 
	static int[] dirCheck = new int[4];
	public static void circul(int topni, int dir) {
		Arrays.fill(dirCheck, -10);
		
		int firTop = topni-1;
		dirCheck[firTop] = dir;
		
		while(firTop+1 <= 3) {
			if(aList[firTop].get(2) != aList[firTop+1].get(6)) {
				if(dirCheck[firTop] == -1) {
					dirCheck[firTop+1] = 1;
				}else {
					dirCheck[firTop+1] = -1;
				}
				firTop++;
			}else {
				break;
			}
		}
		
		firTop = topni-1;
		while(firTop-1 >= 0) {
			if(aList[firTop].get(6) != aList[firTop-1].get(2)) {
				if(dirCheck[firTop] == -1) {
					dirCheck[firTop-1] = 1;
				}else {
					dirCheck[firTop-1] = -1;
				}
				firTop--;
			}else {
				break;
			}
		}
		
		for(int i = 0 ; i < 4; i++) {
//			System.out.println(dirCheck[i]);
			if(dirCheck[i] == 1) {
				goCircul(i, dirCheck[i]);
				
			}else if(dirCheck[i] == -1 ) {
				goCircul(i, dirCheck[i]);
			}
		}
		
		
	}
	
	public static void goCircul(int firTop, int dir) {
		
		if(dir == -1) {
			aList[firTop].add(aList[firTop].remove(0));
	
		}else {
			aList[firTop].add(0,aList[firTop].remove(aList[firTop].size()-1));
		}
		
	}
	
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 0 ; i < aList.length; i++) {
			aList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < 4; i++) {
			String n = br.readLine();
			for(int j = 0 ; j < 8; j++) {
				aList[i].add(Integer.parseInt(n.substring(j,j+1)));
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0 ; i < k ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int topni = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			circul(topni, dir);
		}
		
		int ans = 0;
		for(int i = 0 ; i < 4; i++) {
			if(aList[i].get(0)== 1) {
				if(i == 0) ans+=1;
				else if(i == 1) ans+=2;
				else if(i == 2) ans+=4;
				else ans += 8;
			}
		}
//		
//		for(int i = 0 ; i < 4 ; i++) {
//			System.out.println(aList[i]);
//		}
		System.out.println(ans);
		
		
	}
}
