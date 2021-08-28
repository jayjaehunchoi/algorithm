
class Main {
	
	public static void swap(int idx, int n, int[] arr) {
		int temp = arr[idx];
		arr[idx]= arr[n];
		arr[n] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {11,5,39,77,45,2,14,25};
		
		int cnt = 0;		
		for(int i = 0 ; i < arr.length-1; i++) {
			int max = 0;
			int idx = 0;
			
			for(int j = 0 ; j < arr.length-cnt; j++) {
				if(arr[j] > max) {
					max = arr[j];
					idx = j;
				}
			}
			System.out.println(idx+ " : " + arr[idx] + " <-> " + (arr.length-cnt-1) + " : " + arr[arr.length-cnt-1]);
			swap(idx, arr.length-cnt-1, arr);
			cnt++;
		}
		
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}		
	}
}

// 최대값 도출, 매 끝값과 교환.

