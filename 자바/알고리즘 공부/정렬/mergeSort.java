
class Main {
	
  //n개의 index를 가진 배열을 1의 index를 가진 배열로 만들기 위해 2로 계속 나누는 작업 > log2n
  // n개를 두 배열로 만들기 위해 n/2 를 2개 만듦 ..... 매층마다 n/2^k * 2^k 식의 계산을 함 > n
  // 총 시간 복잡도 O(nlogn)
	public static void mergeSort(int[] arr, int start, int end) {
		
		if(start < end) {
			int mid = (start+end)/2;
      //첫 divide후 내부적으로 recursion을 통해 계속해서 divide해준다.
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			
      // divide가 마무리 된 배열부터 merge
			merge(arr,start,mid,end);
	
		}
		
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		
    // 시작, 두번째 배열 시작 지점 선언
    // merge할 임시 배열의 index 선언
		int i = start;
		int j = mid+1;
		int k = start;
		
    // merge할 임시 배열
		int[] temp = new int [arr.length];
    
    // 둘 중 하나라도 먼저 end 지점에 도달하면 stop
    // 그 전까지는 index순서대로 비교하며 임시 배열에 값 입력 
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		
    // 조건문을 달아서 둘 중하나가 실행되게끔
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
		while(j <= end) {
			temp[k++] = arr[j++];
		}
    // 기존 배열로 옮겨줌
		for(int num = start ; num <= end ; num++) {
			arr[num] = temp[num];
		}
		
		
	}
	
	public static void printArr(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 9, 8, 5, 4, 2, 3, 7, 6};
		
		mergeSort(arr, 0, arr.length-1);
		printArr(arr);
	}
}

	

