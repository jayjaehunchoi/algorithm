import java.util.Arrays;
import java.util.Scanner;

public class Baekjun {
	public int getMax(int[] a) {
		Arrays.sort(a);
		return a[a.length-1];
	}
	 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		Baekjun b = new Baekjun();
		int max = b.getMax(arr);
		for (int j = 0; j < arr.length; j++) {
			if(max == arr[j]) {
				System.out.println(max);
				System.out.println(j);
			}
		}				
	} 
}
