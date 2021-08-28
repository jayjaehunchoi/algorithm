import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	
	static int num = 0;
	static boolean[] check; 
	static String[] cardMade;
	static List<String> aList = new ArrayList<String>();
	public static void findNums(String[] cards, int count, int target ) {
		
		if(count == target) {
			String s = "";
			for(int i = 0 ; i < cardMade.length; i++) {
				s += cardMade[i];
			}
			
			if(!aList.contains(s)) {
				aList.add(s);
				num++;
			}
			return;
		}
		
		for(int i = 0 ; i < cards.length; i++) {
			if(!check[i]) {
				cardMade[count] = cards[i];
				check[i] = true;
				findNums(cards, count+1, target);
				check[i] = false;
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		String[] cards = new String[n];
		check = new boolean[n];
		cardMade = new String[k];
		
		for(int i = 0 ; i < n ; i++) {
			cards[i] = sc.next();
		}
		findNums(cards,0, k);
		System.out.println(num);

	}

}
	

