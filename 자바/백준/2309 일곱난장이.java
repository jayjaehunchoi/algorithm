import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	static int[] dwarfs = new int[9];
	static int[] dwarfs7 = new int[7];
	static int[] answer = new int[7];
	static boolean[] check = new boolean[9];
	
	public static void find7(int count, int index) {
		if(count == 7) {
			int sum = 0;
			for(int i = 0 ; i < 7; i++) {
				
				sum += dwarfs7[i];
				
			}
			if(sum == 100) {
				answer = dwarfs7;
				Arrays.sort(answer);
				for(int i = 0 ; i < 7; i++) {
					System.out.println(answer[i]);	
				}
				
			}
			return;
		}
		
		for(int i = index ; i < 9; i++) {
			if(!check[i]) {
				dwarfs7[count] = dwarfs[i];
				check[i] = true;
				find7(count+1, i);
				check[i] = false;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0 ; i < 9 ; i ++) {
			dwarfs[i] = sc.nextInt();
		}
		find7(0, 0);
	}

}
	

