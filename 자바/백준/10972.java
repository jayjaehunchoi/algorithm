import java.util.Scanner;


class Main {
	
	static int count = 0;
	public static void permutation(int[] arr) {
		
		int a = arr.length-2;
		
		while(a >= 0 && arr[a] >= arr[a+1])a--;
		
		if (a != -1) {
			int b = arr.length-1;
			while(arr[a] >= arr[b]) b--;
			swap(arr,a,b);
		}
		else if(a==-1) {
			count = -1;
		}
		
		int start = a+1;
		int end = arr.length-1;
		while(start < end) {
			if(arr[start] > arr[end]) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
			
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i = 0 ; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			
			permutation(arr);
			
			if(count == -1) {
				System.out.println(count);
				return;
			}
			
			for(int a: arr) {
				System.out.print(a + " ");
			}
		
	}
}
