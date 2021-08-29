
class Main {

	public static void main(String[] args) {
		int[] arr = {15,12,13,10,14,11};
		
    // 첫번째 자리부터 이전값이랑 비교하면 됨.
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			
      //j값이 0이상, arr[j]값이 저장값보다 크면 비교값을 다음 인덱스로 정렬해줌
			while(j >= 0 && temp < arr[j]) {
				
				arr[j+1] = arr[j];
				j--;
				
			}
			
			arr[j+1] = temp;
		
		}
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}

	

