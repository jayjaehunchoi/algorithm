import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[][] clients = new String[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			
			clients[i][0] = sc.next();
			clients[i][1] = sc.next();
			
		}
		
    // 두 정보를 합쳐서 compartor로 0열 기준 오름차순 정렬해줌
		Arrays.sort(clients, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		
		
		for(int i = 0 ; i < clients.length ; i++) {
			System.out.println(clients[i][0] + " " + clients[i][1]);
		}
		
		
		
	}
}
