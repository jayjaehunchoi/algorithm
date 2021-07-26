import java.util.ArrayList;
import java.util.Scanner;

public class Baekjun {

	
	public static void sameDistance(int number) {
		int count = 0;
		for (int i = 1; i <= number; i++) {
			int totalNum = 0;
			int subNum = 0;
			String eachNum = Integer.toString(i);
			ArrayList<Integer> aList = new ArrayList<Integer>();
			
			if (i < 100) {
				count += 1;
			}
			
			else {
				for(int j = 0; j < eachNum.length(); j++) {
					aList.add(Integer.parseInt(eachNum.substring(j,j+1)));
				}
				for(int j = 1; j < aList.size(); j++) {
					subNum = aList.get(j) - aList.get(j-1);
					totalNum += subNum;
					
				}
				if (totalNum == subNum * (aList.size()-1)) {
					count += 1;
				}
			}
		}
		System.out.println(count);
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sameDistance(N);
  }

}
