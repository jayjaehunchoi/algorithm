class Solution {
	
  
  // 이건쫌... 문제에 오류가 있는거같다. 설명이 불충분한데, 질문보기에서 추가 설명을 확인할 수 있었다.
	public static int fibonacci(int n) {
		
		int[] arr = new int[n+1];
		
		arr[0] =0;
		arr[1] =1;
		for(int i = 2 ; i < n+1 ; i++ ) {
			arr[i] = (arr[i-1]%1234567) + (arr[i-2]%1234567); 
		}
		
		return arr[n]%1234567;
		
	}
    public int solution(int n) {

        return fibonacci(n);
    }
}
