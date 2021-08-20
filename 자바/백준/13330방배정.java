
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;
	
		int[][] students = new int[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			
			students[i][0] = sc.nextInt();
			students[i][1] = sc.nextInt();
		}
		
		Arrays.sort(students, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		Arrays.sort(students, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int studentCount = 1;
		for(int i = 0 ; i < students.length ; i++) {
			if(i != students.length-1) {
				if(students[i][0] != students[i+1][0] || students[i][1] != students[i+1][1]) {
					if(studentCount % k != 0) {
						count += studentCount/k+1;
						studentCount = 1;
					}else {
						count += studentCount/k;
						studentCount = 1;
					}
					continue;
				}
				if(students[i][0] == students[i+1][0]){
					studentCount++;
				}
			}

		}
		
		if(studentCount != 1) {
			if(studentCount % k != 0) {
				count += studentCount/k+1;
				studentCount = 1;
			}else {
				count += studentCount/k;
				studentCount = 1;
			}
		}else if(studentCount == 1) {
			count++;
		}
		
		System.out.println(count);
	}
}
