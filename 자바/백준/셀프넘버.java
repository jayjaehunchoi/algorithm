import java.util.ArrayList;

public class Generate {
	public Generate() {		
	}	
	private static ArrayList<Integer> listHasGenerator;

	private static void calculateListHasGenerate() {
		listHasGenerator = new ArrayList<Integer>(); 
		for (int i = 0 ; i < 5000 ; i++) {
			String number = String.valueOf(i);
			int no = 0;
			for (int n = 0; n < number.length(); n++){
				no += Integer.parseInt(number.substring(n, n+1));
			}
			listHasGenerator.add(no+i);
		}
		
	}
	private static boolean hasGenerator(int num) {
		return listHasGenerator.contains(num);
	}
	public static void main(String[] args) {
		Generate gener = new Generate();
		gener.calculateListHasGenerate();
		int sum = 0;
		for (int j = 0; j < 5000; j++) {
			if (!hasGenerator(j)) {
				sum += j;
			}		
		}
		System.out.println("합 : " + sum);		
	}
}
