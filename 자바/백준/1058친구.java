import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	
	static String[][] friends;
	static boolean[][] visited;
	static List<Integer> friend2;
	
	static int[] nums = new int[2];
	static boolean[] check;
	
  // 행을 돌아보며 같은 행에 있는 친구들을 모두 리스트에 담고
  // 리스트로 만들 수 있는 두개의 수를 모두 뽑아, 조건문에 대입한다.
	public static void comb(int idx, int count ,int target) {
		if(count == target) {
			if(friends[nums[0]][nums[1]].equals("N")) {
				friends[nums[0]][nums[1]] = "Y";
				friends[nums[1]][nums[0]] = "Y";
				visited[nums[1]][nums[0]] = true;
				visited[nums[0]][nums[1]] = true;
				
			}
			return;
		}
		
		for(int i = idx ; i < friend2.size(); i++) {
			if(!check[i]) {
				nums[count] = friend2.get(i);
				check[i] = true;
				comb(i, count+1, target);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		friends = new String[n][n];
		visited = new boolean[n][n];
		friend2 = new ArrayList<Integer>();
		
		for(int i = 0 ; i < n ; i++) {
			friends[i] = sc.next().split("");
		}
			
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(friends[i][j].equals("Y") && !visited[i][j]) {
					friend2.add(j);
				}
			}
			if(friend2.size() >= 2) {
				check = new boolean[friend2.size()];
				comb(0, 0, 2);
			}
			friend2.clear();
		}
		
		int max = 0;
		
		for(int i = 0 ; i < n ; i++) {
			int cnt = 0;
			for(int j = 0 ; j < n ; j++) {
				if(friends[i][j].equals("Y")) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}

/*
 * 4
NYYN
YNNN
YNNY
NNYN
*/
	

