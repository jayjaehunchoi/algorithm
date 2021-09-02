import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		List<Integer> aList = new ArrayList<Integer>();
		
		for(int i = 0 ; i < n ; i++) {
			aList.add(i);
		}
		List<Integer> answerList = new ArrayList<Integer>();
		int i = k;
		while(aList.size() != 0 ) {
			
			i -= 1;
			
			while(i >= aList.size()) {
				i -= aList.size();
			}

			
			answerList.add(aList.remove(i)+1);
			
			i += k;
		}
		
		String s = "<";
		for(int j = 0 ; j < answerList.size() ; j++) {
			if( j != answerList.size()-1) {
				s += (answerList.get(j)+", ");
			}
			else {
				s += answerList.get(j);
			}
		}
		s += ">";
		System.out.println(s);
	}
}
