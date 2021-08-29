
class Main {
	
  //최악의 경우 n^2 하지만 최상의 경우에는 nlogn에 배열 복사가 없어 mergeSort보다 빠르다.
  
  // 피봇값을 선언하여 피봇보다 작은 값은 아래로, 큰값은 위로 정렬
	public static void quickSort(int[] arr, int start, int end) {
		if(start >= end) {
			return;
		}	
		int part = partition(arr, start, end);
		quickSort(arr, start, part-1);
		quickSort(arr, part+1, end);
	}
	
	public static int partition(int[] arr, int start, int end) {
		
		int i = start-1;
		int pivot = end;
    
    /*
		System.out.println("[[[[ pivot = " + pivot + " : pivot[values] = " + arr[pivot] + "]]]]");
		printArr(arr);
		System.out.println();
    */
    
		for(int j = start ; j <= pivot-1 ; j++) {
			if(arr[j] <= arr[pivot]) {
				i = i+1;
				swap(arr,i,j);
			}
		}
		
		swap(arr,i+1,pivot);
		
    /*
    printArr(arr);
		System.out.println();
		*/
    
    return i+1;
		
		
	}
	
	public static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	public static void printArr(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 9, 8, 5, 4, 2, 3, 7, 6};
		
		quickSort(arr, 0, arr.length-1);
		printArr(arr);

	}

}

	

