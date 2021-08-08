public class Solution {
/*
 1 3 5 4 4 (현재 수열)
 */
	
	public void nextPermutation(int [] nums) {
		
    // 뒤에서부터 오름차순이 처음으로 깨지는 순간을 발견
		int a = nums.length - 2;
		while(a >= 0 && nums[a] >= nums[a+1]) a--; // a = 1에서 끊김 (값은 3)
		
    // 수열 중 a 다음으로 작은 수열탐색
		if(a != -1) {
			int b = nums.length -1;
			while(nums[a] >= nums[b]) b--; // b = 4에서 바로 끊김 
			swap(nums,a,b); // a <=> b {1 4 5 4 3}
		}
    // 스왑한 다음 수부터 끝까지 오름차순 정렬
    // 첫값, 맨뒷값 쭉쭉 비교해가며 교대
		int start = a+1;
		int end = nums.length-1;
		while(start < end) {
			swap(nums,start++,end--);
		}
		
		
	}
	
  // 두 값을 바꿔주는 메소드
	public void swap (int[] nums , int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[a];
		nums[b] = tmp;
	}
}
